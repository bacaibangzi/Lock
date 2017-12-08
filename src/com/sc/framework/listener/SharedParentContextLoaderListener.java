package com.sc.framework.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sc.framework.session.util.WebContextUtil;
import com.sc.framework.utils.ContextUtil;
import com.sc.framework.utils.PropertiesUtil;

/**
 * 继承ContextLoaderListener
 */
public class SharedParentContextLoaderListener extends ContextLoaderListener {
	private static Logger log = LoggerFactory
			.getLogger(SharedParentContextLoaderListener.class);

	/**
	 * ApplicationContext初始化
	 * 
	 * @param event
	 *            事件
	 */
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		// 初始化ContextUtil
		log.debug("初始化ContextUtil工具类");
		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		ContextUtil contextUtil = (ContextUtil) ctx.getBean("contextUtil");
		contextUtil.setContext(ctx);
		// 初始化WebContextUtil
		log.debug("初始化WebContextUtil工具类");
		WebContextUtil
				.setAppWebPath(event.getServletContext().getContextPath());
		// 初始化WebContextUtil中的app参数
		Properties props = PropertiesUtil.readProperties("config.properties");
		Iterator it = props.entrySet().iterator();
		Map<String, String> map = new HashMap<String, String>();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it
					.next();
			map.put(entry.getKey(), entry.getValue());
		}
		// 添加打包版本号读取VERSION文件
		String realPath = context.getRealPath("/");
		WebContextUtil.setAppRealPath(realPath);
		String filePath = realPath + "../VERSION";
		Properties versionPro = PropertiesUtil.readPropertiesFile(filePath);
		if (versionPro != null) {
			map.put("version", versionPro.getProperty("Version"));
		}
		WebContextUtil.setAppMap(map);

	}
}
