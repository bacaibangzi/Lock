package com.sc.zhouse.action;

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
import com.sc.zhouse.pojo.HouseType;
import com.sc.zhouse.service.HouseTypeService;

@Controller
@RequestMapping("/houseType")
public class HouseTypeAction extends BaseAction{
	@Autowired
	HouseTypeService houseTypeService;

	/**
	 * 类型页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "zhouse/houseTypeMain";
	}

	/**
	 * 加载类型信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<HouseType> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<HouseType> list = houseTypeService.queryHouseTypesForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * HouseType编辑页面queryHouseTypesPublishForPage
	 * @param vo
	 * @param HouseType
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") HouseType HouseType,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(houseTypeService.getHouseTypeById(vo),HouseType);
		}else{ 
		}
		return "zhouse/houseTypeEidt";
	}
	
	/**
	 * HouseType详细信息页面
	 * @param vo
	 * @param HouseType
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") HouseType HouseType,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(houseTypeService.getHouseTypeById(vo),HouseType);
		return "zhouse/houseTypeDetail";
	}
	
	/**
	 * 保存HouseType信息
	 * @param vo
	 * @param HouseType
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute HouseType HouseType,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		houseTypeService.saveOrUpdateHouseTypeInfo(HouseType);
		return "zhouse/houseTypeMain";
	}
	
	/**
	 * 删除HouseType信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		houseTypeService.deleteHouseTypeById(vo);
		return "zhouse/houseTypeMain";
	}
}
