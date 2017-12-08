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
public class Devcmdlist implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_CMD_MAKE_TIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer devCmdId;
	private java.lang.Integer controllerId;
	private java.lang.Integer terminalId;
	private java.lang.Integer cmdType;
	private java.lang.Integer cmdNumber;
	private java.lang.String cmdContent;
	private java.util.Date cmdMakeTime;
	///columns END

	public Devcmdlist(){
	}

	public Devcmdlist(
		java.lang.Integer devCmdId
	){
		this.devCmdId = devCmdId;
	}

	public void setDevCmdId(java.lang.Integer value)
    {
		this.devCmdId = value;
	}
	
	public java.lang.Integer getDevCmdId()
    {
		return this.devCmdId;
	}
	public void setControllerId(java.lang.Integer value)
    {
		this.controllerId = value;
	}
	
	public java.lang.Integer getControllerId()
    {
		return this.controllerId;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public void setCmdType(java.lang.Integer value)
    {
		this.cmdType = value;
	}
	
	public java.lang.Integer getCmdType()
    {
		return this.cmdType;
	}
	public void setCmdNumber(java.lang.Integer value)
    {
		this.cmdNumber = value;
	}
	
	public java.lang.Integer getCmdNumber()
    {
		return this.cmdNumber;
	}
	public void setCmdContent(java.lang.String value)
    {
		this.cmdContent = value;
	}
	
	public java.lang.String getCmdContent()
    {
		return this.cmdContent;
	}
	public String getCmdMakeTimeString()
    {
		return DateConvertUtils.format(getCmdMakeTime(), FORMAT_CMD_MAKE_TIME);
	}
	public void setCmdMakeTimeString(String value)
    {
		setCmdMakeTime(DateConvertUtils.parse(value, FORMAT_CMD_MAKE_TIME,java.util.Date.class));
	}
	
	public void setCmdMakeTime(java.util.Date value)
    {
		this.cmdMakeTime = value;
	}
	
	public java.util.Date getCmdMakeTime()
    {
		return this.cmdMakeTime;
	}

    /**
     * @brief   功能: 将Devcmdlist对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("DevCmdId",getDevCmdId())
			.append("ControllerId",getControllerId())
			.append("TerminalId",getTerminalId())
			.append("CmdType",getCmdType())
			.append("CmdNumber",getCmdNumber())
			.append("CmdContent",getCmdContent())
			.append("CmdMakeTime",getCmdMakeTime())
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
			.append(getDevCmdId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Devcmdlist对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Devcmdlist == false) return false;
		if(this == obj) return true;
		Devcmdlist other = (Devcmdlist)obj;
		return new EqualsBuilder()
			.append(getDevCmdId(),other.getDevCmdId())
			.isEquals();
	}
}

