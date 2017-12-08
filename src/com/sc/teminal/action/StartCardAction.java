package com.sc.teminal.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.sc.framework.utils.DateConvertUtils;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.pojo.UserOrgs;
import com.sc.system.service.DevUserCardService;
import com.sc.system.service.UserOrgsService;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.service.DevDoorGroupService;

@Controller
@RequestMapping("/startCard")
public class StartCardAction  extends BaseAction{
	@Autowired
	DevUserCardService devUserCardService;
	@Autowired
	DevDoorGroupService devDoorGroupService;
	@Autowired
	UserOrgsService userOrgsService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "card/startCardFrame";
	}
	
	@RequestMapping(value = "/leftList.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		LinkedHashMap<String,String> flagMap = new LinkedHashMap<String,String>();
		flagMap.put("-1", "全部");
		flagMap.put("1", "正常");
		flagMap.put("0", "已挂失");
		
		
		
		Calendar calendar = Calendar.getInstance();
	    Date date = new Date(System.currentTimeMillis());
	    calendar.setTime(date);
	    calendar.add(Calendar.YEAR, 1);
	    date = calendar.getTime();
		
	    String rqStr = DateConvertUtils.format(date,"yyyy-MM-dd HH:mm");
		
	    request.setAttribute("rqStr", rqStr);
		request.setAttribute("flagMap", flagMap);
		return "card/startCardLeftList";
	}
	
	@RequestMapping(value = "/rightCenter.htm", method = RequestMethod.GET)
	public String rightCenter(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		return "card/rightCenter";
	}
	

	
	@RequestMapping(value = "/rightCenterTop.htm", method = RequestMethod.GET)
	public String rightCenterTop(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		// 加载区域tree // 图片路径
		String path = "../application/images/icon/org_start.png";
		List<DevDoorGroup> list = devDoorGroupService.queryDevDoorGroupsByCondition(vo);
		vo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
		List<UserOrgs> userOrgs = userOrgsService.queryUserOrgsById(vo); 
		
		List<Map<String, Object>> nodeList = DevDoorGroupAction.getMenuTreeNode(list, path,userOrgs);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		return "card/rightCenterTop";
	}
	
	@RequestMapping(value = "/rightCenterDown.htm", method = RequestMethod.GET)
	public String rightCenterDown(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		return "card/rightCenterDown";
	}
	
	
	@RequestMapping(value = "/list1.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list1(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<DevUserCard> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<DevUserCard> list = devUserCardService.queryDevUserCardsForPage(vo, page);
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
