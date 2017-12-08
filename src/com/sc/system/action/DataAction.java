package com.sc.system.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
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

@Controller
@RequestMapping("/data")
public class DataAction extends BaseAction {


	@Autowired
	DataService dataService;

	/**
	 * 数据字典列表页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/dataMain";
	}

	/**
	 * 加载数据字典列表信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<Data> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Data> list = dataService.queryDatasForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 数据字典编辑页面
	 * @param vo
	 * @param Data
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Data Data,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(dataService.getDataById(vo),Data);
		}
		return "system/dataEidt";
	}
	
	/**
	 * 数据字典详细信息页面
	 * @param vo
	 * @param Data
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Data Data,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(dataService.getDataById(vo),Data);
		return "system/dataDetail";
	}
	
	/**
	 * 保存数据字典信息
	 * @param vo
	 * @param Data
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	@ResponseBody
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute Data Data,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		try {
			dataService.saveOrUpdateDataInfo(Data);
		} catch (Exception e) {
			if( e instanceof DuplicateKeyException){
				return "duplicate";
			}
			return "false";
		}
		return "true";
	}
	
	/**
	 * 删除数据字典信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean delete(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		try {
			dataService.deleteDataById(vo);
		} catch (Exception e) {
			if( e instanceof DataIntegrityViolationException){
				return false;
			}
		}
		return true;
	}

}
