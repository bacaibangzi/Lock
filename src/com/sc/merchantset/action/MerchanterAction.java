package com.sc.merchantset.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.merchantset.service.MerchantserService;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.SystemAreaService;

/**
 * 注册商户action
 * 
 * @author cuibin
 * 
 */
@Controller
@RequestMapping("/merchantser")
public class MerchanterAction extends BaseAction {
	@Autowired
	MerchantserService merchantserService;
	@Autowired
	SystemAreaService systemAreaService;

	/**
	 * 注册商户主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh);
		
		return "merchantset/merchanterMain";
	}

	/**
	 * 根据code查找子区域信息
	 * @param code
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ajaxArea.htm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> ajaxArea(@RequestParam String code,HttpServletRequest request){
		Map<String,String> areaMap = null;
		try {
			areaMap = systemAreaService.queryAreaInfoForMapByCondition(code);
			System.out.println("================> "+code+", "+areaMap.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return areaMap;
	}
	
	/**
	 * 注册商户列表加载
	 * 
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<UserInfo> page, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		request.setAttribute("shMap", SessionConstants.user_sh);
		super.setPageInfo(page);
		Page<UserInfo> list = merchantserService.queryMerchantsersForPage(vo, page);
		super.readerPage2Json(list, response);

	}
	
	
	/**
	 * 注册商户编辑页面
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") UserInfo userInfo, Map<String, Object> map,HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		map.put("sexMap", SessionConstants.user_sex);
		if (vo.getEntityId() != null) {
			vo.setEntityId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
			BeanUtils
					.copyProperties(merchantserService.getMerchantserById(vo),userInfo);
		}
		 
		// 默认加载省列表
		try {
			request.setAttribute("provinceMap", systemAreaService.queryAreaInfoForMapByCondition("0"));
			request.setAttribute("cityMap", systemAreaService.queryAreaInfoForMapByCondition(String.valueOf(userInfo.getUiProvince())));
			request.setAttribute("areaMap", systemAreaService.queryAreaInfoForMapByCondition(String.valueOf(userInfo.getUiCity())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "merchantset/merchanterEidt";
	}

	
	/**
	 * 注册商户保存或修改操作
	 * 
	 * @param vo
	 * @param userInfo
	 * @param map
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo, @RequestParam String mark,
			@ModelAttribute("form") UserInfo userInfo, Map<String, Object> map, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		map.put("sexMap", SessionConstants.user_sex);
		map.put("shMap", SessionConstants.user_sh); 
		// 新增情况下设置上一级的组织编码
		if (userInfo.getUiOrgCode() == null || userInfo.getUiOrgCode().intern()=="") {
			userInfo.setUiOrgCode(vo.getOrgCode());
		} 
		try {
			merchantserService.saveOrUpdateMerchantserInfo(userInfo);
		} catch (Exception e) {
			if( e instanceof DuplicateKeyException){
				vo.setErrMsg("登录名不能重复！");
				return "merchantset/merchanterEidt"; 
			}
		}
		if(!mark.equals("userEdit")){
			return "merchantset/merchanterMain";
		}else{
			return "merchantcenter/user/userDetail";
		}
	}
	
	
	/**
	 * 注册商户审核
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh); 
		merchantserService.shMerchantserById(vo);
		return true;
	}
	
	/**
	 * 注册商户删除
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh); 
		merchantserService.deleteMerchantserById(vo);
		return true;
	}
	
}
