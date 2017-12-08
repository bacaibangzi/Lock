package com.sc.zhouse.action;

import java.util.HashMap;
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
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.zhouse.pojo.News;
import com.sc.zhouse.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsAction extends BaseAction{

	@Autowired
	NewsService newsService;

	/**
	 * 产品服务页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(HttpServletRequest request) {
		Map<Long,String> user_sh = new HashMap<Long,String>();
		user_sh.put(0l, "未审核");
		user_sh.put(1l, "通过");
		request.setAttribute("shMap", user_sh);
		return "zhouse/newsMain";
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
			@ModelAttribute Page<News> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<News> list = newsService.queryNewssForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * News编辑页面queryNewssPublishForPage
	 * @param vo
	 * @param News
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") News News,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(newsService.getNewsById(vo),News);
		}else{ 
		}
		return "zhouse/newsEidt";
	}
	
	/**
	 * News详细信息页面
	 * @param vo
	 * @param News
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") News News,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(newsService.getNewsById(vo),News);
		return "zhouse/newsDetail";
	}
	
	/**
	 * 保存News信息
	 * @param vo
	 * @param News
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute News news,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		news.setUserId(((AccountInfo) request.getSession().getAttribute("accountInfo")).getUserId().intValue());
		news.setUserName(((AccountInfo) request.getSession().getAttribute("accountInfo")).getUserName());
		newsService.saveOrUpdateNewsInfo(news);
		return "zhouse/newsMain";
	}
	
	/**
	 * 删除News信息
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/delete.htm", method = RequestMethod.GET)
	public String delete(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		newsService.deleteNewsById(vo);
		return "zhouse/newsMain";
	}
	
	/**
	 * 申请
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/sh.htm", method = RequestMethod.POST)
	@ResponseBody
	public boolean sh(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		newsService.shById(vo);
		return true;
	}
	
	
	@RequestMapping(value = "/check.htm", method = RequestMethod.POST)
	@ResponseBody
	public News check(@ModelAttribute ConditionVO vo,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		News News = newsService.getNewsById(vo);
		return News;
	}
}
