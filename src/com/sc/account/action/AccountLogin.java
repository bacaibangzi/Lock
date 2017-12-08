package com.sc.account.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linkage.netmsg.NetMsgclient;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.utils.NetMsgclientSingleton;
import com.sc.framework.utils.StringUtil;
import com.sc.system.interfaces.IMerchantUser;
import com.sc.system.pojo.UserInfo;

/**
 * 用户登录，注册前台action
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/account")
public class AccountLogin extends BaseAction{
	
	@Autowired
	private IMerchantUser iMerchantUser;  

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.registerCustomEditor(Date.class, new DateConvertEditor());
		binder
				.registerCustomEditor(String.class, new StringTrimmerEditor(
						true));
	}
	@RequestMapping(value="/checkMobi", method = RequestMethod.GET)
	@ResponseBody
	public String checkMobi(@RequestParam String uiMobile){  
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		List<UserInfo> userInfo = null;
		try {
			conditionMap.put("uiMobile", uiMobile);
			userInfo = iMerchantUser.querySystemUsersForPage(conditionMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(userInfo.size()>0)
			return "1";
		else
			return "no";
	}
	private static Map<String,String> map = new HashMap<String,String>();//静态hashmap存储手机验证码
	/**
	 * 获取手机短信验证码
	 * @param telephone
	 */
	@RequestMapping(value="/getCode", method = RequestMethod.POST)
	@ResponseBody
	public void getCode(@RequestParam String telephone){
		System.out.println(" send password MSN phone : "+telephone);
		String code = StringUtil.randomString(4);//产生四位随机数验证码 
		map.put(telephone, code);
		try{
			NetMsgclientSingleton msgclientSingleton  =NetMsgclientSingleton.getInstance();
			NetMsgclient msgclient = msgclientSingleton.getClient();
			String msgReturn = msgclient.sendMsg(msgclient, 1, telephone, NetMsgclientSingleton.mode.replaceAll("X", code)
				, 1);

			System.out.println("获取手机短信验证码发送返回值："+msgReturn);
			
			msgclient.closeConn();
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	/**
	 * 用户注册
	 * @param telephone
	 * @param code
	 * @param loginName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	@ResponseBody
	public String regist(@ModelAttribute
	UserInfo userInfo, @RequestParam String code){
		    String uiMobile = userInfo.getUiMobile();
		    Exception e = null;
		    //if(map.get(uiMobile)!=null&&map.get(uiMobile).equals(code)){
			try {
				iMerchantUser.saveMerchantUser(userInfo);
				return "success";
			} catch (Exception exception) {
				e=exception;
				System.out.println("e=="+e);
			}
			if( e instanceof DuplicateKeyException){
				System.out.println("e=="+e);
				return "nameRepeat"; 
			}else{
				e.printStackTrace();
				return "error";
			}
		   // }else if(map.get(uiMobile)==null){
		   // 	return "null";
		   // }else{
		   // 	return "false";
		   // }
		}
	/**
	 * 找回密码
	 * @param userInfo
	 * @param code
	 * @return
	 */
	@RequestMapping(value="/sendPass", method = RequestMethod.POST)
	@ResponseBody
	public String sendPass(@ModelAttribute
	UserInfo userInfo, @RequestParam String code){
		  	String uiMobile = userInfo.getUiMobile();
		    Exception e = null;
		    if(map.get(uiMobile)!=null&&map.get(uiMobile).equals(code)){
			try {
				iMerchantUser.updateMerchantUser(userInfo);
				return "success";
			} catch (Exception exception) {
				e=exception;
				System.out.println("e=="+e);
			}
			if( e instanceof DuplicateKeyException){
				System.out.println("e=="+e);
				return "nameRepeat"; 
			}else{
				e.printStackTrace();
				return "error";
			}
		    }else if(map.get(uiMobile)==null){
		    	return "null";
		    }else{
		    	return "false";
		    }
	}
}
