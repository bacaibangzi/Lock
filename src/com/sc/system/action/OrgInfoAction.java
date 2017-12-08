package com.sc.system.action;

import java.io.InputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.dbutil.DBConn;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.SystemAreaService;

/**
 * 
 * 组织机构action
 * 
 */
@Controller
@RequestMapping("/org")
public class OrgInfoAction extends BaseAction {
	@Autowired
	OrgInfoService orgInfoService;
	@Autowired
	SystemAreaService systemAreaService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	
	/**
	 * 组织机构主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/orgFrame";
	}

	/**
	 * 组织机构树状Tree结构
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		request.setAttribute("vo", vo);
 
		try {
			// 加载组织机构tree 图片路径
			String path = "../application/images/icon/org_start.png";
			List<OrgInfo> list = orgInfoService.queryOrgInfosByCondition(vo);
			List<Map<String, Object>> nodeList = getOrgTreeNode(list, path, vo
					.getOrgCode());
			
			request.setAttribute("nodeList", new Gson().toJson(nodeList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "system/orgLeftTree";
	}

	/**
	 * 组织结构列表界面
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "system/orgCenter";
	}

	/**
	 * 组织结构列表加载
	 * 
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<OrgInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<OrgInfo> list = orgInfoService.queryOrgInfosForPage(vo, page);
		
		for(OrgInfo org : list.getResult()){
			if(org.getAreaCode()!=null&&!"".equals(org.getAreaCode())){
				OrgInfo org1 = orgInfoService.findMengdByOrgCode(org.getAreaCode());
				if(org1!=null){
					org.setAreaName(org1.getOiName());
				}
			}
		}
		
		super.readerPage2Json(list, response);

	}

	/**
	 * 组织机构编辑页面
	 * 
	 * @param vo
	 * @param OrgInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") OrgInfo orgInfo, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		
		if (vo.getEntityId() != null) {
			
			OrgInfo of = orgInfoService.getOrgInfoById(vo);
			System.out.println(" *****************>>"+of.getAreaCode());
			//OrgInfo orgInfo1 = orgInfoService.findMengdByOrgCode(of.getAreaCode());
			//vo.setCode2(orgInfo1.getOiName());
			 
			BeanUtils
					.copyProperties(of, orgInfo);
		}else{
			vo.setOrgCode(vo.getCode());
			System.out.println(" -------------->>"+vo.getCode());
			OrgInfo orgInfo1 = orgInfoService.findMengdByOrgCode(vo.getCode());
			System.out.println(" orgInfo1 :"+orgInfo1);
			vo.setCode2(orgInfo1.getOiName());
		}
		
		return "system/orgEidt";
	}

	/**
	 * 组织机构查看界面
	 * 
	 * @param vo
	 * @param OrgInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") OrgInfo OrgInfo, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(orgInfoService.getOrgInfoById(vo), OrgInfo);
		return "system/orgDetail";
	}

	/**
	 * 组织机构保存
	 * 
	 * @param vo
	 * @param OrgInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,
			@ModelAttribute OrgInfo orgInfo, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		// 新增情况下设置上一级的组织编码
		
		orgInfoService.saveOrUpdateOrgInfoInfo(orgInfo,((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString(),vo.getCode());
		vo.setErrMsg("true");
		return "system/orgCenter";
	}

	/**
	 * 组织机构删除
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		orgInfoService.deleteOrgInfoById(vo);
		vo.setErrMsg("true");
		return "system/orgCenter";
	}
	
	/**
	 * 验证节点结构下是否已经存在子机构和用户
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/checkIfCanbeDeleted.htm", method = RequestMethod.POST)
	@ResponseBody
	public String checkIfCanbeDeleted(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		String message = null;
		try {
			message = orgInfoService.checkIfCanbeDeleted(vo);
			message = URLEncoder.encode(message, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 验证总店数量
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/checkOiType.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkOiType(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		List<OrgInfo> orgInfoList = orgInfoService.queryOrgInfosByOrgCodeAndOrgType(vo);
		if(orgInfoList.size()>0){
			return false;
		}else{
			return true;
		}
	}

	public List<Map<String, Object>> getOrgTreeNode(List<OrgInfo> orgList,
			String path, String org) {
		List<OrgInfo> list = orgList;
		List<Map<String, Object>> nodeList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (OrgInfo area : list) {
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
	 * 获取机构名称
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/getOrgName.htm", method = RequestMethod.POST)
	@ResponseBody
	public String getOrgName(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		String orgName = "";
		List<OrgInfo> orgInfoList = orgInfoService.queryOrgInfosByCondition(vo);
		if(orgInfoList!=null&&orgInfoList.size()>0){
			orgName = URLEncoder.encode(orgInfoList.get(0).getOiName(), "utf-8");
		}else{
			return "false";
		}
		return orgName;
	}
	
	/**
	 * 获取总店信息
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/getZongdian.htm", method = RequestMethod.POST)
	@ResponseBody
	public OrgInfo getZongdian(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		String orgCode = vo.getOrgCode().substring(0, vo.getOrgCode().length()-4);
		OrgInfo orgInfo = orgInfoService.findZongdByOrgCode(orgCode);
		return orgInfo;
	}
	
	/**
	 * 获取上级组织机构类型
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/getSuperiorType.htm", method = RequestMethod.POST)
	@ResponseBody
	public OrgInfo getSuperiorType(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		vo.setOrgCode(vo.getOrgCode().substring(0, vo.getOrgCode().length()-4));
		List<OrgInfo> orgInfos = orgInfoService.queryOrgInfosByCondition(vo);
		if(orgInfos.size()>0){
			return orgInfos.get(0);
		}else{
			return null;
		}
	}
	
	

	int syn = 1;
	// 同步数据
	@RequestMapping(value = "/syn.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean syn(@ModelAttribute ConditionVO vo,
			HttpServletRequest request){
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Map<String,Object>> list = null;
		String sql = "";
		try {
			
			Properties properties = new Properties();  
			InputStream inStream = DBConn.class.getClassLoader()  
			        .getResourceAsStream("jdbc.properties");  
			properties.load(inStream);
			
			syn = Integer.parseInt(properties.getProperty("syn"));  
			
			DBConn mDBConn = new DBConn();
			conn = mDBConn.getConntion();
			statement = conn.createStatement();
			
		//	sql = " select  ID, DEPTNAME,PARENTID, DEPTCODE, PLEVEL, STATUS,INPUTUSERID,INPUTDATE,DEPTSTR  from  SYS_DEPARTMENT where PARENTID = -1 ";
			if(syn==1){
				sql = " select ID as deptcode,deptname,parentid,PLEVEL from SYS_DEPARTMENT where parentid = '-1' ";
			}else{
				sql = " select deptcode,deptname,parentid,level from v_sys_department where parentid = '-1' ";
			}
			resultSet = statement.executeQuery(sql);
			list = mDBConn.getResultList(resultSet);
			System.out.println( "====================> 1.list.size :"+ list.size());
			// 把同步过来的数据syn标志位的先删除
			orgInfoService.deleteSyn();
			
			if(list!=null&&list.size()>0){
				synBum(statement,resultSet,list,"0000",mDBConn,"");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			list = null;
			sql = null;
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
				if(statement!=null) {
					statement.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return true;
	}
	
	
	// 部门
	public void synBum(Statement statement,ResultSet resultSet,List<Map<String,Object>> list,String code,DBConn mDBConn,String pName) throws Exception{
			try {
				for(Map<String,Object> map : list){
					String id  =  map.get("deptcode").toString();
					String dEPTNAME =  map.get("deptname").toString();
					String orgCode = "";
					
					System.out.println("id:"+id +", dEPTNAME:"+dEPTNAME +", code:"+code);
					

					// 根据名称查找是否存在
					OrgInfo orgInfo = orgInfoService.getByName(id);
					if(orgInfo==null){
						
						OrgInfo mOrgInfo = new OrgInfo();
						mOrgInfo.setOiCode(orgCode);
						mOrgInfo.setOiName(dEPTNAME);
						mOrgInfo.setOiType(id);
						mOrgInfo.setAreaName(pName);
						mOrgInfo.setPrintContext("syn");
						
						orgCode = orgInfoService.saveOrUpdateOrgInfoInfo(mOrgInfo,"",code);
						
					}else{
						orgCode = orgInfo.getOiCode();
						orgInfo.setOiName(dEPTNAME);
						orgInfo.setOiType(id);
						orgInfoService.update(orgInfo);
					}
					
					// 判断子查询
					//String sql = " select  ID, DEPTNAME,PARENTID, DEPTCODE, PLEVEL, STATUS,INPUTUSERID,INPUTDATE,DEPTSTR  from  SYS_DEPARTMENT where PARENTID ="+id;
					String sql = "";
					if(syn==1){
						sql = " select ID as deptcode,deptname,parentid,PLEVEL from SYS_DEPARTMENT where parentid ='"+id+"' ";
					}else {

						sql = " select deptcode,deptname,parentid,level from v_sys_department where parentid ='"+id+"' ";
					}
					resultSet = statement.executeQuery(sql);
					list = mDBConn.getResultList(resultSet);
					System.out.println( "====================> 2.list.size :"+ list.size());
					if(list!=null&&list.size()>0){
						synBum(statement,resultSet,list,orgCode,mDBConn,dEPTNAME);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	
}
