package com.sc.system.action;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.UserInfoService;

/**
 * 员工管理
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/businessUser")
public class BusinessUserAction  extends BaseAction{


	@Autowired
	UserInfoService userInfoService;
	@Autowired
	OrgInfoService orgInfoService;

	/**
	 * 系统用户主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/businessUserFrame";
	}

	/**
	 * 系统用户树状Tree结构
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/leftTree.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);

		// 加载系统用户tree 图片路径
		String path = "../application/images/icon/org_start.png";

		vo.setUserId(((AccountInfo)request.getSession().getAttribute("accountInfo")).getUserId().toString());
		List<OrgInfo> list = orgInfoService.queryOrgInfosByOrgCodeData(vo);
		List<Map<String, Object>> nodeList = getOrgTreeNode(list, path, vo.getOrgCode());
		request.setAttribute("nodeList", new Gson().toJson(nodeList));
		return "system/businessUserLeftTree";
	}

	/**
	 * 系统用户列表界面
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String center(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh); 
		return "system/businessUserCenter"; 
	}

	/**
	 * 系统用户列表加载
	 * 
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<UserInfo> page, HttpServletResponse response,HttpServletRequest request)  throws Exception{
		request.setAttribute("shMap", SessionConstants.user_sh); 
		super.setPageInfo(page);
		Page<UserInfo> list = userInfoService.queryUserInfosForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 系统用户编辑页面
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") UserInfo UserInfo, Map<String, Object> map,HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		
		map.put("sexMap", SessionConstants.user_sex); 
		if (vo.getEntityId() != null) {
			BeanUtils
					.copyProperties(userInfoService.getUserInfoById(vo), UserInfo);
		}
		return "system/businessUserEidt";
	}

	/**
	 * 系统用户查看界面
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") UserInfo UserInfo, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(userInfoService.getUserInfoById(vo), UserInfo);
		return "system/businessUserDetail";
	}

	/**
	 * 系统用户保存
	 * 
	 * @param vo
	 * @param UserInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,
			@ModelAttribute("form") UserInfo userInfo, Map<String, Object> map, HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		map.put("sexMap", SessionConstants.user_sex); 
		request.setAttribute("shMap", SessionConstants.user_sh); 
		// 新增情况下设置上一级的组织编码
		if (userInfo.getUiOrgCode() == null || userInfo.getUiOrgCode().intern()=="") {
			userInfo.setUiOrgCode(vo.getOrgCode());
		} 
		try {
			userInfoService.BusinessUserSaveOrUpdateUserInfoInfo(userInfo);
		} catch (Exception e) {
			if( e instanceof DuplicateKeyException){
				vo.setErrMsg("登录名不能重复！");
				return "system/businessUserEidt"; 
			}
		}
		return "system/businessUserCenter";
	}

	/**
	 * 系统用户删除
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
		try {
			return userInfoService.deleteUserInfoById(vo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 用户审核
	 * @param ConditionVO
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo,
			HttpServletRequest request)  throws Exception{
		request.setAttribute("vo", vo);
		request.setAttribute("shMap", SessionConstants.user_sh); 
		userInfoService.shUserInfoById(vo);
		//return "system/userCenter";
		return true;
	}

}
