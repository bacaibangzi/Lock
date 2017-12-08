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
import com.sc.framework.enums.OrgTypeEnum;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserOrgs;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.UserOrgsService;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.service.DevDoorGroupService;


@Controller
@RequestMapping("/userOrgs")
public class UserOrgsAction  extends BaseAction {

	@Autowired
	UserOrgsService userOrgsService;
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	DevDoorGroupService devDoorGroupService;
	
	@RequestMapping(value = "/orgTree.htm", method = RequestMethod.GET)
	public String orgTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		// 加载组织机构tree 图片路径
		String path = "../application/images/icon/org_start.png";
		//List<OrgInfo> list = orgInfoService.queryOrgInfosByOrgCode(vo);
		 
		/*
		// 相应的数据权限
		
		List<Map<String, Object>> nodeList = getOrgTreeNodeWithCheckBox(list, path, vo
				.getOrgCode(),userOrgs);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		*/

		List<UserOrgs> userOrgs = userOrgsService.queryUserOrgsById(vo); 
		
		List<DevDoorGroup> list = devDoorGroupService.queryDevDoorGroupsByCondition(vo);
		List<Map<String, Object>> nodeList = getMenuTreeNode(list, path,userOrgs);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "system/selectUserOrgsTree";
	}

	

	
	@RequestMapping(value = "/orgTreeRadio.htm", method = RequestMethod.GET)
	public String orgTreeRadio(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		System.out.println("_____________________________ :"+vo.getUserId());

		// 加载组织机构tree 图片路径
		String path = "../application/images/icon/org_start.png";
		List<OrgInfo> list = orgInfoService.queryOrgInfosByOrgCode(vo);
		
		
		List<Map<String, Object>> nodeList = super.getOrgTreeNode(list, path, vo.getOrgCode());
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "system/selectUserOrgsTreeRadio";
	}
	
	@RequestMapping(value = "/saveUserOrgs.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean saveUserOrgs(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		try {
			userOrgsService.saveUserOrgs(vo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(value = "/changeUserOrgs.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean changeUserOrgs(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		try {
			userOrgsService.changeUserOrgs(vo);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<Map<String, Object>> getMenuTreeNode(List<DevDoorGroup> orgList,
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
			map.put("pid",  "-1");
			map.put("ChildNodes", new ArrayList());
			map.put("code", menu.getSn().toString());
			map.put("imgPath", path);
			map.put("showcheck", true);
			String checked = "0";
			for(UserOrgs userOrgs:userOrgsList){
				if (userOrgs.getOrgCode().equals(menu.getSn().toString())) {
					checked = "1";
					break;
				}
			}
			
			map.put("checkstate", checked);
			
			nodeList.add(map);
		}
		return nodeList;
	}
	
	/**
	 * 可多选组织机构
	 * @param orgList
	 * @param path
	 * @param org
	 * @return
	 */
	public List<Map<String, Object>> getOrgTreeNodeWithCheckBox(List<OrgInfo> orgList,
			String path, String org, List<UserOrgs> userOrgsList) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (OrgInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("showcheck", true);
			map.put("id", area.getOiCode());
			map.put("text", area.getOiName());
			map.put("value", area.getOiCode());
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("hasChildren", false);
			// map.put("pid", area.getOiCode());// 父节点，取前4位
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getOiCode());
			if("0000".equals(area.getOiCode())){
				map.put("imgPath", "../application/images/org/top.png");
			}else if("0".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/gs.png");
			}else if("1".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/ag.png");
			}else if("2".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/dis.png");
			}
			
			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,  area.getOiCode().length()-4));
			}
			
			map.put("text", area.getOiName());

			String checked = "0";
			for(UserOrgs userOrgs:userOrgsList){
				if (userOrgs.getOrgCode().equals(area.getOiCode())) {
					checked = "1";
					break;
				}
			}
			
			map.put("checkstate", checked);
			nodeList.add(map);
		}
		return nodeList;
	}
	
	
	public List<Map<String, Object>> getOrgTreeNodeWithRadio(List<OrgInfo> orgList,
			String path, String org, List<UserOrgs> userOrgsList) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (OrgInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put("showcheck", true);
			map.put("id", area.getOiCode());
			map.put("text", area.getOiName());
			map.put("value", area.getOiCode());
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("hasChildren", false);
			// map.put("pid", area.getOiCode());// 父节点，取前4位
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getOiCode());
			if("0000".equals(area.getOiCode())){
				map.put("imgPath", "../application/images/org/top.png");
			}else if("0".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/gs.png");
			}else if("1".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/ag.png");
			}else if("2".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/dis.png");
			}
			
			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,  area.getOiCode().length()-4));
			}
			
			if(area.getOiType()!=null){
				map.put("text", area.getOiName()+"("+OrgTypeEnum.valueForState(Long.parseLong(area.getOiType())).value()+")");
			}

			String checked = "0";
			for(UserOrgs userOrgs:userOrgsList){
				if (userOrgs.getOrgCode().equals(area.getOiCode())) {
					checked = "1";
					break;
				}
			}
			
			//map.put("checkstate", checked);
			nodeList.add(map);
		}
		return nodeList;
	}
	
}
