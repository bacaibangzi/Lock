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
@RequestMapping("/vhuisYanc")
public class VhuisYancAction  extends BaseAction{

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
		
		return "teminal/vhuisYancMain";
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
			@ModelAttribute Page<VhuisYanc> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page); 
		if(vo.getCode3()!=null&&!"".equals(vo.getCode3())){
			vo.setCode3(vo.getCode3().replaceAll(":", "").replaceAll(" ", "").replaceAll("-", ""));
		}
		if(vo.getCode4()!=null&&!"".equals(vo.getCode4())){
			vo.setCode4(vo.getCode4().replaceAll(":", "").replaceAll(" ", "").replaceAll("-", ""));
		}
		
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
		return "teminal/VhuisYancEidt";
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
		return "teminal/vhuisYancDetail";
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
		return "teminal/VhuisYancMain";
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
		return "system/VhuisYancMain";
	}
}
