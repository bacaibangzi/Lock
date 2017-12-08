package com.sc.teminal.action;

import java.text.DecimalFormat;
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
import com.sc.teminal.pojo.Doorswipedata;
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.service.ControllerinfoService;
import com.sc.teminal.service.DevDoorGroupService;
import com.sc.teminal.service.DevDoorTeminalService;
import com.sc.teminal.service.DoorswipedataService;
import com.sc.teminal.service.TerminalinfoService;

@Controller
@RequestMapping("/battery")
public class BatteryAction  extends BaseAction{

	@Autowired
	DevDoorGroupService devDoorGroupService;
	@Autowired
	DevDoorTeminalService devDoorTeminalService;
	@Autowired
	TerminalinfoService terminalinfoService;
	@Autowired
	ControllerinfoService controllerinfoService;
	@Autowired
	DoorswipedataService doorswipedataService;
	@Autowired
	UserOrgsService userOrgsService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/batteryFrame";
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

		return "teminal/batteryLeftTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Terminalinfo> terminalinfoList = devDoorTeminalService.queryDl(vo);
		
		/*
		for(Terminalinfo terminalinfo : terminalinfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("one", terminalinfo);
			vo.setCode("25");
			vo.setCode1(terminalinfo.getDevCode()+"");
			List<Doorswipedata> doorswipedataList = doorswipedataService.queryDoorswipedatasByCondition(vo);
			if(doorswipedataList!=null&&doorswipedataList.size()>0){
				float dl = (Float.parseFloat(doorswipedataList.get(0).getCardNo())/1024)*6.6F;
				
				map.put("two", (new DecimalFormat("#.0").format(dl)).toString());
			}else{
				map.put("two", "-1");
			}
			list.add(map);
		}*/
		for(Terminalinfo terminalinfo : terminalinfoList){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("one", terminalinfo);
			if(terminalinfo.getDl()!=null&&!"".equals(terminalinfo.getDl())){
				map.put("two", (new DecimalFormat("#.0").format(Float.parseFloat(terminalinfo.getDl()))).toString());
			}else{
				map.put("two","");
			}
			list.add(map);
		}
		
		request.setAttribute("list", list);
		return "teminal/batteryCenter";
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Terminalinfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Terminalinfo> list = devDoorTeminalService.queryDevDoorTeminalsForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	
	@RequestMapping(value = "/terminalinfoList.htm", method = RequestMethod.POST)
	@ResponseBody
	public void terminalinfoList(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Terminalinfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Terminalinfo> list = terminalinfoService.queryTerminalinfosForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	
 
	


}
