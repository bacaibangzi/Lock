package com.sc.teminal.pojo;

import java.util.HashSet;
import java.util.Set;

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
public class Stationinfo implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L; 
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer stationId;
	private java.lang.String stationCode;
	private java.lang.String stationName;
	private java.lang.String stationPosition;
	private Integer isUse;
	private java.lang.String remark;
	///columns END

	public Stationinfo(){
	}

	public Stationinfo(
		java.lang.Integer stationId
	){
		this.stationId = stationId;
	}

	public void setStationId(java.lang.Integer value)
    {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId()
    {
		return this.stationId;
	}
	public void setStationCode(java.lang.String value)
    {
		this.stationCode = value;
	}
	
	public java.lang.String getStationCode()
    {
		return this.stationCode;
	}
	public void setStationName(java.lang.String value)
    {
		this.stationName = value;
	}
	
	public java.lang.String getStationName()
    {
		return this.stationName;
	}
	public void setStationPosition(java.lang.String value)
    {
		this.stationPosition = value;
	}
	
	public java.lang.String getStationPosition()
    {
		return this.stationPosition;
	}
	public void setIsUse(Integer value)
    {
		this.isUse = value;
	}
	
	public Integer getIsUse()
    {
		return this.isUse;
	}
	public void setRemark(java.lang.String value)
    {
		this.remark = value;
	}
	
	public java.lang.String getRemark()
    {
		return this.remark;
	}
	
	private Set controllerinfos = new HashSet(0);
	public void setControllerinfos(Set<Controllerinfo> controllerinfo)
    {
		this.controllerinfos = controllerinfo;
	}
	
	public Set<Controllerinfo> getControllerinfos()
    {
		return controllerinfos;
	}

    /**
     * @brief   功能: 将Stationinfo对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StationId",getStationId())
			.append("StationCode",getStationCode())
			.append("StationName",getStationName())
			.append("StationPosition",getStationPosition())
			.append("IsUse",getIsUse())
			.append("Remark",getRemark())
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
			.append(getStationId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Stationinfo对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Stationinfo == false) return false;
		if(this == obj) return true;
		Stationinfo other = (Stationinfo)obj;
		return new EqualsBuilder()
			.append(getStationId(),other.getStationId())
			.isEquals();
	}
}

