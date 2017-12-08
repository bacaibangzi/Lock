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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.AreaInfo;
import com.sc.system.service.SystemAreaService;

/**
 * 
 * 系统区域action
 * 
 */
@Controller
@RequestMapping("/area")
public class SystemAreaAction extends BaseAction {
	@Autowired
	SystemAreaService systemAreaService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/areaFrame";
	}
	
	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		// 加载区域tree
		// 图片路径
		/*String path = "../application/images/icon/org_start.png";
		List<AreaInfo> list = systemAreaService.queryAreaInfosByCondition(vo);
		List<Map<String, Object>> nodeList = getAreaTreeNode(list, path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));*/

		return "system/areaLeftTree";
	}
	

	@RequestMapping(value = "/treeByCode.htm", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String leftTreeByCode(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		List<AreaInfo> list = null;
		List<Map<String, Object>> nodeList = null;
		// 加载区域tree
		// 图片路径
		String path = "../application/images/icon/org_start.png";
		String code = request.getParameter("id");
		if (code != null) {
			list = systemAreaService.queryAreaInfoByCode(code);
			nodeList = getAreaTree(list, path);
			String tree = new Gson().toJson(nodeList).toString();
			return tree;
		} else {
			list = systemAreaService.queryAreaInfosByConditionValue("0");
			List<AreaInfo> listByCode = systemAreaService.queryAreaInfoByCode("0");
			for (AreaInfo areaInfo : listByCode) {
				list.add(areaInfo);
			}
			nodeList = getAreaTree(list, path);
			String tree = new Gson().toJson(nodeList).toString();
			return tree;
		}

	}

	@RequestMapping(value = "/selectAreaTree.htm", method = RequestMethod.GET)
	public String selectAreaTree(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		// 加载区域tree
		// 图片路径
		String path = "../application/images/icon/org_start.png";
		List<AreaInfo> list = systemAreaService.queryAreaInfosByCondition(vo);
		// List<Map<String, Object>> nodeList = getAreaTreeNode(list, path);
		List<Map<String, Object>> nodeList = getAreaTreeNode(list, path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "system/selectAreaTree";
	}

	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo, HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "system/areaCenter";
	}

	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo, @ModelAttribute Page<AreaInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<AreaInfo> list = systemAreaService.queryAreaInfosForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo, @ModelAttribute("form") AreaInfo areaInfo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		if (vo.getEntityId() != null) {
			BeanUtils.copyProperties(systemAreaService.getAreaInfoById(vo), areaInfo);
		}
		return "system/areaEidt";
	}

	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo, @ModelAttribute("form") AreaInfo areaInfo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(systemAreaService.getAreaInfoById(vo), areaInfo);
		return "system/areaDetail";
	}

	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo, @ModelAttribute AreaInfo areaInfo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		systemAreaService.saveOrUpdateAreaInfoInfo(areaInfo);
		return "system/areaCenter";
	}

	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo, HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		systemAreaService.deleteAreaInfoById(vo);
		return "system/areaCenter";
	}

	
	public List<Map<String, Object>> getAreaTreeNode(List<AreaInfo> orgList,
			String path) {
		List<AreaInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (AreaInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", area.getAreaCode());
			map.put("checkAble", "false");
			map.put("text", area.getAreaName());
			map.put("value", area.getAreaCode());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			map.put("pid", area.getAreaParentCode());
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getAreaCode());
			map.put("imgPath", path);
			nodeList.add(map);
		}
		return nodeList;

	}
	
	public List<Map<String, Object>> getAreaTree(List<AreaInfo> orgList, String path) {
		List<AreaInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (AreaInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", area.getAreaCode());
			map.put("name", area.getAreaName());
			map.put("pid", area.getAreaParentCode());
			map.put("icon", path);
			map.put("isParent", true);	//使节点都为父节点
			if (area.getAreaCode().equals("0")) {
				map.put("open", true);
			} //必要条件,打开根节点显示下面的省份
			nodeList.add(map);
		}
		return nodeList;

	}

}
