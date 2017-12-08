package com.sc.teminal.pojo;

import java.util.HashSet;
import java.util.Set;

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
public class Controllerinfo  extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer controllerId;
	private java.lang.Integer stationId;
	private java.lang.Integer channel;
	private java.lang.String controllerName;
	private java.lang.String ip;
	private java.lang.Integer port;
	private java.lang.String position;
	private Integer isUse;
	private java.lang.String remark;
	private java.lang.String isUseStr;
	

	public java.lang.String getIsUseStr() {
		return isUseStr;
	}

	public void setIsUseStr(java.lang.String isUseStr) {
		this.isUseStr = isUseStr;
	}

	private java.lang.String stationName;
	///columns END

	public Controllerinfo(){
	}

	public java.lang.String getStationName() {
		return stationName;
	}

	public void setStationName(java.lang.String stationName) {
		this.stationName = stationName;
	}

	public Controllerinfo(
		java.lang.Integer controllerId
	){
		this.controllerId = controllerId;
	}

	public void setControllerId(java.lang.Integer value)
    {
		this.controllerId = value;
		this.idStr = value.toString();
	}
	
	public java.lang.Integer getControllerId()
    {
		return this.controllerId;
	}
	public void setStationId(java.lang.Integer value)
    {
		this.stationId = value;
	}
	
	public java.lang.Integer getStationId()
    {
		return this.stationId;
	}
	public void setChannel(java.lang.Integer value)
    {
		this.channel = value;
	}
	
	public java.lang.Integer getChannel()
    {
		return this.channel;
	}
	public void setControllerName(java.lang.String value)
    {
		this.controllerName = value;
	}
	
	public java.lang.String getControllerName()
    {
		return this.controllerName;
	}
	public void setIp(java.lang.String value)
    {
		this.ip = value;
	}
	
	public java.lang.String getIp()
    {
		return this.ip;
	}
	public void setPort(java.lang.Integer value)
    {
		this.port = value;
	}
	
	public java.lang.Integer getPort()
    {
		return this.port;
	}
	public void setPosition(java.lang.String value)
    {
		this.position = value;
	}
	
	public java.lang.String getPosition()
    {
		return this.position;
	}
	public void setIsUse(Integer value)
    {
		this.isUse = value;
		if(value.intValue()==0){
			this.setIsUseStr("未启用");
		}else{
			this.setIsUseStr("启用");
		}
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
	
	private Set terminalinfos = new HashSet(0);
	public void setTerminalinfos(Set<Terminalinfo> terminalinfo)
    {
		this.terminalinfos = terminalinfo;
	}
	
	public Set<Terminalinfo> getTerminalinfos()
    {
		return terminalinfos;
	}
	
	private Stationinfo stationinfo;
	
	public void setStationinfo(Stationinfo stationinfo)
    {
		this.stationinfo = stationinfo;
	}
	
	public Stationinfo getStationinfo()
    {
		return stationinfo;
	}

    /**
     * @brief   功能: 将Controllerinfo对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ControllerId",getControllerId())
			.append("StationId",getStationId())
			.append("Channel",getChannel())
			.append("ControllerName",getControllerName())
			.append("Ip",getIp())
			.append("Port",getPort())
			.append("Position",getPosition())
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
			.append(getControllerId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Controllerinfo对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Controllerinfo == false) return false;
		if(this == obj) return true;
		Controllerinfo other = (Controllerinfo)obj;
		return new EqualsBuilder()
			.append(getControllerId(),other.getControllerId())
			.isEquals();
	}
}

