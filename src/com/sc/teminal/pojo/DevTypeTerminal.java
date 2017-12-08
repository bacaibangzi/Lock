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
public class DevTypeTerminal extends CubeBaseEntity implements java.io.Serializable,Cloneable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "DevTypeTerminal";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_TYPE_ID = "typeId";
	public static final String ALIAS_TYPE_NAME = "typeName";
	public static final String ALIAS_STATUS = "status";
	public static final String ALIAS_YEARS = "years";
	public static final String ALIAS_TERMINAL_ID = "terminalId";
	public static final String ALIAS_TERMINAL_NAME = "terminalName";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer typeId;
	private java.lang.String typeName;
	private java.lang.Integer status;
	private java.lang.Integer years;
	private java.lang.Integer terminalId;
	private java.lang.String terminalName;
	///columns END

	public DevTypeTerminal(){
	}

	public DevTypeTerminal(
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
	public void setTypeId(java.lang.Integer value)
    {
		this.typeId = value;
		this.idStr = String.valueOf(value);
	}
	
	public java.lang.Integer getTypeId()
    {
		return this.typeId;
	}
	public void setTypeName(java.lang.String value)
    {
		this.typeName = value;
	}
	
	public java.lang.String getTypeName()
    {
		return this.typeName;
	}
	public void setStatus(java.lang.Integer value)
    {
		this.status = value;
	}
	
	public java.lang.Integer getStatus()
    {
		return this.status;
	}
	public void setYears(java.lang.Integer value)
    {
		this.years = value;
	}
	
	public java.lang.Integer getYears()
    {
		return this.years;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public void setTerminalName(java.lang.String value)
    {
		this.terminalName = value;
	}
	
	public java.lang.String getTerminalName()
    {
		return this.terminalName;
	}

    /**
     * @brief   功能: 将DevTypeTerminal对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("TypeId",getTypeId())
			.append("TypeName",getTypeName())
			.append("Status",getStatus())
			.append("Years",getYears())
			.append("TerminalId",getTerminalId())
			.append("TerminalName",getTerminalName())
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
     * @brief   功能: 检测两个DevTypeTerminal对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof DevTypeTerminal == false) return false;
		if(this == obj) return true;
		DevTypeTerminal other = (DevTypeTerminal)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

