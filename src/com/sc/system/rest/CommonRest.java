package com.sc.system.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.system.dao.SystemMenuMapper;
import com.sc.system.dao.UserInfoMapper;
import com.sc.system.pojo.SystemMenu;
import com.sc.system.pojo.UserInfo;

@Controller
@RequestMapping("/commonRest")
public class CommonRest {
	@Autowired
	SystemMenuMapper systemMenuMapper;
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@RequestMapping(value = "/queryMenus.exec", method = RequestMethod.GET)
	@ResponseBody
	public List<SystemMenu> queryMenusByCondition(@RequestBody String content,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		String code = request.getParameter("code");
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("fiId", code);
		return systemMenuMapper.query(conditionMap);
	}
	
	@RequestMapping(value = "/getUserByName.exec", method = RequestMethod.GET)
	@ResponseBody
	public UserInfo getUserByName(@RequestBody String content,
			HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		System.out.println("****************************");
		String name = request.getParameter("name");
		return userInfoMapper.getByLoginName(name);
	}
}
