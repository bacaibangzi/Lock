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
import com.sc.system.pojo.ProductService;
import com.sc.system.service.ProductServiceService;

/**
 * 产品服务
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/productService")
public class ProductServiceAction  extends BaseAction {
	@Autowired
	ProductServiceService productServiceService;

	/**
	 * 产品服务页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/productServiceMain";
	}

	/**
	 * 加载产品服务信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<ProductService> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<ProductService> list = productServiceService.queryProductServicesForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param ProductService
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") ProductService ProductService,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(productServiceService.getProductServiceById(vo),ProductService);
		}
		return "system/productServiceEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param ProductService
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") ProductService ProductService,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(productServiceService.getProductServiceById(vo),ProductService);
		return "system/productServiceDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param ProductService
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute ProductService ProductService,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		productServiceService.saveOrUpdateProductServiceInfo(ProductService);
		return "system/productServiceMain";
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
		productServiceService.deleteProductServiceById(vo);
		return "system/productServiceMain";
	}
}
