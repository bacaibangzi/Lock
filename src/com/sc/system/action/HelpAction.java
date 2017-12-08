package com.sc.system.action;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.sc.framework.vo.ConditionVO;
import com.sc.framework.vo.Page;
import com.sc.system.pojo.RoleInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.pojo.UserRole;
import com.sc.system.service.RoleInfoService;
import com.sc.system.service.UserInfoService;
import com.sc.system.service.UserRoleService;

/**
 * 用户角色
 * 
 * @author pan
 * 
 */
@Controller
@RequestMapping("/help")
public class HelpAction extends BaseAction {
	@Autowired
	UserRoleService userRoleService;
	@Autowired
	RoleInfoService roleInfoService;
	@Autowired
	UserInfoService userInfoService;

	/**
	 * 帮助主界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain() {
		return "system/helpMain";
	}
	
	/**
	 * 基本操作
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpBase.htm", method = RequestMethod.GET)
	public String baseHelp() {
		return "system/helpBase";
	}
	
	/**
	 * 建立连锁
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpEstablishChain.htm", method = RequestMethod.GET)
	public String helpEstablishChain() {
		return "system/helpEstablishChain";
	}
	
	/**
	 * 单店模式
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpSingleModel.htm", method = RequestMethod.GET)
	public String helpSingleModel() {
		return "system/helpSingleModel";
	}
	
	/**
	 * 云会员
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpCloudMember.htm", method = RequestMethod.GET)
	public String helpCloudMember() {
		return "system/helpCloudMember";
	}
	
	/**
	 * 微信点餐
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpWeChatOrder.htm", method = RequestMethod.GET)
	public String helpWeChatOrder() {
		return "system/helpWeChatOrder";
	}
	
	/**
	 * 连锁配送
	 * 
	 * @return
	 */
	@RequestMapping(value = "/helpChainDistribution.htm", method = RequestMethod.GET)
	public String helpChainDistribution() {
		return "system/helpChainDistribution";
	}
}
