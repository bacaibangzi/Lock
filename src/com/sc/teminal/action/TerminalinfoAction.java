package com.sc.teminal.action;

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
import com.sc.teminal.pojo.Terminalinfo;
import com.sc.teminal.service.TerminalinfoService;

@Controller
@RequestMapping("/terminalinfo")
public class TerminalinfoAction extends BaseAction{

	@Autowired
	TerminalinfoService terminalinfoService;

	/**
	 * 终端页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/terminalinfoMain";
	}

	/**
	 * 加载终端信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Terminalinfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		System.out.println("***********************> vo.getNameFilter():"+vo.getNameFilter());
		System.out.println("***********************> vo.getNameFilter1():"+vo.getNameFilter1());
		Page<Terminalinfo> list = terminalinfoService.queryTerminalinfosForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 终端编辑页面
	 * @param vo
	 * @param Terminalinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Terminalinfo Terminalinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(terminalinfoService.getTerminalinfoById(vo),Terminalinfo);
		}
		return "teminal/terminalinfoEidt";
	}
	
	/**
	 * 终端详细信息页面
	 * @param vo
	 * @param Terminalinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Terminalinfo Terminalinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(terminalinfoService.getTerminalinfoById(vo),Terminalinfo);
		return "teminal/terminalinfoDetail";
	}
	
	/**
	 * 保存终端信息
	 * @param vo
	 * @param Terminalinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute Terminalinfo Terminalinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		terminalinfoService.saveOrUpdateTerminalinfoInfo(Terminalinfo);
		return "teminal/terminalinfoMain";
	}
	
	/**
	 * 删除终端信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		terminalinfoService.deleteTerminalinfoById(vo);
		return "system/TerminalinfoMain";
	}
	
}
