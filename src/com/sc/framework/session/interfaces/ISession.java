package com.sc.framework.session.interfaces;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sc.framework.session.util.ErrorInfo;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.session.util.WebContextUtil;
import com.sc.framework.utils.StringUtil;

@Service
public class ISession {

	private static Logger log = LoggerFactory.getLogger(ISession.class);

	/**
	 * 根据KEY值获取服务器端Application作用域中的用户登录错误信息
	 * 
	 * @param key
	 * @return
	 */
	public ErrorInfo getErrorInfoByKey(String key) {
		Map<String, ErrorInfo> map = this.getAppLoginErrorMap();
		ErrorInfo errorInfo = map.get(key);
		if (errorInfo == null) {
			errorInfo = new ErrorInfo();
			map.put(key, errorInfo);
		}
		return errorInfo;
	}

	/**
	 * 根据KEY值获取服务器端Application作用域中的用户登录错误信息进行累加操作
	 * 
	 * @param key
	 * @return
	 */
	public int loginErrorRecourd(String key) {
		// 初始密码错误次数为0
		int errorCount = 0;
		ErrorInfo errorInfo = this.getErrorInfoByKey(key);
		// 如果存在错误记录则覆盖初始密码错误次数
		Date lastErrorTime = errorInfo.getLastErrorTime();
		Date nowTime = new Date();
		int time = this.getMinute(lastErrorTime, nowTime);
		Long forBiddenTime = new Long(this.getSysFobiddenMinues());
		// 如果时间超出系统参数时间则重新设置
		if (time > forBiddenTime) {
			errorInfo.setCount(0);
		}
		errorCount = errorInfo.getCount();
		// 系统中允许连续用户名、密码错误的次数
		Long sysAllowErrorTimes = new Long(this.getSysAllowErrorTimes());
		// 如果错误次数小于系统预设错误次数则累加
		if (errorCount < sysAllowErrorTimes) {
			// 当前错误次数加1
			errorCount++;
			errorInfo.setCount(errorCount);
			errorInfo.setLastErrorTime(nowTime);
		}
		return errorInfo.getCount();
	}

	/**
	 * 根据KEY获取服务器端Application作用域中的用户登录错误次数信息
	 * 
	 * @param key
	 * @return
	 */
	public int getErrorTimes(String key) {
		ErrorInfo errorInfo = this.getErrorInfoByKey(key);
		Date errorTime = errorInfo.getLastErrorTime();
		Date nowTime = new Date();
		int minutes = this.getMinute(errorTime, nowTime);
		int forBiddenTime = this.getSysFobiddenMinues();
		// 如果时间超出系统参数时间则重新设置
		if (minutes > forBiddenTime) {
			// 重新设置开始时间
			errorInfo.setLastErrorTime(nowTime);
			// 重新设置累计次数
			errorInfo.setCount(0);
		}
		return errorInfo.getCount();
	}

	public void clearErrorInfoByKey(String key) {
		// TODO Auto-generated method stub
		Map<String, ErrorInfo> map = this.getAppLoginErrorMap();
		map.remove(key);
	}

	/**
	 * 连续登失败后系统中禁制登录时间
	 * 
	 * @return
	 */
	public Integer getSysFobiddenMinues() {
		// TODO Auto-generated method stub
		String waitMinutes = WebContextUtil.getAppMap().get(
				"framework.waitMinutes");
		if (StringUtil.isNotEmpty(waitMinutes)) {
			try {
				return Integer.parseInt(waitMinutes);
			} catch (Exception e) {
				log.error("转化禁制时间失败", e);
			}
		}
		return null;
	}

	/**
	 * 获取系统中允许连续用户名与密码验证失败的次数
	 * 
	 * @return
	 */
	public Integer getSysAllowErrorTimes() {
		String allowErrorTime = WebContextUtil.getAppMap().get(
				"framework.maxErrorTimes");
		if (StringUtil.isNotEmpty(allowErrorTime)) {
			try {
				return Integer.parseInt(allowErrorTime);
			} catch (Exception e) {
				log.error("转化次数失败", e);
			}
		}
		return null;
	}

	/**
	 * 如果获取系统允许失败次数或失败后系统中禁制登录时间中有一个返回为null则放行
	 * 
	 * @return
	 */
	public boolean needCheckErrorTimes() {

		boolean isNeed = false;
		if (this.getSysFobiddenMinues() == null
				|| this.getSysAllowErrorTimes() == null) {
			isNeed = false;
		} else {
			isNeed = true;
		}
		return isNeed;

	}

	/**
	 * 获取所有登录错误的MAP集合
	 * 
	 * @return
	 */
	private Map<String, ErrorInfo> getAppLoginErrorMap() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		ServletContext appContext = request.getSession().getServletContext();
		Map<String, ErrorInfo> map = (Map<String, ErrorInfo>) appContext
				.getAttribute(SessionConstants.app_login_error_key);
		if (map == null) {
			map = new HashMap<String, ErrorInfo>();
			appContext.setAttribute(SessionConstants.app_login_error_key, map);
		}
		return map;
	}

	private int getMinute(Date errorTime, Date nowTime) {
		long minute = (nowTime.getTime() - errorTime.getTime()) / 60000;
		return (int) minute;
	}
}
