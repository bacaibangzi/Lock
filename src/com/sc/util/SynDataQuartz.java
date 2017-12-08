package com.sc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import com.sc.dbutil.DBConn;
import com.sc.framework.utils.ContextUtil;
import com.sc.system.service.UserInforMessageService;

/**
 * 同步第三方
 * 
 * @author Admin
 *
 */
public class SynDataQuartz extends Thread implements ServletContextListener{
	// 
	private Thread sendThread; 
	//
	private int refresh = 1;
	//
	public SynDataQuartz(){
		
	}

	/**
	 * contextDestroyed
	 */
	public void contextDestroyed(ServletContextEvent e) {
		if (sendThread != null && sendThread.isInterrupted()) {  
			sendThread.interrupt();  
        } 
	}

	/**
	 * contextInitialized
	 */
	public void contextInitialized(ServletContextEvent e) {
		try {
			sendThread = new Thread(this);
			Properties properties = new Properties();  
			InputStream inStream = DBConn.class.getClassLoader()  
			        .getResourceAsStream("jdbc.properties");  
			properties.load(inStream);
			
			refresh = Integer.parseInt(properties.getProperty("refresh"));  
			sendThread.start();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	UserInforMessageService userInforMessageService  = null;
	public void run() {
		try{
			while(true) {
				System.out.println("#####################同步数据######################### refresh:"+refresh );
				
				userInforMessageService = (UserInforMessageService) ContextUtil.getContext().getBean("userInforMessageService");
				
				userInforMessageService.syn(null);
				
				Thread.sleep(refresh * 60 * 1000);
			}
			
			
		}catch(Exception err){
			System.out.println("******************************* err:"+err.getMessage());
			err.printStackTrace();
		} 
	}
	
}
