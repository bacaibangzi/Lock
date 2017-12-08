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
public class Terminalexception implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_EXCEPTION_TIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer exceptionId;
	private java.lang.Integer terminalId;
	private java.lang.Integer terminalCode;
	private java.lang.Integer terminalType;
	private java.lang.Integer exceptionType;
	private java.util.Date exceptionTime;
	///columns END

	public Terminalexception(){
	}

	public Terminalexception(
		java.lang.Integer exceptionId
	){
		this.exceptionId = exceptionId;
	}

	public void setExceptionId(java.lang.Integer value)
    {
		this.exceptionId = value;
	}
	
	public java.lang.Integer getExceptionId()
    {
		return this.exceptionId;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public void setTerminalCode(java.lang.Integer value)
    {
		this.terminalCode = value;
	}
	
	public java.lang.Integer getTerminalCode()
    {
		return this.terminalCode;
	}
	public void setTerminalType(java.lang.Integer value)
    {
		this.terminalType = value;
	}
	
	public java.lang.Integer getTerminalType()
    {
		return this.terminalType;
	}
	public void setExceptionType(java.lang.Integer value)
    {
		this.exceptionType = value;
	}
	
	public java.lang.Integer getExceptionType()
    {
		return this.exceptionType;
	}
	public String getExceptionTimeString()
    {
		return DateConvertUtils.format(getExceptionTime(), FORMAT_EXCEPTION_TIME);
	}
	public void setExceptionTimeString(String value)
    {
		setExceptionTime(DateConvertUtils.parse(value, FORMAT_EXCEPTION_TIME,java.util.Date.class));
	}
	
	public void setExceptionTime(java.util.Date value)
    {
		this.exceptionTime = value;
	}
	
	public java.util.Date getExceptionTime()
    {
		return this.exceptionTime;
	}

    /**
     * @brief   功能: 将Terminalexception对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ExceptionId",getExceptionId())
			.append("TerminalId",getTerminalId())
			.append("TerminalCode",getTerminalCode())
			.append("TerminalType",getTerminalType())
			.append("ExceptionType",getExceptionType())
			.append("ExceptionTime",getExceptionTime())
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
			.append(getExceptionId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Terminalexception对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Terminalexception == false) return false;
		if(this == obj) return true;
		Terminalexception other = (Terminalexception)obj;
		return new EqualsBuilder()
			.append(getExceptionId(),other.getExceptionId())
			.isEquals();
	}
}

