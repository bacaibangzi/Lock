package com.sc.teminal.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.sc.system.pojo.Data;
import com.sc.system.service.DataService;
import com.sc.teminal.pojo.DevTypeTerminal;
import com.sc.teminal.service.DevTypeTerminalService;

@Controller
@RequestMapping("/devTypeTerminal")
public class DevTypeTerminalAction   extends BaseAction{

	@Autowired
	DevTypeTerminalService DevTypeTerminalService;
	@Autowired
	DataService dataService;

	/**
	 * 类型对应门页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		return "teminal/devTypeTerminalFrame";
	}
	
	@RequestMapping(value = "/left.htm", method = RequestMethod.GET)
	public String left(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		return "teminal/devTypeTerminalLeft";
	}
	
	@RequestMapping(value = "/right.htm", method = RequestMethod.GET)
	public String right(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		request.setAttribute("vo", vo);
		return "teminal/devTypeTerminalRight";
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
			@ModelAttribute Page<DevTypeTerminal> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page); 
		Page<DevTypeTerminal> list = DevTypeTerminalService.queryDevTypeTerminalsForPage(vo, page);
		super.readerPage2Json(list, response);
	}
	
	@RequestMapping(value = "/list1.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list1(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<DevTypeTerminal> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page); 
		Page<DevTypeTerminal> list =  new Page<DevTypeTerminal>();
		list.setResult(DevTypeTerminalService.queryDevTypeTerminalsByCondition(vo));
		super.readerPage2Json(list, response);
	}
	

	/**
	 * 终端编辑页面
	 * @param vo
	 * @param DevTypeTerminal
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevTypeTerminal DevTypeTerminal, HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(DevTypeTerminalService.getDevTypeTerminalById(vo),DevTypeTerminal);
		}
		List<Data> dataList = dataService.queryDatasByKeys("USER");
		Map<String,String> typeMap = new HashMap<String,String>();
		for(Data data : dataList){
			typeMap.put(data.getCode(), data.getName());
		}
		request.setAttribute("typeMap", typeMap);
		return "teminal/devTypeTerminalEidt";
	}
	
	/**
	 * 终端详细信息页面
	 * @param vo
	 * @param DevTypeTerminal
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevTypeTerminal DevTypeTerminal,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(DevTypeTerminalService.getDevTypeTerminalById(vo),DevTypeTerminal);
		return "teminal/devTypeTerminalDetail";
	}
	
	/**
	 * 保存终端信息
	 * @param vo
	 * @param DevTypeTerminal
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute DevTypeTerminal DevTypeTerminal,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		//DevTypeTerminalService.saveOrUpdateDevTypeTerminalInfo(DevTypeTerminal);
		
		DevTypeTerminalService.save(vo.getEntityIds(), Integer.parseInt(vo.getCode1()), vo.getCode2(), Integer.parseInt(vo.getCode3()));
		return "true";
	}
	
	/**
	 * 删除终端信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	//@ResponseBody
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		DevTypeTerminalService.deleteDevTypeTerminalById(vo);
		return "teminal/devTypeTerminalLeft";
	}

}
