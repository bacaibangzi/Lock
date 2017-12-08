package com.sc.framework.security.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.ModelAndView;

public class SessionFilter extends OncePerRequestFilter {

	private List<String> excludedUrls;

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/*
	 * get set method
	 */
	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	private String render(String text, String contentType,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType(contentType);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(text);
			pw.flush();
		} catch (IOException e) {
		} finally {
			if (null != pw) {
				pw.close();
			}
		}
		return null;
	}

	private String renderText(String text, HttpServletResponse response) {
		return this.render(text, "text/plain;charset=UTF-8", response);
	}

	/* */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		SecurityContext context = SecurityContextHolder.getContext();
		 
		if (context.getAuthentication() == null
				|| "anonymousUser"
						.equals(context.getAuthentication().getName())) {
			String requestedWith = request.getHeader("x-requested-with");
			if (shouldNotFilter(request)) {
				filterChain.doFilter(request, response);
			} else {
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with")
								.equalsIgnoreCase("XMLHttpRequest")) {
					response.setStatus(302);
					response.setHeader("sessionstatus", "timeout");
					this.renderText(request.getContextPath() + "/toLogin.htm",
							response);
				} else {
					try {
						response.sendRedirect(request.getContextPath()
								+ "/toLogin.htm?top=true");
						
					} catch (Exception err) {
						err.printStackTrace();
					}
				}
			}

		} else {
			// response.sendRedirect(request.getContextPath() + "/main");
			super.doFilter(request, response, filterChain);
		}
	}

	protected boolean shouldNotFilter(HttpServletRequest request)
			throws ServletException {
		String requestUri = request.getRequestURI();
		for (String url : excludedUrls) {
			if (requestUri.endsWith(url)) {
				return true;
			}
		}
		return false;
	}

}