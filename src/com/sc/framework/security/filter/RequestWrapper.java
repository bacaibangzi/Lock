package com.sc.framework.security.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * FileName: RoleAction.java Description:
 * 包装Request对象，通过结合过滤器，将包装后的HttpServletRequest对象传递到请求中
 * 
 */
public class RequestWrapper extends HttpServletRequestWrapper {
	/**
	 * 显示调用构造方法
	 * 
	 * @param request
	 */
	public RequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getHeader(String s) {
		String s1 = super.getHeader(s);
		if (s1 == null) {
			return null;
		} else {
			return cleanXSS(s1);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map getParameterMap() {
		Map map = super.getParameterMap();
		Map newMap = new HashMap();
		if (map != null && !map.isEmpty()) {
			Set ketSet = map.keySet();
			for (Iterator it = ketSet.iterator(); it.hasNext();) {
				String key = (String) it.next();
				Object value = map.get(key);
				if (value != null) {
					if (value instanceof String[]) {
						String[] strArray = (String[]) value;
						String[] newStrArray = new String[strArray.length];
						for (int j = 0; j < strArray.length; j++) {
							newStrArray[j] = cleanXSS(strArray[j]);
						}
						value = newStrArray;
						newMap.put(key, value);
					}
				}
			}
		}
		if (newMap.isEmpty()) {
			return map;
		}
		return newMap;
	}

	@Override
	public String getParameter(String s) {
		String s1 = super.getParameter(s);
		if (s1 == null) {
			return null;
		} else {
			return cleanXSS(s1);
		}
	}

	@Override
	public String[] getParameterValues(String s) {
		String[] str = super.getParameterValues(s);
		if (str == null) {
			return null;
		}
		int i = str.length;
		String as1[] = new String[i];
		for (int j = 0; j < i; j++) {
			as1[j] = cleanXSS(str[j]);
		}
		return as1;
	}

	/**
	 * 过滤容易引起XSS工具的敏感参数
	 * 
	 * @date:2011-10-17 下午01:43:26
	 * @param s
	 *            需要过滤的参数
	 * @return 过滤后的参数
	 */
	private String cleanXSS(String s) {
		if (s == null) {
			return null;
		}
		// s = s.toLowerCase();
		/*
		 * if(s.indexOf("<") !=-1){ s = s.replaceAll("<", "&lt;"); }
		 * if(s.indexOf(">")!=-1) { s = s.replaceAll(">", "&gt;"); }
		 */
		/*
		 * if(s.indexOf("(")!=-1) { s = s.replaceAll("\\(", "&#40;"); }
		 */
		if (s.indexOf("=xss:e/**/xpression") != -1) {
			s = s.replaceAll("=xss:e/**/xpression", "");
		}
		if (s.indexOf("eval") != -1) {
			s = s.replaceAll("eval\\((.*)\\)", "");
		}
		if (s.indexOf("javascript") != -1) {
			s = s.replaceAll("[\\\"\\'][\\s]*javascript:(.*)[\\\"\\']", "\"\"");
		}
		/*
		 * if(s.indexOf("script")!=-1) { s = s.replaceAll("script", ""); }
		 */
		/*
		 * if(s.indexOf("iframe")!=-1) { s = s.replaceAll("iframe", ""); }
		 */
		if (s.indexOf("background:expression") != -1) {
			s = s.replaceAll("expression", "");
		}
		// s = s.replaceAll("'", "&#39;");
		return s;
	}
}
