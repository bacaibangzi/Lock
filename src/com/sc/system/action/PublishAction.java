package com.sc.system.action;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.developer.pojo.Apps;
import com.sc.developer.service.AppsService;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
@Controller
@RequestMapping("/publish")
public class PublishAction extends BaseAction  {
	@Autowired
	AppsService appsService;

	/**
	 * 产品服务页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(HttpServletRequest request) {
		Map<Long,String> shMap = new HashMap<Long,String>();
		shMap.put(1L, "未审核");
		shMap.put(2L, "已审核");
		request.setAttribute("shMap", shMap);
		return "system/publishMain";
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
			@ModelAttribute Page<Apps> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<Apps> list = appsService.queryAppssPublishForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * APPS编辑页面
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(appsService.getAppsById(vo),Apps);
		}else{
			Apps.setAppid(UUID.randomUUID().toString());
		}
		return "system/publishEidt";
	}
	
	/**
	 * APPS详细信息页面
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(appsService.getAppsById(vo),Apps);
		return "system/publishDetail";
	}
	
	/**
	 * 保存APPS信息
	 * @param vo
	 * @param Apps
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute Apps Apps,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		
		appsService.saveOrUpdateAppsInfo(Apps);
		return "system/publishMain";
	}
	
	/**
	 * 删除APPS信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		appsService.deleteAppsById(vo);
		return "system/publishMain";
	}	
	/**
	 * 审核APPS信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		appsService.shById(vo);
		return true;
	}
}
