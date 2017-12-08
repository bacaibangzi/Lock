package com.sc.framework.base.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.sc.framework.enums.OrgTypeEnum;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.AreaInfo;
import com.sc.system.pojo.OrgInfo;

public class BaseAction {

	private static final long serialVersionUID = -1842481341387442890L;
	private static final Logger log = LoggerFactory.getLogger(BaseAction.class);

	protected String readerPage2Json(Page page, HttpServletResponse response) {
		// 将要转换的对象
		Map<String, Object> pageToJson = new HashMap<String, Object>();
		// 总记录条数
		if (page.getTotalCount() == -1) {
			pageToJson.put("iTotalRecords", 0);
			pageToJson.put("iTotalDisplayRecords", 0);
		} else {
			pageToJson.put("iTotalRecords", page.getTotalCount());
			pageToJson.put("iTotalDisplayRecords", page.getTotalCount());
		}

		// 数据行
		pageToJson.put("aaData", page.getResult());

		// 调用通用转JSON方法
		renderJson(pageToJson, response);
		// Gson gson = this.createGson();
		// return gson.toJson(pageToJson);
		return null;
	}

	protected String renderJson(Object obj, HttpServletResponse response) {
		response.setContentType("application/json;charset=UTF-8");
		Gson gson = this.createGson();
		if (obj != null) {
			try {
				String jsonStr = gson.toJson(obj);
				response.getWriter().write(jsonStr);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 子类可以覆盖这个函数以配置GSON的选项，比如修改摸个内联对象的格式化策略
	 * 
	 * @return
	 */
	protected Gson createGson() {
		return new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss")
				.setLongSerializationPolicy(LongSerializationPolicy.STRING)
				.create();
	}

	protected void setPageInfo(Page page) {
		// 页码(根据传入的参数计算页数)
		page.setPageNo((Integer.parseInt(page.getIDisplayStart())
				/ Integer.parseInt(page.getIDisplayLength()) + 1));
		// 每页显示条数
		page.setPageSize(Integer.parseInt(page.getIDisplayLength()));
		// page.setOrderBy(getRequest().getParameter("sSortDir_0"));
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
			map.put("type", area.getOiType());
			//map.put("imgPath", path);
			if("0000".equals(area.getOiCode())){
				map.put("imgPath", "../application/images/org/top.png");
			}else if("0".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/gs.png");
			}else if("1".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/ag.png");
			}else if("2".equals(area.getOiType())){
				map.put("imgPath", "../application/images/org/dis.png");
			}
			if(area.getOiType()!=null){
				map.put("text", area.getOiName());
			}
			
			if (org.equals(area.getOiCode())) {
				map.put("pid", "-1");
			} else {
				map.put("pid", area.getOiCode().substring(0,  area.getOiCode().length()-4));
			}

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
			String path, String org, String selectedOrgCode) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		for (OrgInfo area : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			if(selectedOrgCode.equals(area.getOiCode()) || Integer.parseInt(area.getOiType())<=3){
				map.put("checkAble", "false");
				map.put("showcheck", false);
			}else{
				map.put("showcheck", true);
			}
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
			String checked = "1";
			for (OrgInfo orgInfo : orgList) {
				if (orgInfo.getOiId().longValue() == orgInfo.getOiId().longValue()) {
					checked = "0";
					break;
				}
			}
			if(area.getOiType()!=null){
				map.put("text", area.getOiName()+"<font color=green> ("+OrgTypeEnum.valueForState(Long.parseLong(area.getOiType())).value()+")</font>");
			}
			map.put("checkstate", checked);
			nodeList.add(map);
		}
		return nodeList;
	}
	
	/**
	 * 获取门店结构
	 * 
	 * @param orgList
	 * @param path
	 * @param org
	 * @return
	 */
	public List<Map<String, Object>> getMdTreeNode(List<OrgInfo> orgList,
			String path, String org) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (OrgInfo area : list) {
			int type = Integer.parseInt(area.getOiType());
			if(type==2 || type ==3){
				map = new HashMap<String, Object>();
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
	            map.put("pid", "-1");
				map.put("ChildNodes", new ArrayList());
				map.put("code", area.getOiCode());
				map.put("type", area.getOiType());
				//map.put("imgPath", path);
				if("0000".equals(area.getOiCode())){
					map.put("imgPath", "../application/images/org/top.png");
				}else if("0".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/gs.png");
				}else if("1".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/ag.png");
				}else if("2".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/dis.png");
				}
				if(area.getOiType()!=null){
					map.put("text", area.getOiName()+"<font color=green> ("+OrgTypeEnum.valueForState(Long.parseLong(area.getOiType())).value()+")</font>");
				}

				nodeList.add(map);
			}
			else if(type>=4){
				map = new HashMap<String, Object>();
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
				map.put("pid", area.getOiCode().substring(0,  area.getOiCode().length()-4));
				map.put("ChildNodes", new ArrayList());
				map.put("code", area.getOiCode());
				map.put("type", area.getOiType());
				//map.put("imgPath", path);
				if("0000".equals(area.getOiCode())){
					map.put("imgPath", "../application/images/org/top.png");
				}else if("0".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/gs.png");
				}else if("1".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/ag.png");
				}else if("2".equals(area.getOiType())){
					map.put("imgPath", "../application/images/org/dis.png");
				}
				if(area.getOiType()!=null){
					map.put("text", area.getOiName()+"<font color=green> ("+OrgTypeEnum.valueForState(Long.parseLong(area.getOiType())).value()+")</font>");
				}
				nodeList.add(map);
			}
		}
		
		return nodeList;
	}
	
	
	/**
	 * 获取区域下门店
	 * 
	 * @param orgList
	 * @param path
	 * @param org
	 * @return
	 */
	public List<Map<String, Object>> getAreaOrgTreeNode(List<AreaInfo> areaList,
			String path, List<OrgInfo> orgList) {
		List<AreaInfo> list = areaList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,String> am = new HashMap<String,String>();
		
		for (AreaInfo area : list) {
			
			for(OrgInfo org : orgList){
			
				//System.out.println("area:"+org.getAreaCode()+", org:"+area.getAreaCode());
				if(area.getAreaCode()!=null&&org.getAreaCode()!=null&&org.getAreaCode().indexOf(area.getAreaCode())==0){
				
					if(!am.containsKey(area.getAreaCode())){
						map = new HashMap<String, Object>();
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
						map.put("sid", org.getOiId());
						map.put("imgPath", path);
						map.put("sid", "-1");
						map.put("type","-1");
						nodeList.add(map);
						am.put(area.getAreaCode(), area.getAreaCode());
					}
				}
			}
		}
		
		/*
		map = new HashMap<String, Object>();
		map.put("id", "0");
		map.put("checkAble", "false");
		map.put("text", "全国");
		map.put("value", "0");
		map.put("showcheck", "");
		map.put("complete", true);
		map.put("isexpand", false);
		map.put("checkstate", "0");
		map.put("hasChildren", false);
		map.put("pid", "-1");
		map.put("ChildNodes", new ArrayList());
		map.put("code", "0");
		map.put("imgPath", path);
		map.put("sid", "-1");
		nodeList.add(map);		
		*/
		
		
		for(OrgInfo org : orgList){
			map = new HashMap<String, Object>();
			map.put("id", "o"+org.getOiId());
			map.put("checkAble", "false");
			map.put("text", org.getOiName());
			map.put("value", org.getOiCode());
			map.put("showcheck", "");
			map.put("complete", true);
			map.put("isexpand", false);
			map.put("checkstate", "0");
			map.put("hasChildren", false);
			map.put("pid", org.getAreaCode());
			map.put("ChildNodes", new ArrayList());
			map.put("code", org.getOiCode());
			map.put("type", org.getOiType());
			map.put("sid", org.getOiId());
			
			if("0000".equals(org.getOiCode())){
				map.put("imgPath", "../application/images/org/top.png");
			}else if("0".equals(org.getOiType())){
				map.put("imgPath", "../application/images/org/gs.png");
			}else if("1".equals(org.getOiType())){
				map.put("imgPath", "../application/images/org/ag.png");
			}else if("2".equals(org.getOiType())){
				map.put("imgPath", "../application/images/org/dis.png");
			}
			nodeList.add(map);
		}
		
		return nodeList;
	}
	
	
	
	
	
	
	
	
	
	
}
