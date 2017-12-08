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
import com.sc.teminal.pojo.Controllerinfo;
import com.sc.teminal.pojo.Stationinfo;
import com.sc.teminal.service.ControllerinfoService;
import com.sc.teminal.service.StationinfoService;

@Controller
@RequestMapping("/controllerinfo")
public class ControllerinfoAction  extends BaseAction{
	@Autowired
	ControllerinfoService controllerinfoService;
	@Autowired
	StationinfoService stationinfoService;

	/**
	 * 短信日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "teminal/controllerinfoMain";
	}
	
	/**
	 * sc
	 * @return
	 */
	@RequestMapping(value = "/toSc.htm", method = RequestMethod.GET)
	public String toSc() {
		return "teminal/controllerinfoSC";
	}
	/**
	 * sp
	 * @return
	 */
	@RequestMapping(value = "/toSp.htm", method = RequestMethod.GET)
	public String toSp() {
		return "teminal/controllerinfoSP";
	}
	/**
	 * sc
	 * @return
	 */
	@RequestMapping(value = "/toMp.htm", method = RequestMethod.GET)
	public String toMp() {
		return "teminal/controllerinfoMP";
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
			@ModelAttribute Page<Controllerinfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Controllerinfo> list = controllerinfoService.queryControllerinfosForPage(vo, page);
		
		for(Controllerinfo controllerinfo : list.getResult()){
			vo.setEntityId(controllerinfo.getStationId()+"");
			Stationinfo stationinfo = stationinfoService.getStationinfoById(vo);
			controllerinfo.setStationName(stationinfo.getStationName());
		}
		
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param Controllerinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Controllerinfo Controllerinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(controllerinfoService.getControllerinfoById(vo),Controllerinfo);
		}
		return "teminal/controllerinfoEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param Controllerinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Controllerinfo Controllerinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(controllerinfoService.getControllerinfoById(vo),Controllerinfo);
		return "teminal/controllerinfoDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param Controllerinfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute Controllerinfo Controllerinfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		controllerinfoService.saveOrUpdateControllerinfoInfo(Controllerinfo);
		return "teminal/controllerinfoMain";
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
		controllerinfoService.deleteControllerinfoById(vo);
		return "system/ControllerinfoMain";
	}
}
