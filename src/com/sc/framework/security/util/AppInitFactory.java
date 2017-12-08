package com.sc.framework.security.util;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.RequestKey;

/**
 * 系统安全数据初始化
 * 
 * 类功能详细描述
 */
public class AppInitFactory implements FactoryBean {
	private LinkedHashMap<RequestKey, Collection<ConfigAttribute>> baseSafeMap;
	private static Logger log = LoggerFactory.getLogger(AppInitFactory.class);

	@SuppressWarnings("unchecked")
	public void doAppInit() {
		log.debug("安全数据初始化");
		log.debug("安全数据初始化完毕");

		baseSafeMap = new LinkedHashMap<RequestKey, Collection<ConfigAttribute>>();
	}

	public Object getObject() throws Exception {
		if (this.baseSafeMap == null) {
			doAppInit();
		}
		return baseSafeMap;
	}

	public Class getObjectType() {
		return LinkedHashMap.class;
	}

	public boolean isSingleton() {
		return true;
	}
}
