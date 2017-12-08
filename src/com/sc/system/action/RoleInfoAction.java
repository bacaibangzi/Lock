package com.sc.system.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.RoleInfo;
import com.sc.system.service.RoleInfoService;

/**
 * 
 * 角色信息action
 * 
 */
@Controller
@RequestMapping("/role")
public class RoleInfoAction extends BaseAction {
	@Autowired
	RoleInfoService roleInfoService;

	/**
	 * 角色列表页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/roleMain";
	}

	/**
	 * 加载角色列表信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<RoleInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<RoleInfo> list = roleInfoService.queryRoleInfosForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(roleInfoService.getRoleInfoById(vo),RoleInfo);
		}
		return "system/roleEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(roleInfoService.getRoleInfoById(vo),RoleInfo);
		return "system/roleDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		roleInfoService.saveOrUpdateRoleInfoInfo(RoleInfo);
		return "system/roleMain";
	}
	
	/**
	 * 删除角色信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		roleInfoService.deleteRoleInfoById(vo);
		return "system/roleMain";
	}
	
}
