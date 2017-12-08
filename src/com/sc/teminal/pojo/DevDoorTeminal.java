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
public class DevDoorTeminal   extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "DevDoorTeminal";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_DOOR_GROUP_SN = "doorGroupSn";
	public static final String ALIAS_TERMINAL_ID = "terminalId";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer doorGroupSn;
	private java.lang.Integer terminalId;
	///columns END

	public DevDoorTeminal(){
	}
 
	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = value.toString();
	}
	
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setDoorGroupSn(java.lang.Integer value)
    {
		this.doorGroupSn = value;
	}
	
	public java.lang.Integer getDoorGroupSn()
    {
		return this.doorGroupSn;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}

    /**
     * @brief   功能: 将DevDoorTeminal对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("DoorGroupSn",getDoorGroupSn())
			.append("TerminalId",getTerminalId())
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
     * @brief   功能: 检测两个DevDoorTeminal对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof DevDoorTeminal == false) return false;
		if(this == obj) return true;
		DevDoorTeminal other = (DevDoorTeminal)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

