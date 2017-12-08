package com.sc.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sc.framework.utils.ContextUtil;
import com.sc.teminal.pojo.Devcmdlist;
import com.sc.teminal.service.DevcmdlistService;

public class ExecQuartz extends Thread implements ServletContextListener{
	private Thread sendThread;  
	public static Map<Date,Devcmdlist> execMap = new HashMap<Date,Devcmdlist>();
	// 
	public ExecQuartz() { 
	}
	public void contextDestroyed(ServletContextEvent e) {
		if (sendThread != null && sendThread.isInterrupted()) {  
			sendThread.interrupt();  
        } 
	}
	
	public void contextInitialized(ServletContextEvent e) {
		sendThread = new Thread(this);
		sendThread.start();
	}
	public void run() {
		try {

			DevcmdlistService devcmdlistService = (DevcmdlistService) ContextUtil.getContext().getBean("devcmdlistService");
			// 判断时间
			for(Date key :execMap.keySet()){
				if(key.getTime() <= System.currentTimeMillis()){
					// 执行
					System.out.println("####################执行操作####################");
					System.out.println("key : "+key);
					
					Devcmdlist devcmdlist = execMap.get(key);
					devcmdlist.setDevCmdId(Integer.parseInt(devcmdlistService.getMaxVersion("")));
					devcmdlistService.saveOrUpdateDevcmdlistInfo(devcmdlist);
					
					execMap.remove(key);
				}
			}
			
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
