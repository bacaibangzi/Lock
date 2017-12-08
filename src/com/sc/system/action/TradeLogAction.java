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
import com.sc.system.pojo.TradeLog;
import com.sc.system.service.TradeLogService;

/**
 * 缴费日志
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/tradeLog")
public class TradeLogAction  extends BaseAction {
	@Autowired
	TradeLogService tradeLogService;

	/**
	 * 缴费日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/tradeLogMain";
	}

	/**
	 * 加载缴费日志信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<TradeLog> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<TradeLog> list = tradeLogService.queryTradeLogsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param TradeLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") TradeLog TradeLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(tradeLogService.getTradeLogById(vo),TradeLog);
		}
		return "system/tradeLogEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param TradeLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") TradeLog TradeLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(tradeLogService.getTradeLogById(vo),TradeLog);
		return "system/tradeLogDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param TradeLog
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute TradeLog TradeLog,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		tradeLogService.saveOrUpdateTradeLogInfo(TradeLog);
		return "system/tradeLogMain";
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
		tradeLogService.deleteTradeLogById(vo);
		return "system/tradeLogMain";
	}
}
