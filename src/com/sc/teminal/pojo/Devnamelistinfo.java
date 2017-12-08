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
public class Devnamelistinfo implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_EDIT_TIME = "yyyy-MM-dd";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer nameListId;
	private java.lang.Integer terminalId;
	private java.util.Date editTime;
	private java.lang.Integer syncState;
	private java.lang.String cardNo;
	private java.lang.String content;
	private Integer updateType;
	///columns END

	public Devnamelistinfo(){
	}

	public Devnamelistinfo(
		java.lang.Integer nameListId
	){
		this.nameListId = nameListId;
	}

	public void setNameListId(java.lang.Integer value)
    {
		this.nameListId = value;
	}
	
	public java.lang.Integer getNameListId()
    {
		return this.nameListId;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public String getEditTimeString()
    {
		return DateConvertUtils.format(getEditTime(), FORMAT_EDIT_TIME);
	}
	public void setEditTimeString(String value)
    {
		setEditTime(DateConvertUtils.parse(value, FORMAT_EDIT_TIME,java.util.Date.class));
	}
	
	public void setEditTime(java.util.Date value)
    {
		this.editTime = value;
	}
	
	public java.util.Date getEditTime()
    {
		return this.editTime;
	}
	public void setSyncState(java.lang.Integer value)
    {
		this.syncState = value;
	}
	
	public java.lang.Integer getSyncState()
    {
		return this.syncState;
	}
	public void setCardNo(java.lang.String value)
    {
		this.cardNo = value;
	}
	
	public java.lang.String getCardNo()
    {
		return this.cardNo;
	}
	public void setContent(java.lang.String value)
    {
		this.content = value;
	}
	
	public java.lang.String getContent()
    {
		return this.content;
	}
	public void setUpdateType(Integer value)
    {
		this.updateType = value;
	}
	
	public Integer getUpdateType()
    {
		return this.updateType;
	}
	
	private Terminalinfo terminalinfo;
	
	public void setTerminalinfo(Terminalinfo terminalinfo)
    {
		this.terminalinfo = terminalinfo;
	}
	
	public Terminalinfo getTerminalinfo()
    {
		return terminalinfo;
	}

    /**
     * @brief   功能: 将Devnamelistinfo对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("NameListId",getNameListId())
			.append("TerminalId",getTerminalId())
			.append("EditTime",getEditTime())
			.append("SyncState",getSyncState())
			.append("CardNo",getCardNo())
			.append("Content",getContent())
			.append("UpdateType",getUpdateType())
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
			.append(getNameListId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Devnamelistinfo对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Devnamelistinfo == false) return false;
		if(this == obj) return true;
		Devnamelistinfo other = (Devnamelistinfo)obj;
		return new EqualsBuilder()
			.append(getNameListId(),other.getNameListId())
			.isEquals();
	}
}

