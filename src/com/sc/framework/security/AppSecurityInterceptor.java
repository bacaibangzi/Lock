package com.sc.framework.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;


/**
 * 自定义拦截器
 * @author Luxh
 */
public class AppSecurityInterceptor extends AbstractSecurityInterceptor implements Filter{
	
	private static Logger log = LoggerFactory.getLogger(AppSecurityInterceptor.class);
	
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		log.info("开始拦截......");
		FilterInvocation fi = new FilterInvocation(request, response, filterChain);
		InterceptorStatusToken token = super.beforeInvocation(fi);
		try {  
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            super.afterInvocation(token,null);  
        }  
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return securityMetadataSource;
	}
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void destroy() {
		
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
	
	
	

}
