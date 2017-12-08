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
import com.sc.system.pojo.SmsLog;
import com.sc.system.service.SmsLogService;

/**
 * 短信日志
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/smsLog")
public class SmsLogAction  extends BaseAction {
	@Autowired
	SmsLogService smsLogService;

	/**
	 * 短信日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/smsLogMain";
	}

	/**
	 * 加载短信日志信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<SmsLog> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<SmsLog> list = smsLogService.querySmsLogsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param SmsLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") SmsLog SmsLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(smsLogService.getSmsLogById(vo),SmsLog);
		}
		return "system/smsLogEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param SmsLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") SmsLog SmsLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(smsLogService.getSmsLogById(vo),SmsLog);
		return "system/smsLogDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param SmsLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute SmsLog SmsLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		smsLogService.saveOrUpdateSmsLogInfo(SmsLog);
		return "system/smsLogMain";
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
		smsLogService.deleteSmsLogById(vo);
		return "system/smsLogMain";
	}
}
