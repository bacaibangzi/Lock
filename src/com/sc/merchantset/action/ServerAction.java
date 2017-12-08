package com.sc.merchantset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.merchantset.service.ServerService;
import com.sc.system.pojo.RoleInfo;

/**
 * 商户服务action
 * 
 * @author cuibin
 * 
 */
@Controller
@RequestMapping("/server")
public class ServerAction extends BaseAction{
	@Autowired
	ServerService serverService;
	
	/**
	 * 商户服务列表页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "merchantset/serverMain";
	}
	
	
	/**
	 * 加载商户服务列表信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<RoleInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<RoleInfo> list = serverService.queryServerForPage(vo, page);
		super.readerPage2Json(list, response);

	}
	
	/**
	 * 商户服务编辑页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(serverService.getServerById(vo),RoleInfo);
		}
		return "merchantset/serverEidt";
	}
	
	
	/**
	 * 商户服务详细信息页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(serverService.getServerById(vo),RoleInfo);
		return "merchantset/serverDetail";
	}
	
	
	/**
	 * 保存商户服务信息
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute RoleInfo roleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		serverService.saveOrUpdateServer(roleInfo);
		return "merchantset/serverMain";
	}
	
	/**
	 * 删除商户服务信息
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String dishTypeDelete(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		try {
			serverService.deleteServerById(vo);
		} catch (Exception e) {
			if( e instanceof DataIntegrityViolationException){
				request.setAttribute("message", "删除出错~");
				return "merchantset/serverMain";
			}
		}
		return "merchantset/serverMain";
	}
	
	
}
