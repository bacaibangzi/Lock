package com.sc.framework.security.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractProcessingFilter;
import org.springframework.security.web.context.HttpSessionContextIntegrationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sc.framework.security.util.AccountConstants;
import com.sc.framework.security.util.AccountInfo;
import com.sc.framework.session.interfaces.ISession;
import com.sc.framework.utils.ContextUtil;
import com.sc.framework.utils.MapKeyComparator;
import com.sc.framework.utils.RedirectResponseWrapper;
import com.sc.system.pojo.UserRoleMenu;

import net.sf.json.JSONObject;

public class LoginAjaxFilter extends OncePerRequestFilter {
	private static final Logger log = LoggerFactory
			.getLogger(LoginAjaxFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 用户登录信息
		Map<String, String> map = new HashMap<String, String>();
		if (!this.isAjaxRequest(request)) {
			log.debug("非AJAX请求，不进行拦截");
			filterChain.doFilter(request, response);
		} else {
			log.debug("AJAX请求开始,过滤路径为" + request.getRequestURL());
			RedirectResponseWrapper redirectResponseWrapper = new RedirectResponseWrapper(
					response);
			filterChain.doFilter(request, redirectResponseWrapper);
			String redirectURL = redirectResponseWrapper.getRedirect();
			HttpSession httpSession = request.getSession();
			org.springframework.security.core.AuthenticationException ae = (org.springframework.security.core.AuthenticationException) httpSession
					.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY);
			String key = (String) request.getParameter("j_username");

			
			ISession iSession = (ISession) ContextUtil.getContext().getBean("ISession");
			// 根据错误跳转判断AJAX求情状态
			if (redirectURL.indexOf("login_error=1") != -1) {
				map.put("success", "false");
				String ecode = ae.getMessage();

				// 用户验密码判断，后期可以扩展验证码功能。
				if ("Bad credentials".equals(ecode)) {
					map.put("ecode", AccountConstants.ACCOUNT_LOGIN_AUTH_ERROR);
				}
				else{
					map.put("ecode", ecode);
				}
				
				System.out.println(">>>>>>iSession.needCheckErrorTimes() : "+iSession.needCheckErrorTimes());
				
				// 记录因用户名与密码错误导致的登录失败
				if (AccountConstants.ACCOUNT_LOGIN_AUTH_ERROR.equals(map.get("ecode"))&& iSession.needCheckErrorTimes()) {
					int failedTimes = iSession.loginErrorRecourd(key);
					map.put("shouldLogin", String.valueOf(iSession
							.getSysAllowErrorTimes()
							- failedTimes));
				}

			} else {

				// 获取用户登录权限
				SecurityContext ctx = (SecurityContext) httpSession
						.getAttribute(HttpSessionContextIntegrationFilter.SPRING_SECURITY_CONTEXT_KEY);
				
				if (ctx != null) {
					Authentication auth = ctx.getAuthentication();
					UserDetails user = (UserDetails) auth.getPrincipal();
					if (user != null) {
						map.put("redirectURL", redirectURL);
						map.put("success", "true");
						iSession.clearErrorInfoByKey(key);
						
						// 获取用户的权限
						AccountInfo accountInfo = (AccountInfo)user;
						/*
						// 克隆一个全的供新界面使用
						Map<String,UserRoleMenu> topMenu1 = new LinkedHashMap<String,UserRoleMenu>();
						for(String key1 : accountInfo.getTopMenu().keySet()){
							topMenu1.put(key1, accountInfo.getTopMenu().get(key1));
						}
						
						request.getSession().setAttribute("topMenu1",MapKeyComparator.sortMapByKeyUserRoleMenu(topMenu1));
						*/
						
						request.getSession().setAttribute("topMenu",accountInfo.getTopMenu());
						// 默认过滤到索引为1的导航菜单
						if(accountInfo.getTopMenu().containsKey(String.valueOf(1))){
							//accountInfo.getTopMenu().remove(String.valueOf(1));
						}else{
							// 防止事件溢出
							//request.getSession().setAttribute("index",new UserRoleMenu());
						}
						
						// 系统测试时默认组织机构为0000
						//accountInfo.setOrgCode("0000");
						accountInfo.setOrgCode(accountInfo.getOrgCode());
						request.getSession().setAttribute("accountInfo", accountInfo);

					} else {
						// 登录失败
						map.put("success", "false");
						map.put("ecode", "3");
					}
				} else {
					map.put("success", "false");
					map.put("ecode", "4");
				}
			}
		}
		if (!"true".equals(map.get("success"))) {
			if (map.get("shouldLogin") != null) {
				map.put("errorInfo", getErrorInfo(map.get("ecode"), map
						.get("shouldLogin")));
			} else {
				map.put("errorInfo", getErrorInfo(map.get("ecode")));
			}
		}
		System.out.println(" 验证  : ");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String jsonStr = JSONObject.fromObject(map).toString();
		response.getWriter().write(jsonStr);
	}

	/**
	 * 错误信息转化
	 * 
	 * @param code
	 * @return
	 */
	private String getErrorInfo(String code, String... shouldLogin) {

		/*
		String errorInfo = "Error occurred when login,please contact the administrator！";
		if ("00010002".equals(code)) {
			errorInfo = "Login failed. This account has no WEB login permission.Please contact the administrator！";
		}
		if("00010006".equals(code)){
			errorInfo = "Login failed.This account is unaudited.Please contact the administrator！";
		}
		if("00010007".equals(code)){
			errorInfo = "Login failed.This account has been stopped to use.Please contact the administrator！";
		}
		if ("00010003".equals(code)) {
			errorInfo = "登录失败，该账户不具有PHONE登录权限，请联系管理员！";
		}
		if ("00010001".equals(code)) {
			errorInfo = "登录失败，该账户已被停用，请联系管理员！";
		}
		if ("10010111".equals(code)) {
			errorInfo = "不是可登陆的手机号码！";
		}
		if ("10010112".equals(code)) {
			errorInfo = "不是可登陆的IMSI！";
		}
		if ("10010113".equals(code)) {
			errorInfo = "不是可登陆的IMEI！";
		}
		if ("10010114".equals(code)) {
			errorInfo = "不是可登陆的ESN！";
		}
		if ("10010121".equals(code)) {
			errorInfo = "IP登录规则不合法！";
		}
		if ("10010131".equals(code)) {
			errorInfo = "不在登录的时间范围内！";
		}
		if ("10010132".equals(code)) {
			errorInfo = "不在登录的日期范围内！";
		}
		if ("10010133".equals(code)) {
			errorInfo = "不在登录的IP段范围内！";
		}
		if ("00010005".equals(code)) {
			if (shouldLogin.length != 0) {
				if ("0".equals(shouldLogin[0])) {
					errorInfo = "Too many incorrect account and password are typed, your account is freezing now！";
				} else {
					errorInfo = "Error occurred in account and password.You have " + shouldLogin[0]
							+ " times to try again.Please re-enter！";
				}
			} else {
				errorInfo = "Error occurred in account and password.Please re-enter！";
			}
		}
		if ("00010008".equals(code)) {
			errorInfo = "Too many incorrect account and password are typed, and you cannot login systme right now！";
		}
		if ("00010009".equals(code)) {
			errorInfo = "手机端所使用SIM卡非指定运营商！";
		}
		if ("00010010".equals(code)) {
			errorInfo = "数据库连接异常，请您检查数据库连接！";
		}

		if ("00010011".equals(code)) {
			errorInfo = "This account not exist. Login failed！";
		}

		if ("00010012".equals(code)) {
			errorInfo = "当前账户对应用户所在机构异常，无法登录！";
		}
		 */
		 
		String errorInfo = "登录时发生未知异常，请您联系管理员！";
		if ("00010002".equals(code)) {
			errorInfo = "登录失败，该账户不具有WEB登录权限，请联系管理员！";
		}
		if("00010006".equals(code)){
			errorInfo = "登录失败，该账户未审核，请联系管理员！";
		}
		if("00010007".equals(code)){
			errorInfo = "登录失败，该账户已停用，请联系管理员！";
		}
		if ("00010003".equals(code)) {
			errorInfo = "登录失败，该账户不具有PHONE登录权限，请联系管理员！";
		}
		if ("00010001".equals(code)) {
			errorInfo = "登录失败，该账户已被停用，请联系管理员！";
		}
		if ("10010111".equals(code)) {
			errorInfo = "不是可登陆的手机号码！";
		}
		if ("10010112".equals(code)) {
			errorInfo = "不是可登陆的IMSI！";
		}
		if ("10010113".equals(code)) {
			errorInfo = "不是可登陆的IMEI！";
		}
		if ("10010114".equals(code)) {
			errorInfo = "不是可登陆的ESN！";
		}
		if ("10010121".equals(code)) {
			errorInfo = "IP登录规则不合法！";
		}
		if ("10010131".equals(code)) {
			errorInfo = "不在登录的时间范围内！";
		}
		if ("10010132".equals(code)) {
			errorInfo = "不在登录的日期范围内！";
		}
		if ("10010133".equals(code)) {
			errorInfo = "不在登录的IP段范围内！";
		}
		if ("00010005".equals(code)) {
			if (shouldLogin.length != 0) {
				if ("0".equals(shouldLogin[0])) {
					errorInfo = "账户名或密码错误次数过多，您的账户将被暂时锁定！";
				} else {
					errorInfo = "账户或密码有误，您还有" + shouldLogin[0]
							+ "次账户或密码验证失败机会,请重新输入！";
				}
			} else {
				errorInfo = "账号或密码有误，请重新输入！";
			}
		}
		if ("00010008".equals(code)) {
			errorInfo = "账号或密码错误次数过多，您暂时不能登录系统！";
		}
		if ("00010009".equals(code)) {
			errorInfo = "手机端所使用SIM卡非指定运营商！";
		}
		if ("00010010".equals(code)) {
			errorInfo = "数据库连接异常，请您检查数据库连接！";
		}

		if ("00010011".equals(code)) {
			errorInfo = "当前账户不存在用户信息，无法登录！";
		}

		if ("00010012".equals(code)) {
			errorInfo = "当前账户对应用户所在机构异常，无法登录！";
		}

		if ("00010014".equals(code)) {
			errorInfo = "当前用户所在机构已过有效期，无法登录！";
		}
		 
		 
		 
		
		

		/*
		String errorInfo = ContextUtil.getContext().getMessage("login.errinfo", new Object[]{},Locale.US);//"登录时发生未知异常，请您联系管理员！";
		if ("00010002".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err00010002", new Object[]{},Locale.US);//"登录失败，该账户不具有WEB登录权限，请联系管理员！";
		}
		if("00010006".equals(code)){
			errorInfo = ContextUtil.getContext().getMessage("login.err00010006", new Object[]{},Locale.US);//"登录失败，该账户未审核，请联系管理员！";
		}
		if("00010007".equals(code)){
			errorInfo = ContextUtil.getContext().getMessage("login.err00010007", new Object[]{},Locale.US);//"登录失败，该账户已停用，请联系管理员！";
		}
		if ("00010003".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"登录失败，该账户不具有PHONE登录权限，请联系管理员！";
		}
		if ("00010001".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"登录失败，该账户已被停用，请联系管理员！";
		}
		if ("10010111".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不是可登陆的手机号码！";
		}
		if ("10010112".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不是可登陆的IMSI！";
		}
		if ("10010113".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不是可登陆的IMEI！";
		}
		if ("10010114".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不是可登陆的ESN！";
		}
		if ("10010121".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"IP登录规则不合法！";
		}
		if ("10010131".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不在登录的时间范围内！";
		}
		if ("10010132".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不在登录的日期范围内！";
		}
		if ("10010133".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"不在登录的IP段范围内！";
		}
		if ("00010005".equals(code)) {
			if (shouldLogin.length != 0) {
				if ("0".equals(shouldLogin[0])) {
					errorInfo = ContextUtil.getContext().getMessage("login.err00010005a", new Object[]{},Locale.US);//"账户名或密码错误次数过多，您的账户将被暂时锁定！";
				} else {
					//errorInfo = "账户或密码有误，您还有" + shouldLogin[0] + "次账户或密码验证失败机会,请重新输入！";
					errorInfo = ContextUtil.getContext().getMessage("login.err00010005b", new Object[]{shouldLogin[0]},Locale.US);
				}
			} else {
				errorInfo = ContextUtil.getContext().getMessage("login.err00010005c", new Object[]{},Locale.US);//"账号或密码有误，请重新输入！";
			}
		}
		if ("00010008".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err00010008", new Object[]{},Locale.US);//"账号或密码错误次数过多，您暂时不能登录系统！";
		}
		if ("00010009".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"手机端所使用SIM卡非指定运营商！";
		}
		if ("00010010".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"数据库连接异常，请您检查数据库连接！";
		}

		if ("00010011".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err00010011", new Object[]{},Locale.US);//"当前账户不存在用户信息，无法登录！";
		}

		if ("00010012".equals(code)) {
			errorInfo = ContextUtil.getContext().getMessage("login.err", new Object[]{},Locale.US);//"当前账户对应用户所在机构异常，无法登录！";
		}
		*/
		return errorInfo;
	}

	/**
	 * 判断当前请求是否为AJAX请求
	 * 
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		String ajaxTag = request.getParameter("ajaxTag");
		if (ajaxTag == null || "".equals(ajaxTag)) {
			return false;
		} else {
			return true;
		}
	}
}
