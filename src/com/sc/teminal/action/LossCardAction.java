package com.sc.teminal.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.utils.DateConvertUtils;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.DevUserCard;
import com.sc.system.service.DevUserCardService;
import com.sc.teminal.pojo.DevDoorGroup;
import com.sc.teminal.service.DevDoorGroupService;


@Controller
@RequestMapping("/lossCard")
public class LossCardAction  extends BaseAction{

	@Autowired
	DevUserCardService devUserCardService;
	@Autowired
	DevDoorGroupService devDoorGroupService;

	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {

		LinkedHashMap<String,String> flagMap = new LinkedHashMap<String,String>();
		flagMap.put("-1", "全部");
		flagMap.put("1", "正常");
		flagMap.put("0", "已挂失");

		request.setAttribute("flagMap", flagMap);
		
		return "card/lossCardCenter";
	}
	
	
	@RequestMapping(value = "/num.htm", method = RequestMethod.GET)
	public String num(@ModelAttribute ConditionVO vo,
			HttpServletRequest request) {
		return "card/num";
	}
	
	
	@RequestMapping(value = "/list1.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list1(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<DevUserCard> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<DevUserCard> list = devUserCardService.queryDevUserCardsForPage(vo, page);
		super.readerPage2Json(list, response);

	}
}
