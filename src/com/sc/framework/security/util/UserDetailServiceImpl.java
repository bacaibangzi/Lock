package com.sc.framework.security.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sc.framework.session.interfaces.ISession;
import com.sc.framework.utils.StringUtil;
import com.sc.system.dao.OrgInfoMapper;
import com.sc.system.interfaces.IMerchantUser;
import com.sc.system.interfaces.IUserRoleMenu;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRoleMenu;
import com.sc.system.service.OrgInfoService;

/**
 * FileName: UserDetailServiceImpl.java Description: 实现ACEGI
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private static Logger log = LoggerFactory
			.getLogger(UserDetailServiceImpl.class);

	@Autowired
	IMerchantUser iSystemUser;
	@Autowired
	ISession iSession;
	@Autowired
	IUserRoleMenu iUserRoleMenu;
	@Autowired
	OrgInfoMapper orgInfoMapper;
	@Autowired
	OrgInfoService orgInfoService;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		System.out
				.println("================================登录验证===============================================");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		List<GrantedAuthority> authsList = new ArrayList<GrantedAuthority>();
		// 等待添加权限查询代码

		Map<String, Object> conditionMap = new HashMap<String, Object>();

		UserInfo userInfo = null;
		try {
			userInfo = iSystemUser.getSystemUserByLoginName(userName);
		} catch (Exception e) {
			log.error("登录查询异常", e);
			throw new UsernameNotFoundException(
					AccountConstants.ACCOUNT_DB_ERROR);
		}
		if (iSession.needCheckErrorTimes()) {
			String key = userName;
			int failTimes = iSession.getErrorTimes(key);
			int sysAllowErrorTimes = iSession.getSysAllowErrorTimes();
			int fobiddenMinues = iSession.getSysFobiddenMinues();
			if (failTimes >= sysAllowErrorTimes) {
				log.info("账户登录失败超过{}次，限制登录，{}分钟以后才能正常登录", sysAllowErrorTimes,
						fobiddenMinues);
				throw new UsernameNotFoundException(
						AccountConstants.ACCOUNT_LOGIN_ERROR_FOBIDDEN);
			}
		}
		// 判断用户是否存在
		if (userInfo == null) {
			log.info("账户" + userName + "不存在");
			throw new UsernameNotFoundException(
					AccountConstants.ACCOUNT_LOGIN_AUTH_ERROR);
		}
		// 如果账户存在，则尝试获取其员工姓名。
		else {
			// 判断用户是否审核
			//if ("0".equals(userInfo.getUiSh())) {
			if (userInfo.getUiSh().intValue()==0) {
				log.info("账户" + userName + "未审核");
				throw new UsernameNotFoundException(
						AccountConstants.ACCOUNT_NOT_SH);
			}
			else if (userInfo.getUiSh().intValue()==9) {
				log.info("账户" + userName + "停用");
				throw new UsernameNotFoundException(
						AccountConstants.ACCOUNT_NOT_SY);
			}
		}

		System.out.println(" 登录账号信息： " + userInfo);

		List<UserRoleMenu> topMenu;
		List<UserRoleMenu> leftMenu;

		AccountInfo accountInfo = null;
		OrgInfo orgInfo = null;
		try {
			conditionMap = new HashMap<String, Object>();
			List<UserRoleMenu> userRoleMenuAll = iUserRoleMenu
					.queryUserRoleMenuAll(conditionMap);

			for (UserRoleMenu userRoleMenu : userRoleMenuAll) {
				authsList.add(new GrantedAuthorityImpl(String
						.valueOf(userRoleMenu.getMiId())));
			}
			// 添加一级菜单
			conditionMap = new HashMap<String, Object>();
			conditionMap.put("userId", userInfo.getUiId());
			conditionMap.put("miLevel", 1);
			topMenu = iUserRoleMenu.queryUserRoleMenuAll(conditionMap);

			// 添加二级菜单
			conditionMap = new HashMap<String, Object>();
			conditionMap.put("userId", userInfo.getUiId());
			conditionMap.put("miLevel", 2);
			leftMenu = iUserRoleMenu.queryUserRoleMenuAll(conditionMap);

			accountInfo = new AccountInfo(userInfo.getUiLoginName(), StringUtil.decodeStr(userInfo
					.getUiPassword()), true, true, true, true, authsList);

			// 添加用户可以访问的功能列表信息
			accountInfo.setAccountCode("code1");
			accountInfo.setAccountId(userInfo.getUiId());
			accountInfo.setUserName(userInfo.getUiName());
			accountInfo.setUserId(userInfo.getUiId());
			accountInfo.setOrgCode(userInfo.getUiOrgCode());
			accountInfo.setUserImg(userInfo.getUiImg());
			
			
			
			for (UserRoleMenu menu : topMenu) {
				String key = String.valueOf(menu.getMiId());
				accountInfo.getTopMenu().put(key, menu);
				System.out.println("miname: ####>"+menu.getMiName());
				LinkedList<UserRoleMenu> leftM = seachLeftMenu(leftMenu, key);
				accountInfo.getLeftMenu().put(key, leftM);
				// 跟功能设置引导页面
				if (leftM.size() > 0) {
					menu.setIndexMenu(leftM.get(0));
					menu.setLeftMenus(leftM);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		topMenu = null;
		leftMenu = null;
		orgInfo = null;
		return accountInfo;
	}

	private LinkedList<UserRoleMenu> seachLeftMenu(List<UserRoleMenu> leftMenu,
			String key) {
		LinkedList<UserRoleMenu> menu = new LinkedList<UserRoleMenu>();
		for (int i = leftMenu.size() - 1; i >= 0; i--) {
			if (key.equals(String.valueOf(leftMenu.get(i).getFiId()))) {
				menu.add(leftMenu.get(i));
				leftMenu.remove(i);
			}
		}
		Collections.reverse(menu);
		return menu;
	}
	
	/**
	 * 获取最高门店信息
	 * 
	 * @param orgCode
	 * @return
	 * @throws Exception
	 */
	public String getZongdCode(String orgCode){
		try {
			OrgInfo orgInfo = orgInfoService.findMengdByOrgCode(orgCode);
			if (orgInfo != null) {
				return orgInfo.getOiCode();
			} else {
				if(orgCode.length()<4){
					return "0";
				}
				
				orgCode = orgCode.substring(0, orgCode.length()-4);
				return getZongdCode(orgCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
}
