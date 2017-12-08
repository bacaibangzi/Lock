package com.sc.system.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.framework.enums.UserShEnum;
import com.sc.framework.enums.UserTypeEnum;
import com.sc.framework.utils.StringUtil;
import com.sc.system.dao.OrgInfoMapper;
import com.sc.system.dao.UserInfoMapper;
import com.sc.system.dao.UserRoleMapper;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRole;

@Service
public class IMerchantUser {
	/** system模块dao */
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	OrgInfoMapper orgInfoMapper;
	@Autowired
	UserRoleMapper userRoleMapper;

	/**
	 * @brief 功能: 新增/修改
	 * @param entity
	 *            : MerchantUser对象
	 * @throws Exception 
	 */
	public void saveMerchantUser(UserInfo entity) throws Exception {
			
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			//conditionMap.put("oiCode", "0000");
			String code = userInfoMapper.nextValue(conditionMap);
			
			OrgInfo orgInfo = new OrgInfo();
			orgInfo.setOiCode(code);
			orgInfo.setOiName(entity.getUiCompany());
			
			entity.setUiId(Long.parseLong(code));
			entity.setUiOrgCode(code);
			entity.setUiType(UserTypeEnum.merchant.id());
			entity.setUiSh(UserShEnum.sh.id());
			entity.setUiPassword(StringUtil.encodeStr(entity.getUiPassword()));
			
			userInfoMapper.insertSn(entity);//用户插入
			
			// 注册时默认开发者权限
			UserRole userRole = new UserRole();
			userRole = new UserRole();
			userRole.setRiId(3L);
			userRole.setUiId(Long.parseLong(code));
			userRoleMapper.insert(userRole);
	}
	
	

	/**
	 * @brief 功能: 根据id进行删除
	 * @param systemId
	 *            : 待删除对象id
	 * @return true: 成功；false: 失败
	 */
	public boolean deleteSystemUserById(Long systemId) {
		return false;
	}

	/**
	 * @brief 功能: 根据id进行查询
	 * @param systemId
	 *            : 待查询对象id
	 * @return SystemUser: 查询结果对象
	 */
	public UserInfo getSystemUserById(Long systemId) {
		return null;
	}

	/**
	 * @brief 功能: 分页查询
	 * @param conditionMap
	 *            : 查询条件
	 * @param page
	 *            : 分页对象
	 * @throws Exception 
	 */
	public List<UserInfo> querySystemUsersForPage(
			Map<String, Object> conditionMap) throws Exception {
		List<UserInfo> list = userInfoMapper.findPage(conditionMap);
		return list;
	}

	/**
	 * 根据用户登录名称查找用户信息
	 * 
	 * @param uiLoginName
	 * @return
	 */
	public UserInfo getSystemUserByLoginName(String uiLoginName) {
		return userInfoMapper.getByLoginName(uiLoginName);
	}



	public void updateMerchantUser(UserInfo userInfo) throws Exception {
		userInfoMapper.updatepassword(userInfo);//密码更新
	}


	/**
	 * 根据用户名称查找用户信息
	 * 
	 * @param uiLoginName
	 * @return
	 */
	public UserInfo getSystemUserByUIName(String loginUserName) {
		// TODO Auto-generated method stub
		return userInfoMapper.getByUIName(loginUserName);
	}
}
