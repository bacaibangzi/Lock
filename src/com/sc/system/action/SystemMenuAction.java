package com.sc.system.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.SystemMenu;
import com.sc.system.service.SystemMenuService;

/**
 * 系统菜单
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/menu")
public class SystemMenuAction  extends BaseAction{

	@Autowired
	SystemMenuService systemMenuService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/menuFrame";
	}

	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		// 加载区域tree // 图片路径
		String path = "../application/images/icon/org_start.png";
		List<SystemMenu> list = systemMenuService.querySystemMenusByCondition(vo);
		List<Map<String, Object>> nodeList = getMenuTreeNode(list, path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "system/menuLeftTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "system/menuCenter";
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<SystemMenu> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<SystemMenu> list = systemMenuService.querySystemMenusForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") SystemMenu systemMenu,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(systemMenuService.getSystemMenuById(vo),systemMenu);
		}
		return "system/menuEidt";
	}
	
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") SystemMenu systemMenu,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(systemMenuService.getSystemMenuById(vo),systemMenu);
		return "system/menuDetail";
	}
	
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute SystemMenu systemMenu,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		systemMenuService.saveOrUpdateSystemMenuInfo(systemMenu);
		return "system/menuCenter";
	}
	
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		systemMenuService.deleteSystemMenuById(vo);
		return "system/menuCenter";
	}
	
	
	public List<Map<String, Object>> getMenuTreeNode(List<SystemMenu> orgList,
			String path) {
		List<SystemMenu> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (SystemMenu menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getMiId().toString());
			map.put("checkAble", "false");
			map.put("text", menu.getMiName());
			map.put("value", menu.getMiId().toString());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			map.put("pid", menu.getFiId());
			map.put("ChildNodes", new ArrayList());
			map.put("code", menu.getMiId().toString());
			map.put("imgPath", path);
			nodeList.add(map);
		}
		return nodeList;
	}
}
