package com.sc.system.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统管理页面
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/system1")
public class SystemHomeAction {

	@RequestMapping(value = "/toMain.htm", method = RequestMethod.GET)
	public String toMain(){
		return "system/main";
	}
	
}
