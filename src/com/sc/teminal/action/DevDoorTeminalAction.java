package com.sc.teminal.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
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
import com.sc.teminal.pojo.Controllerinfo;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.pojo.Devcmdresult;
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.service.ControllerinfoService;
import com.sc.teminal.service.DevDoorGroupService;
import com.sc.teminal.service.DevDoorTeminalService;
import com.sc.teminal.service.DevcmdresultService;
import com.sc.teminal.service.TerminalinfoService;

@Controller
@RequestMapping("/devDoorTeminal")
public class DevDoorTeminalAction extends BaseAction{

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
	@Autowired
	DevcmdresultService devcmdresultService;
	
	@RequestMapping(value = "/getCmdResult.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> getCmdResult(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		String msg = "";
		Devcmdresult devcmdresult = devcmdresultService.getDevcmdresultById(vo);
		if(devcmdresult!=null){
			msg = "指令ID:"+devcmdresult.getDevCmdId()+"的执行结果,ErrNo:"+devcmdresult.getErrNo()+",ErrMsg:"+devcmdresult.getErrMsg();
			map.put("msg", msg);
		}
		return map;
	}

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/devDoorTeminalFrame";
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

		return "teminal/devDoorTeminalLeftTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/devDoorTeminalCenter";
	}

	@RequestMapping(value = "/cmd.htm", method = RequestMethod.GET)
	public String cmd(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/devDoorTeminalCmd";
	}

	@RequestMapping(value = "/result.htm", method = RequestMethod.GET)
	public String result(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		vo.setCode1(java.net.URLDecoder.decode(vo.getCode1(),"UTF-8"));
		request.setAttribute("vo", vo);
		return "teminal/devDoorTeminalResult";
	}
	
	
	// 延时关闭
	@RequestMapping(value = "/yanSgb.htm", method = RequestMethod.GET)
	public String yanSgb(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/yanSgb";
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
		Page<Terminalinfo> list = terminalinfoService.queryTerminalinfosForPage1(vo, page);
		super.readerPage2Json(list, response);
	}
	

	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		LinkedHashMap<String,String> controllerinfoMap = new LinkedHashMap<String,String>();
		List<Controllerinfo> controllerinfoList = controllerinfoService.queryControllerinfosByCondition(vo);
		for(Controllerinfo controllerinfo : controllerinfoList){
			controllerinfoMap.put(controllerinfo.getControllerId()+"", controllerinfo.getControllerName());
		}
		request.setAttribute("controllerinfoMap", controllerinfoMap);
		DevDoorGroup.setFisn(Integer.parseInt(vo.getCode()));
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(devDoorGroupService.getDevDoorGroupById(vo),DevDoorGroup);
		}
		return "teminal/devDoorTeminalEidt";
	}
	
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(devDoorGroupService.getDevDoorGroupById(vo),DevDoorGroup);
		return "teminal/devDoorTeminalDetail";
	}
	
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		//vo.setCode(DevDoorGroup.getFisn().toString());
		request.setAttribute("vo", vo);
		devDoorTeminalService.saveOrUpdateDevDoorTeminalInfo(vo);
		return "true";
	}
	
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		devDoorTeminalService.deleteDevDoorTeminalById(vo);
		return "teminal/devDoorTeminalCenter";
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
