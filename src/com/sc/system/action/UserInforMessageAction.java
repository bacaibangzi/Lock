package com.sc.system.action;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.UserInforMessage;
import com.sc.system.service.UserInforMessageService;

@Controller
@RequestMapping("/userInforMessage")
public class UserInforMessageAction extends BaseAction{
	@Autowired
	UserInforMessageService userInforMessageService;

	/**
	 * 缴费日志页面
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/userInforMessageMain";
	}

	/**
	 * 加载缴费日志信息
	 * @param vo
	 * @param page
	 * @param response
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.POST)
	@ResponseBody
	public void list(@ModelAttribute ConditionVO vo,
			@ModelAttribute Page<UserInforMessage> page, HttpServletResponse response) throws Exception {
		super.setPageInfo(page);
		Page<UserInforMessage> list = userInforMessageService.queryUserInforMessagesForPage(vo, page);
		super.readerPage2Json(list, response);

	}
}
