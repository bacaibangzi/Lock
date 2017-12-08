package com.sc.developer.action;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.developer.pojo.Apps;
import com.sc.developer.service.AppsService;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;


@Controller
@RequestMapping("/apps")
public class AppsAction extends BaseAction {
	@Autowired
	AppsService appsService;

	/**
	 * 产品服务页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "developer/appsMain";
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
			@ModelAttribute Page<Apps> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Apps> list = appsService.queryAppssForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * APPS编辑页面queryAppssPublishForPage
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(appsService.getAppsById(vo),Apps);
		}else{
			Apps.setAppid(UUID.randomUUID().toString());
			Apps.setAppkey(UUID.randomUUID().toString());
		}
		return "developer/appsEidt";
	}
	
	/**
	 * APPS详细信息页面
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(appsService.getAppsById(vo),Apps);
		return "developer/appsDetail";
	}
	
	/**
	 * 保存APPS信息
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		appsService.saveOrUpdateAppsInfo(Apps);
		return "developer/appsMain";
	}
	
	/**
	 * 删除APPS信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		appsService.deleteAppsById(vo);
		return "developer/appsMain";
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
		appsService.shById(vo);
		return true;
	}
	
	
	@RequestMapping(value = "/check.htm", method = RequestMethod.POST)
	@ResponseBody
	public Apps check(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		Apps apps = appsService.getAppsById(vo);
		return apps;
	}
	
	@RequestMapping(value = "/toReportRegister.htm", method = RequestMethod.GET)
	public String toReportRegister() {
		return "report/reportRegister";
	}
	
	@RequestMapping(value = "/toReportInstall.htm", method = RequestMethod.GET)
	public String toReportInstall() {
		return "report/reportInstall";
	}
	
	@RequestMapping(value = "/toReportActive.htm", method = RequestMethod.GET)
	public String toReportActive() {
		return "report/reportActive";
	}
	
	@RequestMapping(value = "/toReportLive.htm", method = RequestMethod.GET)
	public String toReportLive() {
		return "report/reportLive";
	}
	
	@RequestMapping(value = "/toReportCost.htm", method = RequestMethod.GET)
	public String toReportCost() {
		return "report/reportCost";
	}
	
}
