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
public class Devcmdresult implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_CMD_MAKE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_CMD_SEND_TIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer id;
	private java.lang.Integer devCmdId;
	private java.lang.Integer cmdType;
	private java.lang.Integer terminalId;
	private java.lang.Integer cmdNumber;
	private java.lang.String cmdContent;
	private java.lang.Integer cmdTimeout;
	private java.util.Date cmdMakeTime;
	private java.lang.Integer cmdSendTimes;
	private java.util.Date cmdSendTime;
	private java.lang.String cmdAnswerContent;
	private java.lang.Integer errNo;
	private java.lang.String errMsg;
	///columns END

	public Devcmdresult(){
	}

	public Devcmdresult(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer value)
    {
		this.id = value;
	}
	
	public java.lang.Integer getId()
    {
		return this.id;
	}
	public void setDevCmdId(java.lang.Integer value)
    {
		this.devCmdId = value;
	}
	
	public java.lang.Integer getDevCmdId()
    {
		return this.devCmdId;
	}
	public void setCmdType(java.lang.Integer value)
    {
		this.cmdType = value;
	}
	
	public java.lang.Integer getCmdType()
    {
		return this.cmdType;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
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
	public void setCmdTimeout(java.lang.Integer value)
    {
		this.cmdTimeout = value;
	}
	
	public java.lang.Integer getCmdTimeout()
    {
		return this.cmdTimeout;
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
	public void setCmdSendTimes(java.lang.Integer value)
    {
		this.cmdSendTimes = value;
	}
	
	public java.lang.Integer getCmdSendTimes()
    {
		return this.cmdSendTimes;
	}
	public String getCmdSendTimeString()
    {
		return DateConvertUtils.format(getCmdSendTime(), FORMAT_CMD_SEND_TIME);
	}
	public void setCmdSendTimeString(String value)
    {
		setCmdSendTime(DateConvertUtils.parse(value, FORMAT_CMD_SEND_TIME,java.util.Date.class));
	}
	
	public void setCmdSendTime(java.util.Date value)
    {
		this.cmdSendTime = value;
	}
	
	public java.util.Date getCmdSendTime()
    {
		return this.cmdSendTime;
	}
	public void setCmdAnswerContent(java.lang.String value)
    {
		this.cmdAnswerContent = value;
	}
	
	public java.lang.String getCmdAnswerContent()
    {
		return this.cmdAnswerContent;
	}
	public void setErrNo(java.lang.Integer value)
    {
		this.errNo = value;
	}
	
	public java.lang.Integer getErrNo()
    {
		return this.errNo;
	}
	public void setErrMsg(java.lang.String value)
    {
		this.errMsg = value;
	}
	
	public java.lang.String getErrMsg()
    {
		return this.errMsg;
	}

    /**
     * @brief   功能: 将Devcmdresult对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("DevCmdId",getDevCmdId())
			.append("CmdType",getCmdType())
			.append("TerminalId",getTerminalId())
			.append("CmdNumber",getCmdNumber())
			.append("CmdContent",getCmdContent())
			.append("CmdTimeout",getCmdTimeout())
			.append("CmdMakeTime",getCmdMakeTime())
			.append("CmdSendTimes",getCmdSendTimes())
			.append("CmdSendTime",getCmdSendTime())
			.append("CmdAnswerContent",getCmdAnswerContent())
			.append("ErrNo",getErrNo())
			.append("ErrMsg",getErrMsg())
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
			.append(getId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Devcmdresult对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Devcmdresult == false) return false;
		if(this == obj) return true;
		Devcmdresult other = (Devcmdresult)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

