package com.sc.system.action;

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
import com.sc.system.pojo.DevUserCard;
import com.sc.system.service.DataService;
import com.sc.system.service.DevUserCardService;

@Controller
@RequestMapping("/devUserCard")
public class DevUserCardAction  extends BaseAction{

	@Autowired
	DevUserCardService devUserCardService;
	@Autowired
	DataService dataService;

	/**
	 * 短信日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/devUserCardFrame";
	}

	@RequestMapping(value = "/leftList.htm", method = RequestMethod.GET)
	public String leftTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
 
		return "system/devUserCardLeftList";
	}
	
	@RequestMapping(value = "/rightList.htm", method = RequestMethod.GET)
	public String rightTree(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo); 
		
		return "system/devUserCardRightList";
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
			@ModelAttribute Page<DevUserCard> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<DevUserCard> list = devUserCardService.queryDevUserCardsForPage(vo, page);
		super.readerPage2Json(list, response);

	}

	/**
	 * 角色编辑页面
	 * @param vo
	 * @param DevUserCard
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/eidt.htm", method = RequestMethod.GET)
	public String eidt(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevUserCard DevUserCard,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		DevUserCard.setUserId(Integer.parseInt(vo.getCode()));
		if(vo.getEntityId()!=null){
			BeanUtils.copyProperties(devUserCardService.getDevUserCardById(vo),DevUserCard);
		}
		
		// 卡类型
		List<Data> dataList = dataService.queryDatasByKeys("CARD");
		Map<String,String> typeMap = new HashMap<String,String>();
		for(Data data : dataList){
			typeMap.put(data.getName(), data.getName());
		}
		request.setAttribute("typeMap", typeMap);
		
		return "system/devUserCardEidt";
	}
	
	/**
	 * 角色详细信息页面
	 * @param vo
	 * @param DevUserCard
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevUserCard DevUserCard,HttpServletRequest request) throws Exception{
		request.setAttribute("vo", vo);
		BeanUtils.copyProperties(devUserCardService.getDevUserCardById(vo),DevUserCard);
		return "system/devUserCardDetail";
	}
	
	/**
	 * 保存角色信息
	 * @param vo
	 * @param DevUserCard
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save.htm", method = RequestMethod.POST)
	public String save(@ModelAttribute ConditionVO vo,@ModelAttribute("form") DevUserCard DevUserCard,HttpServletRequest request) throws Exception{
		vo.setCode(DevUserCard.getUserId().toString());
		request.setAttribute("vo", vo);
		// 卡类型
				List<Data> dataList = dataService.queryDatasByKeys("CARD");
				Map<String,String> typeMap = new HashMap<String,String>();
				for(Data data : dataList){
					typeMap.put(data.getName(), data.getName());
				}
				request.setAttribute("typeMap", typeMap);
		// 判断是否存在卡号
		List<DevUserCard> list = devUserCardService.queryDevUserCardsByCondition(DevUserCard.getCardNum());
		if(list!=null&&list.size()>0&&DevUserCard.getSn()==null){
			vo.setErrMsg("改卡号已经被使用");
			return "system/devUserCardEidt";
		}else{
		
			devUserCardService.saveOrUpdateDevUserCardInfo(DevUserCard);
			return "system/devUserCardRightList";
		}
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
		devUserCardService.deleteDevUserCardById(vo);
		return "system/devUserCardRightList";
	}
}
