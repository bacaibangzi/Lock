package com.sc.teminal.action;

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
import com.sc.system.pojo.UserOrgs;
import com.sc.system.service.UserOrgsService;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.service.ControllerinfoService;
import com.sc.teminal.service.DevDoorGroupService;
import com.sc.teminal.service.DevDoorTeminalService;
import com.sc.teminal.service.TerminalinfoService;


@Controller
@RequestMapping("/chongFa")
public class ChongFaAction  extends BaseAction{


	@Autowired
	DevDoorGroupService devDoorGroupService;
	@Autowired
	DevDoorTeminalService devDoorTeminalService;
	@Autowired
	TerminalinfoService terminalinfoService;
	@Autowired
	ControllerinfoService controllerinfoService;
	@Autowired
	UserOrgsService userOrgsService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/chongFaFrame";
	}

	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		// 加载区域tree // 图片路径
		String path = "../application/images/icon/org_start.png";
		List<DevDoorGroup> list = devDoorGroupService.queryDevDoorGroupsByCondition(vo);
		vo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
		List<UserOrgs> userOrgs = userOrgsService.queryUserOrgsById(vo); 
		
		List<Map<String, Object>> nodeList = DevDoorGroupAction.getMenuTreeNode(list, path,userOrgs);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "teminal/chongFaLeftTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/chongFaCenter";
	}

 

	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Terminalinfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Terminalinfo> list = devDoorTeminalService.queryDevDoorTeminalsForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	
 
	/*
	public List<Map<String, Object>> getMenuTreeNode(List<DevDoorGroup> orgList,
			String path) {
		List<DevDoorGroup> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (DevDoorGroup menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getSn().toString());
			map.put("checkAble", "false");
			map.put("text", menu.getName());
			map.put("value", menu.getSn().toString());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			map.put("pid", menu.getFisn());
			map.put("ChildNodes", new ArrayList());
			map.put("code", menu.getSn().toString());
			map.put("imgPath", path);
			nodeList.add(map);
		}
		return nodeList;
	}*/
}
