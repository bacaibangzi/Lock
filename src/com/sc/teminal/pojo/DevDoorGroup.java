package com.sc.teminal.pojo;

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
public class DevDoorGroup   extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "DevDoorGroup";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_FISN = "fisn";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_MEMO = "memo";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer fisn;
	private java.lang.String name;
	private java.lang.String memo;
	private Integer max;
	///columns END

	public DevDoorGroup(){
	} 

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = String.valueOf(value);
	}
	
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setFisn(java.lang.Integer value)
    {
		this.fisn = value;
	}
	
	public java.lang.Integer getFisn()
    {
		return this.fisn;
	}
	public void setName(java.lang.String value)
    {
		this.name = value;
	}
	
	public java.lang.String getName()
    {
		return this.name;
	}
	public void setMemo(java.lang.String value)
    {
		this.memo = value;
	}
	
	public java.lang.String getMemo()
    {
		return this.memo;
	}

    /**
     * @brief   功能: 将DevDoorGroup对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Fisn",getFisn())
			.append("Name",getName())
			.append("Memo",getMemo())
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
     * @brief   功能: 检测两个DevDoorGroup对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof DevDoorGroup == false) return false;
		if(this == obj) return true;
		DevDoorGroup other = (DevDoorGroup)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

