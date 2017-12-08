package com.sc.zhouse.rest;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.utils.StringUtil;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.UserInfoService;
import com.sc.zhouse.dao.HouseTypeMapper;
import com.sc.zhouse.dao.UserHouseMapper;
import com.sc.zhouse.pojo.HouseInfo;
import com.sc.zhouse.pojo.HouseType;
import com.sc.zhouse.pojo.NewVersionResp;
import com.sc.zhouse.pojo.News;
import com.sc.zhouse.pojo.UserHouse;
import com.sc.zhouse.pojo.VhuserHouse;
import com.sc.zhouse.service.HouseInfoService;
import com.sc.zhouse.service.NewsService;
import com.sc.zhouse.service.UserHouseService;
import com.sc.zhouse.service.VhuserHouseService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/zHouseRest")
public class ZHouseRest extends BaseAction{
	
	@Autowired
	UserInfoService userInfoService;
	@Autowired
	HouseInfoService houseInfoService;
	@Autowired
	UserHouseService userHouseService;
	@Autowired
	NewsService newsService;
	@Autowired
	VhuserHouseService vhuserHouseService;
	@Autowired
	UserHouseMapper userHouseMapper;
	@Autowired
	HouseTypeMapper houseTypeMapper;
	
	

	@RequestMapping(value="/regist-mobile", method = RequestMethod.POST) 
	public void regist(@RequestBody String content,HttpServletResponse response){
		
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		
		Exception e = null;
		//if(map.get(uiMobile)!=null&&map.get(uiMobile).equals(code)){
		try {
			jsonObject = JSONObject.fromObject(content);
			UserInfo userInfo = new UserInfo();
			userInfo.setUiLoginName("宝宝"+String.valueOf(((int)((Math.random()*9+1)*100000))));
			userInfo.setUiMobile(jsonObject.getString("uiMobile"));
			userInfo.setUiPassword(jsonObject.getString("uiPassword"));
			
			// 判断是否已经登记该电话号码
			conditionMap.put("uiMobile", userInfo.getUiMobile());
			List<UserInfo> userInfoList = userInfoService.queryUserInfosByCondition(conditionMap);
			if(userInfoList!=null&&userInfoList.size()>0){
				map.put("success", false);
			}else{
				userInfoService.saveOrUpdateUserInfoInfo(userInfo);	
				conditionMap.put("uiMobile", userInfo.getUiMobile());
				userInfoList = userInfoService.queryUserInfosByCondition(conditionMap);
				map.put("success", true);
				map.put("userId", String.valueOf(userInfoList.get(0).getUiId()));
				map.put("userName", userInfoList.get(0).getUiLoginName());
				map.put("userPhone", userInfoList.get(0).getUiMobile());
			}
			//return "success";
		} catch (Exception exception) {
			e=exception; 
			e.printStackTrace();
		}

		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	@RequestMapping(value="/login-mobile", method = RequestMethod.POST) 
	public void login(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			conditionMap.put("uiMobile", jsonObject.getString("uiMobile"));
			conditionMap.put("uiPassword", StringUtil.encodeStr(jsonObject.getString("uiPassword")));
			List<UserInfo> userInfoList = userInfoService.queryUserInfosByCondition(conditionMap);
			if(userInfoList==null||userInfoList.size()==0){
				map.put("success", false);
				map.put("message", "用户或密码错误!");
			}else{
				map.put("success", true);
				map.put("userId", String.valueOf(userInfoList.get(0).getUiId()));
				map.put("userName", userInfoList.get(0).getUiLoginName());
				map.put("userPhone", userInfoList.get(0).getUiMobile());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	@RequestMapping(value="/changePassword-mobile", method = RequestMethod.POST) 
	public void changePassword(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			//conditionMap.put("userId", jsonObject.getString("userId"));
			//conditionMap.put("uiPassword", StringUtil.encodeStr(jsonObject.getString("uiPassword")));
			vo.setEntityId(jsonObject.getString("userId"));
			String p1 = jsonObject.getString("uiPassword");
			String p2 = jsonObject.getString("uiPassword1");
			
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			
			if(p1.equals(userInfo.getUiPassword())){

				userInfo.setUiPassword(StringUtil.encodeStr(p2));
				userInfoService.updateUserInfo(userInfo);
				map.put("success", true);
			}else{
				map.put("success", false);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	@RequestMapping(value="/getUserInfo-mobile", method = RequestMethod.POST) 
	public void getUserInfo(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			map.put("userName", userInfo.getUiName()==null?"":userInfo.getUiName());
			map.put("userSign", userInfo.getUiAddress()==null?"":userInfo.getUiAddress());
			map.put("userNickName", userInfo.getUiNickName()==null?"":userInfo.getUiNickName());
			map.put("userPhone", userInfo.getUiMobile()==null?"":userInfo.getUiMobile());
			map.put("userMail", userInfo.getUiEmail()==null?"":userInfo.getUiEmail());
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 修改名称
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/updateName-mobile", method = RequestMethod.POST) 
	public void updateName(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiName(jsonObject.getString("userName"));
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
			map.put("success", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}

	
	/**
	 * 修改昵称
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/updateNickName-mobile", method = RequestMethod.POST) 
	public void updateNickName(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiNickName(jsonObject.getString("userNickName"));
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 修改签名
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/updateSign-mobile", method = RequestMethod.POST) 
	public void updateSign(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiAddress(jsonObject.getString("userSign"));
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 修改联系方式
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/updatePhone-mobile", method = RequestMethod.POST) 
	public void updatePhone(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiMobile(jsonObject.getString("userPhone"));
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 修改邮箱
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/updateMail-mobile", method = RequestMethod.POST) 
	public void updateMail(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			vo.setEntityId(jsonObject.getString("userId"));
			UserInfo userInfo = userInfoService.getUserInfoById(vo);
			userInfo.setUiEmail(jsonObject.getString("userMail"));
			userInfoService.saveOrUpdateUserInfoInfo(userInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	/**
	 * 发布新信息
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/publishHouseInfo-mobile", method = RequestMethod.POST) 
	public void publishHouseInfo(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		System.out.println(content);
		try {
			jsonObject = JSONObject.fromObject(content);
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setFangShi(jsonObject.getString("fang_shi"));
			houseInfo.setJianZhuMianJi(jsonObject.getString("jian_zhu_mian_ji"));
			houseInfo.setHuXing1(jsonObject.getString("hu_xing1"));
			houseInfo.setHuXing2(jsonObject.getString("hu_xing2"));
			houseInfo.setHuXing3(jsonObject.getString("hu_xing3"));
			houseInfo.setPtChuang(jsonObject.getString("pt_chuang"));
			houseInfo.setPtKuangDai(jsonObject.getString("pt_kuang_dai"));
			houseInfo.setPtDianShi(jsonObject.getString("pt_dian_shi"));
			houseInfo.setPtXiYiJi(jsonObject.getString("pt_xi_yi_ji"));
			houseInfo.setPtNuanQi(jsonObject.getString("pt_nuan_q"));
			houseInfo.setPtKongTiao(jsonObject.getString("pt_kong_tiao"));
			houseInfo.setPtBinXiang(jsonObject.getString("pt_bin_xiang"));
			houseInfo.setPtReShuiQi(jsonObject.getString("pt_re_shui_qi"));
			houseInfo.setXiaoQuMiaoShu(jsonObject.getString("xiao_qu_miao_shu"));
			houseInfo.setFangWuMiaoShu(jsonObject.getString("fang_wu_miao_shu"));
			houseInfo.setLianXiRen(jsonObject.getString("lian_xi_ren"));
			houseInfo.setLianXiDianHua(jsonObject.getString("lian_xi_dian_hua"));
			houseInfo.setZuJin(jsonObject.getString("zu_jin"));
			houseInfo.setUserId(jsonObject.getInt("userId"));
			houseInfo.setXiaoQuMingCheng(jsonObject.getString("xiao_qu_ming_cheng"));
			houseInfo.setImg1Path(jsonObject.getString("img1_path"));
			houseInfo.setImg2Path(jsonObject.getString("img2_path"));
			houseInfo.setImg3Path(jsonObject.getString("img3_path"));
			houseInfo.setImg4Path(jsonObject.getString("img4_path"));
			houseInfo.setImg5Path(jsonObject.getString("img5_path"));
			houseInfo.setImg6Path(jsonObject.getString("img6_path"));
			houseInfo.setImg7Path(jsonObject.getString("img7_path"));
			houseInfo.setImg8Path(jsonObject.getString("img8_path"));
			houseInfo.setImg9Path(jsonObject.getString("img9_path"));
			houseInfo.setImg10Path(jsonObject.getString("img10_path"));
			houseInfo.setBiaoTi(jsonObject.getString("biao_ti"));
			houseInfo.setZhuangXiu(jsonObject.getString("zhuang_xiu"));
			houseInfo.setChaoXiang(jsonObject.getString("xing_ji"));
			houseInfo.setLon(jsonObject.getDouble("lon"));
			houseInfo.setLat(jsonObject.getDouble("lat"));
			houseInfo.setDiZhi(jsonObject.getString("di_zhi"));
			
			houseInfoService.saveOrUpdateHouseInfoInfo(houseInfo);
			
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	/**
	 * 修改发布新信息
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/editHouseInfo-mobile", method = RequestMethod.POST) 
	public void editHouseInfo(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		System.out.println(content);
		try {
			jsonObject = JSONObject.fromObject(content);
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setFangShi(jsonObject.getString("fang_shi"));
			houseInfo.setJianZhuMianJi(jsonObject.getString("jian_zhu_mian_ji"));
			houseInfo.setHuXing1(jsonObject.getString("hu_xing1"));
			houseInfo.setHuXing2(jsonObject.getString("hu_xing2"));
			houseInfo.setHuXing3(jsonObject.getString("hu_xing3"));
			houseInfo.setPtChuang(jsonObject.getString("pt_chuang"));
			houseInfo.setPtKuangDai(jsonObject.getString("pt_kuang_dai"));
			houseInfo.setPtDianShi(jsonObject.getString("pt_dian_shi"));
			houseInfo.setPtXiYiJi(jsonObject.getString("pt_xi_yi_ji"));
			houseInfo.setPtNuanQi(jsonObject.getString("pt_nuan_q"));
			houseInfo.setPtKongTiao(jsonObject.getString("pt_kong_tiao"));
			houseInfo.setPtBinXiang(jsonObject.getString("pt_bin_xiang"));
			houseInfo.setPtReShuiQi(jsonObject.getString("pt_re_shui_qi"));
			houseInfo.setXiaoQuMiaoShu(jsonObject.getString("xiao_qu_miao_shu"));
			houseInfo.setFangWuMiaoShu(jsonObject.getString("fang_wu_miao_shu"));
			houseInfo.setLianXiRen(jsonObject.getString("lian_xi_ren"));
			houseInfo.setLianXiDianHua(jsonObject.getString("lian_xi_dian_hua"));
			houseInfo.setZuJin(jsonObject.getString("zu_jin"));
			houseInfo.setUserId(jsonObject.getInt("userId"));
			houseInfo.setXiaoQuMingCheng(jsonObject.getString("xiao_qu_ming_cheng"));
			houseInfo.setImg1Path(jsonObject.getString("img1_path"));
			houseInfo.setImg2Path(jsonObject.getString("img2_path"));
			houseInfo.setImg3Path(jsonObject.getString("img3_path"));
			houseInfo.setImg4Path(jsonObject.getString("img4_path"));
			houseInfo.setImg5Path(jsonObject.getString("img5_path"));
			houseInfo.setImg6Path(jsonObject.getString("img6_path"));
			houseInfo.setImg7Path(jsonObject.getString("img7_path"));
			houseInfo.setImg8Path(jsonObject.getString("img8_path"));
			houseInfo.setImg9Path(jsonObject.getString("img9_path"));
			houseInfo.setImg10Path(jsonObject.getString("img10_path"));
			houseInfo.setBiaoTi(jsonObject.getString("biao_ti"));
			houseInfo.setZhuangXiu(jsonObject.getString("zhuang_xiu"));
			houseInfo.setChaoXiang(jsonObject.getString("xing_ji"));
			houseInfo.setSn(jsonObject.getInt("sn"));
			houseInfo.setLon(jsonObject.getDouble("lon"));
			houseInfo.setLat(jsonObject.getDouble("lat"));
			houseInfo.setDiZhi(jsonObject.getString("di_zhi"));
			houseInfo.setShenHe(0);
			
			houseInfoService.saveOrUpdateHouseInfoInfo(houseInfo);
			
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}	
	
	
	// 删除发布信息
	@RequestMapping(value="/deleteHouseInfo-mobile", method = RequestMethod.POST) 
	public void deleteHouseInfo(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			houseInfoService.deleteHouseInfoById(sn);
			
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	/**
	 * 根据小区类型获取房屋列表
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getHouseInfoListByXiaoQuCode-mobile", method = RequestMethod.POST) 
	public void getHouseInfoListByXiaoQuCode(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<HouseInfo> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println(content);
			jsonObject = JSONObject.fromObject(content);
			String code = jsonObject.getString("code");
			String fangShi = jsonObject.getString("fangShi");
			vo.setCode(code);
			vo.setCode1(fangShi);
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			Page<HouseInfo> houseInfoList = houseInfoService.queryHouseInfosByHouseCodeForPage(vo,page);
			map.put("houseInfoList", houseInfoList.getResult());
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	
	/**
	 * 获取房屋列表
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getHouseInfoList-mobile", method = RequestMethod.POST) 
	public void getHouseInfoList(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<HouseInfo> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println(content);
			jsonObject = JSONObject.fromObject(content);
			String userId = jsonObject.getString("userId");
			// 防止未登录溢出
			if(userId==null){
				userId = "-1";
			}
			vo.setEntityId(userId);
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			Page<HouseInfo> houseInfoList = houseInfoService.queryHouseInfosForPage(vo,page);
			map.put("houseInfoList", houseInfoList.getResult());
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 获取新闻列表
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getNewsList-mobile", method = RequestMethod.POST) 
	public void getNewsList(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<News> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			
			Page<News> newsList = newsService.queryNewssForPage(vo, page);
			map.put("newsList", newsList.getResult());
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		} 
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 获取信息详细信息
	 * 
	 * @param vo
	 * @param News
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getNews-mobile", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") News News,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(newsService.getNewsById(vo),News);
		return "zhouse/newsDetail";
	}
	
	/**
	 * 获取房屋详细信息
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getHouseInfo-mobile", method = RequestMethod.POST) 
	public void getHouseInfo(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			vo.setEntityId(sn);
			HouseInfo houseInfo = houseInfoService.getHouseInfoById(vo);
			map.put("houseInfo", houseInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 预订
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/placeHouseInfo-mobile", method = RequestMethod.POST) 
	public void placeHouseInfo(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		ConditionVO vo = new ConditionVO();
		try {
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			String userId = jsonObject.getString("userId");
			vo.setEntityId(sn);
			HouseInfo houseInfo = houseInfoService.getHouseInfoById(vo);
			//
			UserHouse userHouse = new UserHouse();
			userHouse.setUserId(Integer.parseInt(userId));
			userHouse.setHouseId(Integer.parseInt(sn));
			userHouse.setType(2);
			userHouseService.saveOrUpdateUserHouseInfo(userHouse);
			userHouse.setType(3);
			userHouseService.saveOrUpdateUserHouseInfo(userHouse);
			
			map.put("houseInfo", houseInfo);
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	// 收藏
	@RequestMapping(value="/collectHouseInfo-mobile", method = RequestMethod.POST) 
	public void collectHouseInfo(@RequestBody String content,HttpServletResponse response){
		//userHouseService
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			String userId = jsonObject.getString("userId");
			
			UserHouse userHouse = new UserHouse();
			userHouse.setUserId(Integer.parseInt(userId));
			userHouse.setHouseId(Integer.parseInt(sn));
			userHouse.setType(1);
			userHouseService.saveOrUpdateUserHouseInfo(userHouse);
			
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 预约看房列表
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getAgreeMentHouseInfoList-mobile", method = RequestMethod.POST) 
	public void getAgreeMentHouseInfoList(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		//userHouseService
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try{
			jsonObject = JSONObject.fromObject(content);
			String userId = jsonObject.getString("userId");
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			
			//conditionMap.put("flag", userId);
			//conditionMap.put("type", 2);
			vo.setEntityId(userId);
			vo.setFlag("2");
			
			//Page<HouseInfo> houseList = houseInfoService.queryHouseInfosByUserCondition(conditionMap,page);
			Page<VhuserHouse> houseInfoList = vhuserHouseService.queryVhuserHousesForPage(vo, page);

			map.put("houseList", houseInfoList.getResult());
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	// 获取收藏的房屋
	@RequestMapping(value="/getCollectHouseInfoList-mobile", method = RequestMethod.POST) 
	public void getCollectHouseInfoList(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		//userHouseService
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try{
			jsonObject = JSONObject.fromObject(content);
			String userId = jsonObject.getString("userId");
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			
			/*
			conditionMap.put("flag", userId);
			conditionMap.put("type", 1);
			Page<HouseInfo> houseList = houseInfoService.queryHouseInfosByUserCondition(conditionMap,page);
			*/
			vo.setEntityId(userId);
			vo.setFlag("1");
			
			//Page<HouseInfo> houseList = houseInfoService.queryHouseInfosByUserCondition(conditionMap,page);
			Page<VhuserHouse> houseInfoList = vhuserHouseService.queryVhuserHousesForPage(vo, page);

			map.put("houseList", houseInfoList.getResult());
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 获取他人预约订单列表
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getOrderHouseInfoList-mobile", method = RequestMethod.POST) 
	public void getOrderHouseInfoList(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			page.setIDisplayStart(jsonObject.getString("iDisplayStart"));
			page.setIDisplayLength(jsonObject.getString("iDisplayLength"));
			super.setPageInfo(page);
			
			String userId = jsonObject.getString("userId");
			vo.setEntityId(userId);
			vo.setFlag("3");
			Page<VhuserHouse> houseInfoList = vhuserHouseService.queryVhuserHousesForPage1(vo, page);
			map.put("houseList", houseInfoList.getResult());
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	// 删除他人预约
	@RequestMapping(value="/deleteOrderHouse-mobile", method = RequestMethod.POST) 
	public void deleteOrderHouse(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			vhuserHouseService.deleteVhuserHousesById(sn);
			
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	// 删除自己预约
	@RequestMapping(value="/deleteAgreeMentHouseInfo-mobile", method = RequestMethod.POST) 
	public void deleteAgreeMentHouseInfo(@RequestBody String content,@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuserHouse> page, HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			vhuserHouseService.deleteVhuserHousesById(sn);
			
			map.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	//userHouseMapper
	@RequestMapping(value="/setOrderHouseFlag-mobile", method = RequestMethod.POST) 
	public void setOrderHouseFlag(@RequestBody String content,HttpServletResponse response){
		//userHouseService
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try{
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			
			conditionMap.put("sn", sn);
			conditionMap.put("param1", "1");
			userHouseMapper.updateParam(conditionMap);

			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	/**
	 * 根据地图经纬度，等级进行查询
	 */
	@RequestMapping(value="/searchHouseByMapStatus-mobile", method = RequestMethod.POST) 
	public void searchHouseByMapStatus(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		try{
			jsonObject = JSONObject.fromObject(content);
			//String code = jsonObject.getString("code");
			String fangShi = java.net.URLDecoder.decode(jsonObject.getString("fangShi"), "UTF-8");
			
			if("酒店式公寓".equals(fangShi)){
				fangShi = "酒店公寓";
			}
			
			String lon = jsonObject.getString("lon");
			String lat = jsonObject.getString("lat");
			int level = jsonObject.getInt("level");
			if(level==0){
				list = houseInfoService.queryHouseLevel2(lon, lat,fangShi);
			}else{
				list = houseInfoService.queryHouseLevel3(lon, lat,fangShi);
			}
			map.put("list", list);
			map.put("level", level);
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	/**
	 * 根据地图经纬度，等级进行查询
	 */
	@RequestMapping(value="/searchHouseByMapLocation-mobile", method = RequestMethod.POST) 
	public void searchHouseByMapLocation(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(">>>>>>>>>>"+content);
		try{
			jsonObject = JSONObject.fromObject(content);
			String lon = jsonObject.getString("lon");
			String lat = jsonObject.getString("lat");
			String huXingType =  jsonObject.getString("huXingType");
			String zhuangXiuType =  jsonObject.getString("zhuangXiuType");
			String priceType =  jsonObject.getString("priceType");
			String xingType =  jsonObject.getString("xingType");
			String houseType =  jsonObject.getString("houseType");
			
			
			List<HouseInfo> houseInfoList = houseInfoService.queryHouseInfoByLocation(lat, lon , houseType, xingType,huXingType, zhuangXiuType,priceType);
			map.put("list", houseInfoList);
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	/**
	 * 小区数据字典
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getHouseBase-mobile", method = RequestMethod.POST) 
	public void getHouseBase(@RequestBody String content,HttpServletResponse response){
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		System.out.println(">>>>>>>>>>"+content);
		try{
			jsonObject = JSONObject.fromObject(content);
			
			String lon = jsonObject.getString("lon");
			String lat = jsonObject.getString("lat");
			
			list = houseInfoService.queryHouseLevel1(lon, lat);
			
			map.put("list", list);
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}
	
	
	
	/**
	 * 检查版本
	 * 
	 * @param content
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/get-version-mobile", method = RequestMethod.GET)
	public void getVersion(@RequestBody String content,
			HttpServletRequest request,HttpServletResponse response){
		//Map<String, Object> map = new HashMap<String, Object>();
		NewVersionResp newVersionResp = new NewVersionResp();
		newVersionResp.setResult("0");
		//String version = WebContextUtil.getAppMap().get("android.version");
		String version = "1.2";
		newVersionResp.setVersion(version);
		newVersionResp.setUrl("http://139.196.152.207/ZHouse/client/zHouse.apk");
		newVersionResp.setMessage("发现新版本，请更新");
		
		response.setStatus(200);
		renderJson(newVersionResp,response);
	}
	
	/**
	 * 获取类型
	 * 
	 * @param content
	 * @param response
	 */
	@RequestMapping(value="/getHouseType-mobile", method = RequestMethod.POST) 
	public void getHouseType(@RequestBody String content,HttpServletResponse response){
		//userHouseService
		JSONObject jsonObject = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		try{
			jsonObject = JSONObject.fromObject(content);
			String sn = jsonObject.getString("sn");
			
			conditionMap.put("sn", sn);
			conditionMap.put("param1", "1");
			List<HouseType> list = houseTypeMapper.query(conditionMap);

			map.put("list", list);
			map.put("success", true);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
		}
		response.setStatus(200);
		renderJson(map,response);
	}	
	
	
	
	
	/*
	 * 上传用户图片
	 */
	@RequestMapping(value = "/uploadFileByImg-mobile", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public void uploadFileByImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 构建图片保存的目录
		String pathDir = "upload/apps";
		// 得到图片保存目录的真实路径
		String PATH_FOLDER = request.getSession().getServletContext().getRealPath(pathDir);
		// 构建图片临时保存的目录
		String tempPathDir = "tempUpload/apps";
		// 文件临时存放位置
		String TEMP_FOLDER = request.getSession().getServletContext().getRealPath(tempPathDir);
		// 根据真实路径创建目录
		File pathSaveFile = new File(PATH_FOLDER);
		if (!pathSaveFile.exists()) {
			pathSaveFile.mkdirs();
		}
		// 根据临时路径创建目录
		File tempPathSaveFile = new File(TEMP_FOLDER);
		if (!tempPathSaveFile.exists()) {
			tempPathSaveFile.mkdirs();
		}
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// 提交上来的信息都在这个list里面,可以上传多个文件
			@SuppressWarnings("unchecked")
			List<FileItem> list = upload.parseRequest(new ServletRequestContext(request));
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			// 保存后的文件名
			String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
			// 保存后图片的浏览器访问路径
			String picUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/apps/" + saveName;
			
			/**/
			System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");
			System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("临时目录:" + TEMP_FOLDER);
			System.out.println("上传的文件名:" + filename);
			System.out.println("保存后的文件名:" + saveName);
			System.out.println("浏览器访问路径:" + picUrl);
			System.out.println("------------------------------------------>");
			System.out.println("------------------------------------------>");
			
			
			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName));
			item.getOutputStream().close();
			
			//ImageUtil.scale2(PATH_FOLDER+"\\"+saveName,PATH_FOLDER+"\\_"+saveName,320,320,false);
			//String picUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/apps/_" + saveName;

			// 通过response把imageUrl传到前台
			PrintWriter writer = response.getWriter();

			writer.print("{");
			writer.print("msg:\"文件大小:" + item.getSize() + ",文件名:" + filename + "\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");

			writer.close();

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if (!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}

	private String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);
		return filename;
	}	
	
	
	
}
