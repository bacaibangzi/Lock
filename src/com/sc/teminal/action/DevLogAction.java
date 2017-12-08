package com.sc.teminal.action;

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

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.pojo.DevLog;
import com.sc.teminal.service.DevLogService;

@Controller
@RequestMapping("/devLog")
public class DevLogAction  extends BaseAction{

	@Autowired
	DevLogService DevLogService;

	/**
	 * 日志列表页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/logMain";
	}

	/**
	 * 加载日志列表信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<DevLog> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<DevLog> list = DevLogService.queryDevsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 日志编辑页面
	 * @param vo
	 * @param DevLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevLog DevLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(DevLogService.getDevById(vo),DevLog);
		}
		return "teminal/DevLogEidt";
	}
	
	/**
	 * 日志详细信息页面
	 * @param vo
	 * @param DevLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevLog DevLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(DevLogService.getDevById(vo),DevLog);
		return "teminal/DevLogDetail";
	}
	
	/**
	 * 保存日志信息
	 * @param vo
	 * @param DevLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute DevLog DevLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		try {
			DevLogService.saveOrUpdateDevInfo(DevLog);
		} catch (Exception e) {
			if( e instanceof DuplicateKeyException){
				return "duplicate";
			}
			return "false";
		}
		return "true";
	}
	

	
}
