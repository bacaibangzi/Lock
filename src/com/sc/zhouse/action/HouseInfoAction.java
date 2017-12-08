package com.sc.zhouse.action;

import java.util.ArrayList;
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
import com.sc.system.pojo.AreaInfo;
import com.sc.system.service.SystemAreaService;
import com.sc.zhouse.pojo.HouseInfo;
import com.sc.zhouse.service.HouseInfoService;

@Controller
@RequestMapping("/houseInfo")
public class HouseInfoAction extends BaseAction{

	@Autowired
	HouseInfoService houseInfoService;
	@Autowired
	SystemAreaService systemAreaService;

	/**
	 * 产品服务页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(HttpServletRequest request) {
		LinkedHashMap<String,String> user_sh = new LinkedHashMap<String,String>();
		user_sh.put("", "全部");
		user_sh.put("0", "未审核");
		user_sh.put("1", "通过");
		request.setAttribute("shMap", user_sh);
		
		LinkedHashMap<String,String> fangShiMap = new LinkedHashMap<String,String>();
		fangShiMap.put("", "全部");
		fangShiMap.put("酒店", "酒店");
		fangShiMap.put("酒店公寓", "酒店公寓");
		fangShiMap.put("短期租房", "短期租房");
		fangShiMap.put("长期租房", "长期租房");
		request.setAttribute("fangShiMap", fangShiMap);
		
		return "zhouse/houseInfoMain";
	}

	/**
	 * 加载产品服务信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<HouseInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<HouseInfo> list = houseInfoService.queryHouseInfosForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * HouseInfo编辑页面queryHouseInfosPublishForPage
	 * @param vo
	 * @param HouseInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") HouseInfo HouseInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(houseInfoService.getHouseInfoById(vo),HouseInfo);
		}else{ 
			// 
			HouseInfo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().intValue());
		}
		// 
		Map<String,String> fangShiMap = new HashMap<String,String>();
		fangShiMap.put("酒店", "酒店");
		fangShiMap.put("酒店公寓", "酒店公寓");
		fangShiMap.put("短期租房", "短期租房");
		fangShiMap.put("长期租房", "长期租房");
		request.setAttribute("fangShiMap", fangShiMap);
		// 
		Map<String,String> chaoXiangMap = new HashMap<String,String>();
		chaoXiangMap.put("南北", "南北");
		request.setAttribute("chaoXiangMap", chaoXiangMap);
		// 
		Map<String,String> huXingMap = new HashMap<String,String>();
		huXingMap.put("南北", "南北");
		request.setAttribute("huXingMap", huXingMap);
		
		
		return "zhouse/houseInfoEidt";
	}
	
	/**
	 * HouseInfo详细信息页面
	 * @param vo
	 * @param HouseInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") HouseInfo HouseInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(houseInfoService.getHouseInfoById(vo),HouseInfo);
		return "developer/houseInfoDetail";
	}
	
	/**
	 * 保存HouseInfo信息
	 * @param vo
	 * @param HouseInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute HouseInfo houseInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		// 获取用户信息
		//houseInfo.setUserId(((AccountInfo) request.getSession().getAttribute("accountInfo")).getUserId().intValue());
		//houseInfo.setUserName(((AccountInfo) request.getSession().getAttribute("accountInfo")).getUserName());
		houseInfoService.saveOrUpdateHouseInfoInfo(houseInfo);
		return "zhouse/houseInfoMain";
	}
	
	/**
	 * 删除HouseInfo信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		houseInfoService.deleteHouseInfoById(vo);
		return "zhouse/houseInfoMain";
	}
	
	/**
	 * 申请
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		houseInfoService.shById(vo);
		return true;
	}
	
	
	@RequestMapping(value = "/check.htm", method = RequestMethod.POST)
	@ResponseBody
	public HouseInfo check(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		HouseInfo HouseInfo = houseInfoService.getHouseInfoById(vo);
		return HouseInfo;
	}
	
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
		List<AreaInfo> list = systemAreaService.queryAreaInfosByCondition(vo);
		List<Map<String, Object>> nodeList = getAreaTreeNode(list, path);
		request.setAttribute("nodeList", new Gson().toJson(nodeList));

		return "zhouse/selectOrgTree";
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
	
}
