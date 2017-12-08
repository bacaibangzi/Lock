package com.sc.merchantset.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.merchantset.service.MerchanterServerService;
import com.sc.merchantset.service.MerchantserService;
import com.sc.merchantset.service.ServerService;
import com.sc.system.pojo.RoleInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRole;

/**
 * 商户对应服务action
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/merchantserServer")
public class MerchanterServerAction extends BaseAction {
	@Autowired
	MerchanterServerService merchanterServerService;
	@Autowired
	ServerService serverService;
	@Autowired
	MerchantserService merchantserService;
	
	
	/**
	 * 注册商户分配服务页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "merchantset/merchanterServerFrame";
	}
	
	
	/**
	 * 注册商户列表页面（只显示审核通过的注册商户）
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftList.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		return "merchantset/merchantserServerLeftList";
	}
	
	/**
	 * 加载审核通过的注册商户列表页面
	 * 
	 * @param vo
	 * @param page
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<UserInfo> page, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		super.setPageInfo(page);
		vo.setShFilter("1");
		Page<UserInfo> list = merchantserService.queryMerchantsersForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	
	
	/**
	 * 保存注册商户服务
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveMerchantserServer.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveUserRole(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		try {
			merchanterServerService.saveOrUpdateMerchanterServer(vo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 角色tree页面
	 * @return
	 */
	@RequestMapping(value = "/rightTree.htm", method = RequestMethod.GET)
	public String rightTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		String path = "../application/images/icon/org_start.png";
		// tree角色
		List<RoleInfo> roleInfo = serverService.queryServerByCondition(vo);
		// 用户角色
		List<UserRole> userRole = merchanterServerService.queryMerchanterServerByCondition(vo);
		List<Map<String, Object>> nodeList = getRoleTreeNode(roleInfo,userRole,path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		
		return "merchantset/merchantserServerRightTree";
	}
	
	
	/**
	 * 角色tree页面（继承）
	 * @return
	 */
	@RequestMapping(value = "/rightTreeExtend.htm", method = RequestMethod.GET)
	public String rightTreeExtend(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		String path = "../application/images/icon/org_start.png";
		// tree角色
		List<RoleInfo> roleInfo = serverService.queryServerByCondition(vo);
		// 当前用户权限
		ConditionVO _vo = new ConditionVO();
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("accountInfo");
		_vo.setId(accountInfo.getUserId());
		List<UserRole> _userRole = merchanterServerService.queryMerchanterServerByCondition(_vo);
		
		List<RoleInfo> _roleInfo = new ArrayList<RoleInfo>();
		
		for(RoleInfo role : roleInfo){
			for(UserRole uRole:_userRole){
				if(uRole.getRiId()==role.getRiId()){
					_roleInfo.add(role);
					continue;
				}
			}
		}
		
		
		// 用户角色
		List<UserRole> userRole = merchanterServerService.queryMerchanterServerByCondition(vo);
		List<Map<String, Object>> nodeList = getRoleTreeNode(_roleInfo,userRole,path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		
		return "merchantset/merchantserServerRightTreeExtend";
	}
	
	
	
	public List<Map<String, Object>> getRoleTreeNode(List<RoleInfo> roleInfo,List<UserRole> userRole,
			String path) {
		List<RoleInfo> list = roleInfo;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		
		for (RoleInfo role : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", role.getRiId().toString());
			map.put("checkAble", "false");
			map.put("text", role.getRiName());
			map.put("value", role.getRiId());
			map.put("showcheck", true);
			map.put("complete", true);
			map.put("isexpand", false);
			//map.put("checkstate", checked);
			map.put("hasChildren", false);
			map.put("pid", -1);
			map.put("ChildNodes", new ArrayList());
			map.put("code", role.getRiId());
			map.put("imgPath", path);
			String checked = "0";
			for(UserRole ur : userRole){
				if(ur.getRiId().longValue()==role.getRiId().longValue()){
					checked = "1";
					break;
				}
			}
			
			map.put("checkstate", checked);
			nodeList.add(map);
		}
		return nodeList;
	}
}
