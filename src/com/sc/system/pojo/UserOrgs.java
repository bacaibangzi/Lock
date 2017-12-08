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
public class UserOrgs implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "UserOrgs";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_ORG_CODE = "orgCode";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Long sn;
	private java.lang.String userId;
	private java.lang.String orgCode;
	///columns END

	public UserOrgs(){
	}

	public UserOrgs(
		java.lang.Long sn
	){
		this.sn = sn;
	}

	public void setSn(java.lang.Long value)
    {
		this.sn = value;
	}
	
	public java.lang.Long getSn()
    {
		return this.sn;
	}
	public void setUserId(java.lang.String value)
    {
		this.userId = value;
	}
	
	public java.lang.String getUserId()
    {
		return this.userId;
	}
	public void setOrgCode(java.lang.String value)
    {
		this.orgCode = value;
	}
	
	public java.lang.String getOrgCode()
    {
		return this.orgCode;
	}

    /**
     * @brief   功能: 将UserOrgs对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("UserId",getUserId())
			.append("OrgCode",getOrgCode())
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
     * @brief   功能: 检测两个UserOrgs对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof UserOrgs == false) return false;
		if(this == obj) return true;
		UserOrgs other = (UserOrgs)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

