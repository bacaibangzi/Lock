package com.sc.teminal.action;

import java.util.Calendar;
import java.util.Date;

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
import com.sc.framework.utils.DateConvertUtils;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.teminal.pojo.VhuisYanc;
import com.sc.teminal.service.VhuisYancService;



@Controller
@RequestMapping("/fail")
public class FailAction  extends BaseAction{

	@Autowired
	VhuisYancService vhuisYancService;

	/**
	 * 终端页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		Calendar calendar = Calendar.getInstance();
	    Date date = new Date(System.currentTimeMillis());
	    calendar.setTime(date);
	    calendar.add(Calendar.YEAR, 1);
	    date = calendar.getTime();
		
	    String rqStr = DateConvertUtils.format(date,"yyyy-MM-dd HH:mm");
		
	    request.setAttribute("rqStr", rqStr);
		
		return "card/failMain";
	}
	
	@RequestMapping(value = "/main1.htm", method = RequestMethod.GET)
	public String toMain1(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		Calendar calendar = Calendar.getInstance();
	    Date date = new Date(System.currentTimeMillis());
	    calendar.setTime(date);
	    calendar.add(Calendar.YEAR, 1);
	    date = calendar.getTime();
		
	    String rqStr = DateConvertUtils.format(date,"yyyy-MM-dd HH:mm");
		
	    request.setAttribute("rqStr", rqStr);
		
		return "card/failMain1";
	}
	
	@RequestMapping(value = "/main2.htm", method = RequestMethod.GET)
	public String toMain2(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		Calendar calendar = Calendar.getInstance();
	    Date date = new Date(System.currentTimeMillis());
	    calendar.setTime(date);
	    calendar.add(Calendar.YEAR, 1);
	    date = calendar.getTime();
		
	    String rqStr = DateConvertUtils.format(date,"yyyy-MM-dd HH:mm");
		
	    request.setAttribute("rqStr", rqStr);
		
		return "card/failMain2";
	}

	/**
	 * 加载终端信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list1.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list1(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuisYanc> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page); 
		vo.setShFilter("0");
		Page<VhuisYanc> list = vhuisYancService.queryVhuisYancsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 加载终端信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list2.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list2(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<VhuisYanc> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page); 
		vo.setShFilter("2");
		Page<VhuisYanc> list = vhuisYancService.queryVhuisYancsForPage(vo, page);
		super.readerPage2Json(list, response);

	}
	
	/**
	 * 终端编辑页面
	 * @param vo
	 * @param VhuisYanc
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") VhuisYanc VhuisYanc,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(vhuisYancService.getVhuisYancById(vo),VhuisYanc);
		}
		return "teminal/failEidt";
	}
	
	/**
	 * 终端详细信息页面
	 * @param vo
	 * @param VhuisYanc
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") VhuisYanc VhuisYanc,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(vhuisYancService.getVhuisYancById(vo),VhuisYanc);
		return "teminal/failDetail";
	}
	
	/**
	 * 保存终端信息
	 * @param vo
	 * @param VhuisYanc
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute VhuisYanc VhuisYanc,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		vhuisYancService.saveOrUpdateVhuisYancInfo(VhuisYanc);
		return "teminal/failMain";
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
		vhuisYancService.deleteVhuisYancById(vo);
		return "teminal/failMain";
	}

}
