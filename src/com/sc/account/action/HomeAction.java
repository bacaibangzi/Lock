package com.sc.account.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.sc.framework.base.action.BaseAction;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.interfaces.IUserRoleMenu;
import com.sc.system.pojo.UserRoleMenu;

/**
 * 用户登录，注册前台action
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/")
public class HomeAction extends BaseAction{

	@Autowired
	IUserRoleMenu iUserRoleMenu;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.registerCustomEditor(Date.class, new DateConvertEditor());
		binder
				.registerCustomEditor(String.class, new StringTrimmerEditor(
						true));
	}

	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value = "/toLogin.htm", method = RequestMethod.GET)
	public String toLogin() {
		System.out.println(">>>> toLogin <<<<");
		return "/login";
	}
	
	/**
	 * 注册页面
	 */
	@RequestMapping(value = "/toReg.htm", method = RequestMethod.GET)
	public String toReg(){
		return "/reg";
	}
	
	/**
	 * 注册成功页面
	 */
	@RequestMapping(value = "/default.htm", method = RequestMethod.GET)
	public String toDefault(){
		return "/default";
	}
	
	/**
	 * 找回密码页面
	 */
	@RequestMapping(value = "/sendPass.htm", method = RequestMethod.GET)
	public String toSendPass(){
		return "/sendPass";
	}
	
	/**
	 * 注册页面
	 */
	@RequestMapping(value = "/toContact.htm", method = RequestMethod.GET)
	public String toContact(){
		return "/contact";
	}

	/**
	 * 留言页面
	 */
	@RequestMapping(value = "/toLy.htm", method = RequestMethod.GET)
	public String toLy(){
		return "/ly";
	}
	
	/**
	 * 修改密码页面
	 */
	@RequestMapping(value = "/toPass.htm", method = RequestMethod.GET)
	public String toPass(){
		return "pass";
	}
	
	/**
	 * android下载页面
	 * @return
	 */
	@RequestMapping(value = "/toAndroid.htm", method = RequestMethod.GET)
	public String toAndroid(){
		return "android";
	}
	
	/**
	 * IOS下载页面
	 * @return
	 */
	@RequestMapping(value = "/toIOS.htm", method = RequestMethod.GET)
	public String toIOS(){
		return "ios";
	}
	
	/**
	 * 首页页面
	 */
	@RequestMapping(value = "/main1.htm", method = RequestMethod.GET)
	public String toMain(HttpServletRequest request, ModelAndView view){
		// 首页加载默认用户账户引导页面 菜单id=1
		String key = "1";
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("accountInfo");
		RequestContext requestContext = new RequestContext(request);
		for(String ksy :accountInfo.getTopMenu().keySet()){
			String na = accountInfo.getTopMenu().get(ksy).getMiMemo();
			if(na.intern()!=""){
				System.out.println("-> "+na +"  . value :"+ requestContext.getMessage(na));
				accountInfo.getTopMenu().get(ksy).setMiName(requestContext.getMessage(na));
			}
		}
		List<UserRoleMenu> leftMenu = accountInfo.getLeftMenu().get(key);
		request.setAttribute("leftMenu", leftMenu);
		return "merchantcenter/user/user";
	}
	
	/**
	 * 首页中间介绍页面
	 */
	@RequestMapping(value = "/center.htm", method = RequestMethod.GET)
	public String toUserMain(){
		return "merchantcenter/user/main";
	}
	
	/**
	 * 资源文件
	 */
	@RequestMapping(value = "/source.htm", method = RequestMethod.GET)
	public String toSource(){
		return "common/source";
	}
	
	
	/**
	 * 头文件
	 */
	@RequestMapping(value = "/head.htm", method = RequestMethod.GET)
	public String toHead(){
		return "common/head";
	}
	
	/**
	 * 底文件
	 */
	@RequestMapping(value = "/footer.htm", method = RequestMethod.GET)
	public String toFooter(){
		return "common/footer";
	}
	
	/**
	 * 左文件
	 */
	@RequestMapping(value = "/left.htm", method = RequestMethod.GET)
	public String toLeft(){
		return "common/left";
	}
	
	// 加载二级菜单
	@RequestMapping(value = "/loadLeftMenu.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<UserRoleMenu> loadLeftMenu(@ModelAttribute ConditionVO vo) throws Exception{
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("userId", vo.getUserId());
		conditionMap.put("miLevel", 2);
		conditionMap.put("fiId", vo.getMenuId());
		List<UserRoleMenu> leftMenu = iUserRoleMenu.queryUserRoleMenuAll(conditionMap);
		return leftMenu;
	}
	
	
	
	// #####################################################################
	
	
	/**
	 * 首页页面(第二套)
	 */
	@RequestMapping(value = "/main.htm", method = RequestMethod.GET)
	public String toMain1(HttpServletRequest request, ModelAndView view){
		// 首页加载默认用户账户引导页面 菜单id=1
		String key = "1";
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("accountInfo");
		RequestContext requestContext = new RequestContext(request);
		for(String ksy :accountInfo.getTopMenu().keySet()){
			String na = accountInfo.getTopMenu().get(ksy).getMiMemo();
			if(na.intern()!=""){
				accountInfo.getTopMenu().get(ksy).setMiName(requestContext.getMessage(na));
			}
		}
		List<UserRoleMenu> leftMenu = accountInfo.getLeftMenu().get(key);
		request.setAttribute("leftMenu", leftMenu);
		return "merchantcenter/user/user1";
	}
	
	/**
	 * 首页中间介绍页面(第二套)
	 */
	@RequestMapping(value = "/center1.htm", method = RequestMethod.GET)
	public String toUserMain1(){
		return "merchantcenter/user/main1";
	}
	
	/**
	 * 资源文件(第二套)
	 */
	@RequestMapping(value = "/source1.htm", method = RequestMethod.GET)
	public String toSource1(){
		return "common/source1";
	}
	
	
	/**
	 * 头文件(第二套)
	 */
	@RequestMapping(value = "/head1.htm", method = RequestMethod.GET)
	public String toHead1(){
		return "common/head1";
	}
	
	/**
	 * 底文件(第二套)
	 */
	@RequestMapping(value = "/footer1.htm", method = RequestMethod.GET)
	public String toFooter1(){
		return "common/footer1";
	}
	
	/**
	 * 左文件(第二套)
	 */
	@RequestMapping(value = "/left1.htm", method = RequestMethod.GET)
	public String toLeft1(){
		return "common/left1";
	}
}
