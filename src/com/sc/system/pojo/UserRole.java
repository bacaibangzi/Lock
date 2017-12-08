package com.sc.system.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class UserRole implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "UserRole";
	public static final String ALIAS_UR_ID = "ç”¨æˆ·è§’è‰²ID";
	public static final String ALIAS_UI_ID = "ç”¨æˆ·ID";
	public static final String ALIAS_RI_ID = "è§’è‰²ID";
	public static final String ALIAS_UR_TIME = "åˆ°æœŸæ—¶é—´";
	
	///date formats
	public static final String FORMAT_UR_TIME = "yyyy-mm-dd";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Long urId;
	private java.lang.Long uiId;
	private java.lang.Long riId;
	private java.util.Date urTime;
	///columns END

	public UserRole(){
	}

	public UserRole(
		java.lang.Long urId
	){
		this.urId = urId;
	}

	public void setUrId(java.lang.Long value)
    {
		this.urId = value;
	}
	
	public java.lang.Long getUrId()
    {
		return this.urId;
	}
	public void setUiId(java.lang.Long value)
    {
		this.uiId = value;
	}
	
	public java.lang.Long getUiId()
    {
		return this.uiId;
	}
	public void setRiId(java.lang.Long value)
    {
		this.riId = value;
	}
	
	public java.lang.Long getRiId()
    {
		return this.riId;
	}
	public String getUrTimeString()
    {
		return null;//DateConvertUtils.format(getUrTime(), FORMAT_UR_TIME);
	}
	public void setUrTimeString(String value)
    {
		//setUrTime(DateConvertUtils.parse(value, FORMAT_UR_TIME,java.util.Date.class));
	}
	
	public void setUrTime(java.util.Date value)
    {
		this.urTime = value;
	}
	
	public java.util.Date getUrTime()
    {
		return this.urTime;
	}

    /**
     * @brief   功能: 将UserRole对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UrId",getUrId())
			.append("UiId",getUiId())
			.append("RiId",getRiId())
			.append("UrTime",getUrTime())
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
			.append(getUrId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个UserRole对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof UserRole == false) return false;
		if(this == obj) return true;
		UserRole other = (UserRole)obj;
		return new EqualsBuilder()
			.append(getUrId(),other.getUrId())
			.isEquals();
	}
}

