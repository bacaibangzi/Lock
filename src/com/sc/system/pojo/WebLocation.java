package com.sc.system.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class WebLocation implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "WebLocation";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_LON = "lon";
	public static final String ALIAS_LAT = "lat";
	public static final String ALIAS_DATE = "date";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.String sn;
	private java.lang.String lon;
	private java.lang.String lat;
	private java.util.Date date;
	///columns END

	public WebLocation(){
	}

	public WebLocation(
		java.lang.String sn
	){
		this.sn = sn;
	}

	public void setSn(java.lang.String value)
    {
		this.sn = value;
	}
	
	public java.lang.String getSn()
    {
		return this.sn;
	}
	public void setLon(java.lang.String value)
    {
		this.lon = value;
	}
	
	public java.lang.String getLon()
    {
		return this.lon;
	}
	public void setLat(java.lang.String value)
    {
		this.lat = value;
	}
	
	public java.lang.String getLat()
    {
		return this.lat;
	}
	public String getDateString()
    {
		return DateConvertUtils.format(getDate(), FORMAT_DATE);
	}
	public void setDateString(String value)
    {
		setDate(DateConvertUtils.parse(value, FORMAT_DATE,java.util.Date.class));
	}
	
	public void setDate(java.util.Date value)
    {
		this.date = value;
	}
	
	public java.util.Date getDate()
    {
		return this.date;
	}

    /**
     * @brief   功能: 将WebLocation对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Lon",getLon())
			.append("Lat",getLat())
			.append("Date",getDate())
			.toString();
	}
	
    /**
     * @brief   功能: 
     * @param   
     * @return  
     */
	public int hashCode()
    {
		return new HashCodeBuilder()
			.append(getSn())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个WebLocation对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof WebLocation == false) return false;
		if(this == obj) return true;
		WebLocation other = (WebLocation)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

