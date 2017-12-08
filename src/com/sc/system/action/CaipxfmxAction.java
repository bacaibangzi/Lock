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
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page; 
import com.sc.system.pojo.OrgInfo;
import com.sc.system.service.OrgInfoService;

/**
 * 菜品明细报表
 * 
 * @author cuibin
 * 
 */

@Controller
@RequestMapping("/caipxfmx")
public class CaipxfmxAction extends BaseAction {
	@Autowired
	OrgInfoService orgInfoService;
	 
	
	/**
	 * 组织机构树状Tree结构
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/orgTree.htm", method = RequestMethod.GET)
	public String orgTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		// 加载组织机构tree 图片路径
		String path = "../application/images/icon/org_start.png";
		List<OrgInfo> list = orgInfoService.queryOrgInfosByCondition(vo);
		List<Map<String, Object>> nodeList = getOrgTreeNode(list, path, vo
				.getOrgCode());
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "report/selectOrgTree";
	}

	public List<Map<String, Object>> getOrgTreeNode(List<OrgInfo> orgList,
			String path, String org) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (OrgInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", area.getOiCode());
			map.put("checkAble", "false");
			map.put("text", area.getOiName());
			map.put("value", area.getOiCode());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			// map.put("pid", area.getOiCode());// 父节点，取前4位
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getOiCode());
			map.put("imgPath", path);

			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,
						area.getOiCode().length() - 4));
			}

			nodeList.add(map);
		}
		return nodeList;
	}
	
	
	@RequestMapping(value = "/orgTree1.htm", method = RequestMethod.GET)
	public String orgTree1(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		// 加载组织机构tree 图片路径
		String path = "../application/images/icon/org_start.png";
		List<OrgInfo> list = orgInfoService.queryOrgInfosByCondition(vo);
		List<Map<String, Object>> nodeList = getOrgTreeNode1(list, path, vo
				.getOrgCode());
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "report/selectOrgTree1";
	}
	
	public List<Map<String, Object>> getOrgTreeNode1(List<OrgInfo> orgList,
			String path, String org) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (OrgInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", area.getOiCode());
			map.put("checkAble", "false");
			map.put("text", area.getOiName());
			map.put("value", area.getOiCode());
			map.put("showcheck", true);
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			// map.put("pid", area.getOiCode());// 父节点，取前4位
			map.put("ChildNodes", new ArrayList());
			map.put("code", area.getOiCode());
			map.put("imgPath", path);

			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,
						area.getOiCode().length() - 4));
			}

			nodeList.add(map);
		}
		return nodeList;
	}
	
}
