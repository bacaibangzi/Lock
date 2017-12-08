package com.sc.system.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.pojo.RoleMenu;
import com.sc.system.pojo.SystemMenu;
import com.sc.system.service.RoleInfoService;
import com.sc.system.service.RoleMenuService;
import com.sc.system.service.SystemMenuService;

/**
 * 角色权限
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/rolemenu")
public class RoleMenuAction extends BaseAction{
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	SystemMenuService systemMenuService;
	@Autowired
	RoleMenuService roleMenuService;
	
	/**
	 * 角色权限页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/roleMenuFrame";
	}
	
	/**
	 * 保存角色菜单
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/saveRoleMenu.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveRoleMenu(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		try {
			roleMenuService.saveOrUpdateRoleMenu(vo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 角色列表页面
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftList.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
 
		return "system/roleMenuLeftList";
	}
	
	/**
	 * 权限tree页面
	 * @return
	 */
	@RequestMapping(value = "/rightTree.htm", method = RequestMethod.GET)
	public String rightTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		String path = "../application/images/icon/org_start.png";
		// tree菜单
		List<SystemMenu> menuList = systemMenuService.querySystemMenusByCondition(vo);
		// 相对应的菜单
		List<RoleMenu> roleMenuList = roleMenuService.queryRoleMenusByCondition(vo);
		List<Map<String, Object>> nodeList = getMenuTreeNode(menuList,roleMenuList,path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		
		return "system/roleMenuRightTree";
	}
	
	
	public List<Map<String, Object>> getMenuTreeNode(List<SystemMenu> menuList, List<RoleMenu> roleMenuList,
			String path) {
		List<SystemMenu> list = menuList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		
		for (SystemMenu menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMiId().toString());
			map.put("checkAble", "false");
			map.put("text", menu.getMiName());
			map.put("value", menu.getMiId().toString());
			map.put("showcheck", true);
			map.put("complete", true);
			map.put("isexpand", false);
			//map.put("checkstate", checked);
			map.put("hasChildren", false);
			map.put("pid", menu.getFiId());
			map.put("ChildNodes", new ArrayList());
			map.put("code", menu.getMiId().toString());
			map.put("imgPath", path);
			String checked = "0";
			for (RoleMenu role : roleMenuList) {
				if (role.getMiId().longValue() == menu.getMiId().longValue()) {
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
