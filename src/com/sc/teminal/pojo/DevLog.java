package com.sc.teminal.pojo;

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
public class DevLog implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "DevLog";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_USER = "user";
	public static final String ALIAS_CONTEXT = "context";
	public static final String ALIAS_DATE = "date";
	public static final String ALIAS_IP = "ip";
	public static final String ALIAS_EX1 = "ex1";
	public static final String ALIAS_EX2 = "ex2";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String user;
	private java.lang.String context;
	private java.util.Date date;
	private java.lang.String ip;
	private java.lang.String ex1;
	private java.lang.String ex2;
	///columns END

	public DevLog(){
	}

	public DevLog(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
	}
	
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setUser(java.lang.String value)
    {
		this.user = value;
	}
	
	public java.lang.String getUser()
    {
		return this.user;
	}
	public void setContext(java.lang.String value)
    {
		this.context = value;
	}
	
	public java.lang.String getContext()
    {
		return this.context;
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
	public void setIp(java.lang.String value)
    {
		this.ip = value;
	}
	
	public java.lang.String getIp()
    {
		return this.ip;
	}
	public void setEx1(java.lang.String value)
    {
		this.ex1 = value;
	}
	
	public java.lang.String getEx1()
    {
		return this.ex1;
	}
	public void setEx2(java.lang.String value)
    {
		this.ex2 = value;
	}
	
	public java.lang.String getEx2()
    {
		return this.ex2;
	}

    /**
     * @brief   功能: 将DevLog对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("User",getUser())
			.append("Context",getContext())
			.append("Date",getDate())
			.append("Ip",getIp())
			.append("Ex1",getEx1())
			.append("Ex2",getEx2())
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
     * @brief   功能: 检测两个DevLog对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof DevLog == false) return false;
		if(this == obj) return true;
		DevLog other = (DevLog)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

