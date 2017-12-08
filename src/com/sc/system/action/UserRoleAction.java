package com.sc.system.action;

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
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.RoleInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRole;
import com.sc.system.service.RoleInfoService;
import com.sc.system.service.UserInfoService;
import com.sc.system.service.UserRoleService;

/**
 * 用户角色
 * 
 * @author cuibin
 * 
 */
@Controller
@RequestMapping("/userrole")
public class UserRoleAction extends BaseAction {
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	UserInfoService userInfoService;

	/**
	 * 用户角色页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/userRoleFrame";
	}

	/**
	 * 用户列表页面（只显示审核通过的用户）
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftList.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		return "system/userRoleLeftList";
	}

	/**
	 * 加载审核通过的用户列表页面
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
		Page<UserInfo> list = userInfoService.queryUserInfosForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	

	/**
	 * 保存用户角色
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveUserRole.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveUserRole(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		try {
			userRoleService.saveOrUpdateUserRole(vo);
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
		List<RoleInfo> roleInfo = roleInfoService.queryRoleInfosByCondition(vo);
		// 用户角色
		List<UserRole> userRole = userRoleService.queryUserRoleByCondition(vo);
		List<Map<String, Object>> nodeList = getRoleTreeNode(roleInfo,userRole,path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		
		return "system/userRoleRightTree";
	}
	
	/**
	 * 商户角色tree页面
	 * @return
	 */
	@RequestMapping(value = "/businessmenTree.htm", method = RequestMethod.GET)
	public String businessmenTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		String path = "../application/images/icon/org_start.png";
		// tree角色
		List<RoleInfo> roleInfo = roleInfoService.queryRoleInfosByCondition(vo);
		// 用户角色
		List<UserRole> userRole = userRoleService.queryUserRoleByCondition(vo);
		List<Map<String, Object>> nodeList = getRoleTreeNode(roleInfo,userRole,path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		
		return "system/businessmenTree";
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
