package com.sc.teminal.action;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.service.DevDoorGroupService;

@Controller
@RequestMapping("/devDoorGroup")
public class DevDoorGroupAction   extends BaseAction{

	@Autowired
	DevDoorGroupService devDoorGroupService;
	@Autowired
	UserOrgsService userOrgsService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/devDoorGroupFrame";
	}

	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		// 加载区域tree // 图片路径
		String path = "../application/images/icon/org_start.png";
		List<DevDoorGroup> list = devDoorGroupService.queryDevDoorGroupsByCondition(vo);
		
		vo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
		List<UserOrgs> userOrgs = userOrgsService.queryUserOrgsById(vo); 
		
		List<Map<String, Object>> nodeList = getMenuTreeNode(list, path,userOrgs);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "teminal/devDoorGroupLeftTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/devDoorGroupCenter";
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<DevDoorGroup> page, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		super.setPageInfo(page);
		vo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
		Page<DevDoorGroup> list = devDoorGroupService.queryDevDoorGroupsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		DevDoorGroup.setFisn(Integer.parseInt(vo.getCode()));
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(devDoorGroupService.getDevDoorGroupById(vo),DevDoorGroup);
		}
		return "teminal/devDoorGroupEidt";
	}
	
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(devDoorGroupService.getDevDoorGroupById(vo),DevDoorGroup);
		return "teminal/devDoorGroupDetail";
	}
	
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute DevDoorGroup DevDoorGroup,HttpServletRequest request) throws Exception{
		vo.setCode(DevDoorGroup.getFisn().toString());
		request.setAttribute("vo", vo);
		devDoorGroupService.saveOrUpdateDevDoorGroupInfo(DevDoorGroup);
		vo.setErrMsg("true");
		return "teminal/devDoorGroupCenter";
	}
	
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		devDoorGroupService.deleteDevDoorGroupById(vo);
		vo.setErrMsg("true");
		return "teminal/devDoorGroupCenter";
	}
	
	
	public static List<Map<String, Object>> getMenuTreeNode(List<DevDoorGroup> orgList,
			String path, List<UserOrgs> userOrgsList) {
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
			
			String checked = "0";
			for(UserOrgs userOrgs:userOrgsList){
				if (userOrgs.getOrgCode().equals(menu.getSn().toString())) {
					checked = "1";
					break;
				}
			}
			if("0".equals(checked)){
				nodeList.add(map);
			}
		}
		return nodeList;
	}

}
