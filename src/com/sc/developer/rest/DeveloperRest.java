package com.sc.developer.rest;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.developer.dao.AppCostMapper;
import com.sc.developer.dao.AppRunMapper;
import com.sc.developer.dao.AppsMapper;
import com.sc.developer.exception.DevException;
import com.sc.developer.pojo.AppCost;
import com.sc.developer.pojo.AppRun;
import com.sc.developer.pojo.Apps;
import com.sc.framework.base.action.BaseAction;
import com.sc.framework.utils.ContextUtil;
import com.sc.util.Des3;

import net.sf.json.JSONObject;

/**
 * 开发
 * 
 * @author cuibin
 *
 */
@Controller
@RequestMapping("/developer")
public class DeveloperRest extends BaseAction{
	
	@Autowired
	AppRunMapper appRunMapper;
	@Autowired
	AppCostMapper appCostMapper;
	@Autowired
	AppsMapper appsMapper;

	/**
	 * appRun
	 * 
	 * @param content
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/app-run-mobile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> appRun(@RequestBody String content,
			HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppRun appRun = null;
		try {
			System.out.println("appId :"+request.getHeader("appId"));
			// 验证APPID真实性
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("appid", request.getHeader("appId"));
			List<Apps> appsList = null;
			try{ 
				appsList = appsMapper.query(conditionMap);
			} catch (Exception e) {
			}
			if(appsList==null || appsList.size()==0){
				throw new DevException(-2000,"APPID 错误");
			}
			
			if(appsList.get(0).getState()!=2){
				throw new DevException(-4000,"APP未经审核");
			}
			
			try {
				// 解密
				Des3.secretKey = appsList.get(0).getAppkey();
				content = Des3.decode(content);
				content = URLDecoder.decode(content, "UTF-8");
				System.out.println("content :"+content);
				JSONObject object = JSONObject.fromObject(content);
				appRun = (AppRun) JSONObject.toBean(object, AppRun.class);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DevException(-1000,"APPKEY错误");
			}
			if(appRun.getAppid()==null || "".equals(appRun.getAppid())){
				throw new DevException(-2000,"APPID 错误");
			}
			
			if(appRun.getAppUserId()==null || "".equals(appRun.getAppUserId())){
				throw new DevException(-3000,"参数错误");
			}
			
			if(appRun.getAppUserName()==null || "".equals(appRun.getAppUserName())){
				throw new DevException(-3000,"参数错误");
			}

			
			appRun.setUserid(appsList.get(0).getUserid());
			try {
				appRunMapper.insert(appRun);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DevException(-3000,"参数错误");
			}
			map.put("code", 200);
			map.put("message", "成功");
		}  catch (DevException e) {
			map.put("code", e.getCode());
			map.put("message", e.getMessage());
		}
		//response.setStatus(200);
		//renderJson(map,response);
		return map;
	}
	
	/**
	 * appPay
	 * 
	 * @param content
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/app-pay-mobile", method = RequestMethod.POST)
	public void appPay(@RequestBody String content,
			HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppCost appCost = null;
		try {
			// 验证APPID真实性
			Map<String, Object> conditionMap = new HashMap<String, Object>();
			conditionMap.put("appid", request.getHeader("appId"));
			List<Apps> appsList = null;
			try{ 
				appsList = appsMapper.query(conditionMap);
			} catch (Exception e) {
			}
			if(appsList==null || appsList.size()==0){
				throw new DevException(-2000,"APPID 错误");
			}
			if(appsList.get(0).getState()!=2){
				throw new DevException(-4000,"APP未经审核");
			}
			try {
				// 解密
				Des3.secretKey = appsList.get(0).getAppkey();
				content = Des3.decode(content);
				content = URLDecoder.decode(content, "UTF-8");
				System.out.println(content);
				JSONObject object = JSONObject.fromObject(content);
				appCost = (AppCost) JSONObject.toBean(object, AppCost.class);
			} catch (Exception e) {
				throw new DevException(-1000,"APPKEY错误");
			}
			
			if(appCost.getAppid()==null || "".equals(appCost.getAppid())){
				throw new DevException(-2000,"APPID 错误");
			}
			
			if(appCost.getAppUserId()==null || "".equals(appCost.getAppUserId())){
				throw new DevException(-3000,"参数错误");
			}
			
			if(appCost.getAppUserName()==null || "".equals(appCost.getAppUserName())){
				throw new DevException(-3000,"参数错误");
			}
			appCost.setUserid(appsList.get(0).getUserid());			
			
			try {
				appCostMapper.insert(appCost);
			} catch (Exception e) {
				e.printStackTrace();
				throw new DevException(-3000,"参数错误");
			}
			map.put("code", 200);
			map.put("message", "成功");
		}  catch (DevException e) {
			map.put("code", e.getCode());
			map.put("message", e.getMessage());
		}finally{
			
		}

		response.setStatus(200);
		renderJson(map,response);
	}
	
	@RequestMapping(value = "/day-mobile", method = RequestMethod.GET)
	public void day(@RequestBody String content, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Calendar cal = Calendar.getInstance();
		String start = "2015-03-03";
		String end = "2025-03-02";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dBegin = sdf.parse(start);
		Date dEnd = sdf.parse(end);
		List<Date> lDate = findDates(dBegin, dEnd);

		SqlSessionFactory  sqlSessionFactory  = (SqlSessionFactory)ContextUtil.getContext().getBean("sqlSessionFactory");
		SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionFactory);
		Connection conn = sqlSession.getConnection();
		Statement statement = conn.createStatement();
		for (Date date : lDate) {
			System.out.println(sdf.format(date));
			statement.executeUpdate("insert dev_days values ('"+sdf.format(date)+"')");
		}
		statement.close();
		conn.close();
	}
	
	public static List<Date> findDates(Date dBegin, Date dEnd) {
		List lDate = new ArrayList();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(dEnd);
		// 测试此日期是否在指定日期之后
		while (dEnd.after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}

}
