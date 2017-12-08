package com.sc.zhouse.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class HouseType extends CubeBaseEntity implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "HouseType";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_VALUE = "value";
	public static final String ALIAS_PAIX = "paix";
	public static final String ALIAS_PARAM1 = "param1";
	public static final String ALIAS_PARAM2 = "param2";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String name;
	private java.lang.String value;
	private java.lang.String paix;
	private java.lang.String param1;
	private java.lang.String param2;
	///columns END

	public HouseType(){
	}

	public HouseType(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = String.valueOf(value);
	}
	
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setName(java.lang.String value)
    {
		this.name = value;
	}
	
	public java.lang.String getName()
    {
		return this.name;
	}
	public void setValue(java.lang.String value)
    {
		this.value = value;
	}
	
	public java.lang.String getValue()
    {
		return this.value;
	}
	public void setPaix(java.lang.String value)
    {
		this.paix = value;
	}
	
	public java.lang.String getPaix()
    {
		return this.paix;
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

    /**
     * @brief   功能: 将HouseType对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Name",getName())
			.append("Value",getValue())
			.append("Paix",getPaix())
			.append("Param1",getParam1())
			.append("Param2",getParam2())
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
     * @brief   功能: 检测两个HouseType对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof HouseType == false) return false;
		if(this == obj) return true;
		HouseType other = (HouseType)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

