package com.sc.framework.security.filter;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;

import com.sc.framework.utils.ContextUtil;
import com.sc.framework.utils.DateConvertUtils;
import com.sc.framework.utils.StringUtil;
import com.sc.framework.vo.ConditionVO;
import com.sc.system.pojo.OrgInfo;
import com.sc.system.pojo.UserInfo;
import com.sc.system.service.OrgInfoService;
import com.sc.system.service.UserInfoService;

import net.sf.json.JSONObject;

/**
 * 继承安全过滤器，控制所有相关的WEB资源 Copyright:
 * 
 */
public class DelegatingFilterProxy extends
		org.springframework.web.filter.DelegatingFilterProxy {
	private static final String EXCLUDE_SUFFIXS_NAME = "excludeSuffixs";
	private static final String DEFAULT_EXCLUDE_SUFFIXS[] = { ".js", ".css",
			".jpg", ".gif" };
	private static final String DEFAULT_INCLUDE_SUFFIXS[] = { ".action", ".do",
			".htm", "j_spring_security_check" ,"toLogin.htm"};
	private static String excludeSuffixs[] = null;

	/**
	 * 根据注入参数信息判断当前不需要过滤内容
	 * 
	 * @param request
	 * @return
	 */
	protected boolean shouldNotFilter(HttpServletRequest request) {
		String path = request.getServletPath();
		System.out.println(" path : " + path);
		String as[];
		int k = (as = DEFAULT_INCLUDE_SUFFIXS).length;
		for (int i = 0; i < k; i++) {
			String suffix = as[i];
			if (path.endsWith(suffix))
				return false;
		}
		k = (as = excludeSuffixs).length;
		for (int j = 0; j < k; j++) {
			String suffix = as[j];
			if (path.toLowerCase().endsWith(suffix))
				return true;
		}
		return true;
	}

	private static int flag = 0;
	private static int cc = 0;
	/**
	 * 拦截当前请求信息，控制非法连接攻击
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>>>>>拦截当前请求信息，控制非法连接攻击");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Enumeration paramMap = request.getParameterNames();
		String method = httpRequest.getMethod();
		if (!"GET".equals(method) && !"POST".equals(method)&& !"PUT".equals(method)) {
			logger.fatal("系统捕获的请求不是GET请求或者POST请求，请求者IP为："
					+ request.getRemoteHost() + "当前时间为：" + new Date());
			return;
		}
		boolean isCreack = false;
		while (paramMap.hasMoreElements()) {
			String param = (String) paramMap.nextElement();
			if (param.indexOf("\\u0023") != -1) {// 视为系统攻击
				logger.info(param);
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				logger.fatal("系统遭受攻击，攻击者IP地址为：" + request.getRemoteHost()
						+ "当前时间为：" + new Date());
				httpResponse.sendError(500);
				isCreack = true;
				break;
			}
		}
		
		
		UserInfo userInfo = null;
		OrgInfo  orgInfo  = null;
		//System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		// rest接口统一过滤用户，密码，门店编码
		if(((HttpServletRequest)request).getServletPath().indexOf("-rest")!=-1){
			try {
				UserInfoService userInfoService = (UserInfoService)ContextUtil.getContext().getBean("userInfoService");
				OrgInfoService orgInfoService = (OrgInfoService)ContextUtil.getContext().getBean("orgInfoService");
				//System.out.println("统一拦截上传下载用户密码："+ this.getIpAddress((HttpServletRequest)request));
				String orgCode = ((HttpServletRequest)request).getHeader("orgCode");
				String userName = ((HttpServletRequest)request).getHeader("userName");
				String password = ((HttpServletRequest)request).getHeader("password");

				ConditionVO vo = new ConditionVO();
				vo.setOrgCode(orgCode);
				boolean pass = false;
				if(userName==null||password==null||orgCode==null){
					pass = true;
				}
				else{
					Map<String, Object> conditionMap = new HashMap<String, Object>();
					conditionMap.put("uiLoginName", userName);
					conditionMap.put("uiPassword", StringUtil.encodeStr(password));
					List<UserInfo> userInfoList = userInfoService.queryUserInfosByCondition(conditionMap);
					if(userInfoList==null||userInfoList.size()==0){
						pass = true;
					}else if(orgInfoService.queryOrgInfosByCondition(vo).size() == 0){
						pass = true;
					}
					else{
						userInfo = userInfoList.get(0);
						if(orgCode.indexOf(userInfo.getUiOrgCode())==-1){
							pass = true;
						}
						
						userInfo = null;
					}
					
					userInfoList = null;
					conditionMap = null;
				}
				if (pass) {
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("message", "用户或密码错误");
					String jsonStr = JSONObject.fromObject(map).toString();
					((HttpServletResponse) response).setStatus(550);
					response.getWriter().write(jsonStr);
					
					
					orgCode = null;
					userName = null;
					password = null;
					return;
				}

				// 判断有效期
				orgInfo = orgInfoService.queryOrgInfosByCondition(vo).get(0);
				// 判断有效期
				String jgCode = null;
				Date   dqDate = null;
				
//				if("4".equals(orgInfo.getOiType())||"5".equals(orgInfo.getOiType())||"6".equals(orgInfo.getOiType())||"9".equals(orgInfo.getOiType())){
//				// 查找机构
//					jgCode = getZongdCode(orgInfoService,orgCode);
//				}else{
//					jgCode = orgCode;
//				} 
//				
				
				orgCode = null;
				userName = null;
				password = null;
				
			} catch (BeansException e) {
				//e.printStackTrace();
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
		}
		
		if (!isCreack) {
			if (shouldNotFilter(httpRequest)) {
				filterChain.doFilter(new RequestWrapper(httpRequest), response);
			} else {
				super.doFilter(new RequestWrapper(httpRequest), response,
						filterChain);
			}
		}
	}

	public String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 初始化操作入口
	 */
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
		String excludeSuffixStr = getFilterConfig().getInitParameter(
				EXCLUDE_SUFFIXS_NAME);
		if (StringUtils.isNotBlank(excludeSuffixStr)) {
			excludeSuffixs = excludeSuffixStr.split(",");
			for (int i = 0; i < excludeSuffixs.length; i++)
				if (excludeSuffixs[i].startsWith("$")) {
					excludeSuffixs[i] = excludeSuffixs[i].substring(1,
							excludeSuffixs[i].length());
				} else {
					excludeSuffixs[i] = (new StringBuilder(".")).append(
							excludeSuffixs[i]).toString();
				}
		} else {
			excludeSuffixs = DEFAULT_EXCLUDE_SUFFIXS;
		}
	}
	
	/**
	 * 获取最高门店信息
	 * 
	 * @param orgCode
	 * @return
	 * @throws Exception
	 */
	public String getZongdCode(OrgInfoService orgInfoService,String orgCode){
		try {
			OrgInfo orgInfo = orgInfoService.findMengdByOrgCode(orgCode);
			if (orgInfo != null) {
				return orgInfo.getOiCode();
			} else {
				if(orgCode.length()<4){
					return "0";
				}
				
				orgCode = orgCode.substring(0, orgCode.length()-4);
				return getZongdCode(orgInfoService,orgCode);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return "0";
		}
	}
}
