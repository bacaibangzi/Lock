package com.sc.merchantset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.merchantset.service.DistributorService;
import com.sc.system.pojo.RoleInfo;

/**
 * 经销商服务信息
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/distributor")
public class DistributorAction  extends BaseAction{

	@Autowired
	DistributorService distributorService;
	
	/**
	 * 经销商服务列表页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/distributorMain";
	}
	
	
	/**
	 * 加载经销商服务列表信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<RoleInfo> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<RoleInfo> list = distributorService.queryServerForPage(vo, page);
		super.readerPage2Json(list, response);

	}
	
	/**
	 * 经销商服务编辑页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(distributorService.getServerById(vo),RoleInfo);
		}
		return "system/distributorEidt";
	}
	
	
	/**
	 * 经销商服务详细信息页面
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") RoleInfo RoleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(distributorService.getServerById(vo),RoleInfo);
		return "system/distributorDetail";
	}
	
	
	/**
	 * 保存经销商服务信息
	 * @param vo
	 * @param RoleInfo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute RoleInfo roleInfo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		distributorService.saveOrUpdateServer(roleInfo);
		return "system/distributorMain";
	}
	
	/**
	 * 删除商户服务信息
	 * 
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String dishTypeDelete(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception {
		request.setAttribute("vo", vo);
		try {
			distributorService.deleteServerById(vo);
		} catch (Exception e) {
			if( e instanceof DataIntegrityViolationException){
				request.setAttribute("message", "删除出错~");
				return "system/distributorMain";
			}
		}
		return "system/distributorMain";
	}
}
