package com.sc.zhouse.pojo;

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
public class UserHouse implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "UserHouse";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_HOUSE_ID = "houseId";
	public static final String ALIAS_TYPE = "åž‹ç±»ï¼š";
	public static final String ALIAS_DATE = "date";
	public static final String ALIAS_PARAM1 = "param1";
	public static final String ALIAS_PARAM2 = "param2";
	public static final String ALIAS_PARAM3 = "param3";
	public static final String ALIAS_PARAM4 = "param4";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer userId;
	private java.lang.Integer houseId;
	private java.lang.Integer type;
	private java.util.Date date;
	private java.lang.String param1;
	private java.lang.String param2;
	private java.lang.String param3;
	private java.lang.String param4;
	///columns END

	public UserHouse(){
	}
 

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
	}
	
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setUserId(java.lang.Integer value)
    {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId()
    {
		return this.userId;
	}
	public void setHouseId(java.lang.Integer value)
    {
		this.houseId = value;
	}
	
	public java.lang.Integer getHouseId()
    {
		return this.houseId;
	}
	public void setType(java.lang.Integer value)
    {
		this.type = value;
	}
	
	public java.lang.Integer getType()
    {
		return this.type;
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
	public void setParam1(java.lang.String value)
    {
		this.param1 = value;
	}
	
	public java.lang.String getParam1()
    {
		return this.param1;
	}
	public void setParam2(java.lang.String value)
    {
		this.param2 = value;
	}
	
	public java.lang.String getParam2()
    {
		return this.param2;
	}
	public void setParam3(java.lang.String value)
    {
		this.param3 = value;
	}
	
	public java.lang.String getParam3()
    {
		return this.param3;
	}
	public void setParam4(java.lang.String value)
    {
		this.param4 = value;
	}
	
	public java.lang.String getParam4()
    {
		return this.param4;
	}

    /**
     * @brief   功能: 将UserHouse对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("UserId",getUserId())
			.append("HouseId",getHouseId())
			.append("Type",getType())
			.append("Date",getDate())
			.append("Param1",getParam1())
			.append("Param2",getParam2())
			.append("Param3",getParam3())
			.append("Param4",getParam4())
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
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个UserHouse对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof UserHouse == false) return false;
		if(this == obj) return true;
		UserHouse other = (UserHouse)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

