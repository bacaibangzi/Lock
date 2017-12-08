package com.sc.framework.session.util;

import java.util.Map;

public class WebContextUtil {
	private static String appWebPath;
	private static String appRealPath;
	private static Map<String, String> appMap;

	public static String getAppWebPath() {
		return appWebPath;
	}

	public static void setAppWebPath(String appWebPath) {
		WebContextUtil.appWebPath = appWebPath;
	}

	public static Map<String, String> getAppMap() {
		return appMap;
	}

	public static void setAppMap(Map<String, String> appMap) {
		WebContextUtil.appMap = appMap;
	}

	public static String getPropertiesValueByKey(String key) {
		if (appMap == null) {
			return null;
		} else {
			return appMap.get(key);
		}
	}

	public static String getAppRealPath() {
		return appRealPath;
	}

	public static void setAppRealPath(String appRealPath) {
		WebContextUtil.appRealPath = appRealPath;
	}
}
