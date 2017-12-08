package com.sc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sc.framework.utils.DateConvertUtils;

public class DateUtil {


	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String FORMAT_TIME = "HH:mm:ss";
	
	
	public static String getCurrentDATEStart(){
		return DateConvertUtils.format(new Date(), FORMAT_DATE)+" 00:00:00";
	}
	
	public static String getCurrentDATE(){
		return DateConvertUtils.format(new Date(), FORMAT_DATE);
	}
	
	public static String getCurrentTIME(){
		return DateConvertUtils.format(new Date(), FORMAT_TIME);
	}

	public static Date getLastYearDate() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		return date = calendar.getTime();
		//return DateConvertUtils.format(date, FORMAT_DATE);
	}
	
	
	public static String getDateAddMonth1(int month){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		date = calendar.getTime();
		return DateConvertUtils.format(date, FORMAT_DATE_TIME);
	}
	
	public static String getDateAddYear(int year){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		date = calendar.getTime();
		return DateConvertUtils.format(date, FORMAT_DATE)+" 00:00:00";
	}
	
	public static Date getDateAddMonth(int month){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		date = calendar.getTime();
		return date;
	}
	
    /**
    * 计算两个日期之间相隔的天数
    * @param begin
    * @param end
    * @return
    * @throws ParseException
    */
    public static long countDay(String begin,String end){
           SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           Date beginDate , endDate;
           long day = 0;
           try {
            beginDate= format.parse(begin);
            endDate=  format.parse(end);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);  
        } catch (ParseException e) {
            e.printStackTrace();
        }                
           return day;
    }
    

	
    /**
    * 计算两个日期之间相隔的月
    * @param begin
    * @param end
    * @return
    * @throws ParseException
    */
    public static long countMonth(String begin,String end)throws ParseException{
    	int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(sdf.parse(begin));
        c2.setTime(sdf.parse(end));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        if(result<0){
        	result = 0;
        }else if(result==0){
        	result = 1;
        }
        return result ;
    }
    
	
    /**
    * 计算两个日期之间相隔的月
    * @param begin
    * @param end
    * @return
    * @throws ParseException
    */
    public static long countMonth(Date begin,Date end)throws ParseException{
        
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        
        c1.setTime(begin);
        c2.setTime(end);
        
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        
        //开始日期若小月结束日期
        if(year<0){
            return 0;
        }
       
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }
}
