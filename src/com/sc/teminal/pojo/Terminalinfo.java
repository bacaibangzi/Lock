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
public class Terminalinfo  extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer terminalId;
	private java.lang.Integer controllerId;
	private java.lang.String terminalName;
	private java.lang.Integer devCode;
	private java.lang.Integer devType;
	private Integer isUse;
	private java.lang.Integer templateId;
	private java.lang.Integer templateVersion;
	private java.lang.Integer firmwareVer;
	private java.lang.String remark;
	private java.lang.Integer repeater1;
	private java.lang.Integer repeater2;
	private java.lang.Integer repeater3;
	
	private String sn;
	private String code;
	
	private String controllerName;
	
	private String devState;
	private String stateTime;
	
	private String devModel;
	private String devModelStr;
	private String devStateStr;
	private String devTypeStr;
	
	private String swipetime;
	private String gathertime;
	private String dl;
	private String sfbj;
	
	
	///columns END

	public Terminalinfo(){
	}

	public String getSfbj() {
		return sfbj;
	}

	public void setSfbj(String sfbj) {
		this.sfbj = sfbj;
	}

	public String getDl() {
		return dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getSwipetime() {
		return swipetime;
	}

	public void setSwipetime(String swipetime) {
		this.swipetime = swipetime;
	}

	public String getGathertime() {
		return gathertime;
	}

	public void setGathertime(String gathertime) {
		this.gathertime = gathertime;
	}

	public String getDevTypeStr() {
		return devTypeStr;
	}

	public void setDevTypeStr(String devTypeStr) {
		this.devTypeStr = devTypeStr;
	}

	public String getCode() {
		return code;
	}

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
		if("42".equals(devModel)){
			this.setDevModelStr("el100");
		}else if("43".equals(devModel)){
			this.setDevModelStr("el200");
		}else if("45".equals(devModel)){
			this.setDevModelStr("el150");
		}
		
	}

	public String getDevModelStr() {
		return devModelStr;
	}

	public void setDevModelStr(String devModelStr) {
		this.devModelStr = devModelStr;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDevStateStr() {
		return devStateStr;
	}

	public void setDevStateStr(String devStateStr) {
		this.devStateStr = devStateStr;
	}

	public Terminalinfo(
		java.lang.Integer terminalId
	){
		this.terminalId = terminalId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.idStr = sn;
		this.sn = sn;
	}

	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
		this.setCode(value.toString());
		//this.idStr = String.valueOf(value);
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public void setControllerId(java.lang.Integer value)
    {
		this.controllerId = value;
	}
	
	public String getDevState() {
		return devState;
	}

	public void setDevState(String devState) {
		this.devState = devState;
		if("0".equals(devState)){
			this.setDevStateStr("离线");
		}else if("1".equals(devState)){
			this.setDevStateStr("在线");
		}
	}

	public String getStateTime() {
		return stateTime;
	}

	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}

	public java.lang.Integer getControllerId()
    {
		return this.controllerId;
	}
	public void setTerminalName(java.lang.String value)
    {
		this.terminalName = value;
	}
	
	public java.lang.String getTerminalName()
    {
		return this.terminalName;
	}
	public void setDevCode(java.lang.Integer value)
    {
		this.devCode = value;
	}
	
	public java.lang.Integer getDevCode()
    {
		return this.devCode;
	}
	public void setDevType(java.lang.Integer value)
    {
		this.devType = value;
		if("1".equals(String.valueOf(value))){
			this.setDevTypeStr("标准版消费机");
		}else if("5".equals(String.valueOf(value))){
			this.setDevTypeStr("定制版水控");
		}else if("6".equals(String.valueOf(value))){
			this.setDevTypeStr("标准水控");
		}else if("11".equals(String.valueOf(value))){
			this.setDevTypeStr("标准版考勤机");
		}else if("21".equals(String.valueOf(value))){
			this.setDevTypeStr("标准版门禁");
		}else if("22".equals(String.valueOf(value))){
			this.setDevTypeStr("电子门锁");
		}
	}
	
	public java.lang.Integer getDevType()
    {
		return this.devType;
	}
	public void setIsUse(Integer value)
    {
		this.isUse = value;
	}
	
	public Integer getIsUse()
    {
		return this.isUse;
	}
	public void setTemplateId(java.lang.Integer value)
    {
		this.templateId = value;
	}
	
	public java.lang.Integer getTemplateId()
    {
		return this.templateId;
	}
	public void setTemplateVersion(java.lang.Integer value)
    {
		this.templateVersion = value;
	}
	
	public java.lang.Integer getTemplateVersion()
    {
		return this.templateVersion;
	}
	public void setFirmwareVer(java.lang.Integer value)
    {
		this.firmwareVer = value;
	}
	
	public java.lang.Integer getFirmwareVer()
    {
		return this.firmwareVer;
	}
	public void setRemark(java.lang.String value)
    {
		this.remark = value;
	}
	
	public java.lang.String getRemark()
    {
		return this.remark;
	}
	public void setRepeater1(java.lang.Integer value)
    {
		this.repeater1 = value;
	}
	
	public java.lang.Integer getRepeater1()
    {
		return this.repeater1;
	}
	public void setRepeater2(java.lang.Integer value)
    {
		this.repeater2 = value;
	}
	
	public java.lang.Integer getRepeater2()
    {
		return this.repeater2;
	}
	public void setRepeater3(java.lang.Integer value)
    {
		this.repeater3 = value;
	}
	
	public java.lang.Integer getRepeater3()
    {
		return this.repeater3;
	}
	
	private Set devnamelistinfos = new HashSet(0);
	public void setDevnamelistinfos(Set<Devnamelistinfo> devnamelistinfo)
    {
		this.devnamelistinfos = devnamelistinfo;
	}
	
	public Set<Devnamelistinfo> getDevnamelistinfos()
    {
		return devnamelistinfos;
	}
	
	private Controllerinfo controllerinfo;
	
	public void setControllerinfo(Controllerinfo controllerinfo)
    {
		this.controllerinfo = controllerinfo;
	}
	
	public Controllerinfo getControllerinfo()
    {
		return controllerinfo;
	}

    public String getControllerName() {
		return controllerName;
	}

	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}

	/**
     * @brief   功能: 将Terminalinfo对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TerminalId",getTerminalId())
			.append("ControllerId",getControllerId())
			.append("TerminalName",getTerminalName())
			.append("DevCode",getDevCode())
			.append("DevType",getDevType())
			.append("IsUse",getIsUse())
			.append("TemplateId",getTemplateId())
			.append("TemplateVersion",getTemplateVersion())
			.append("FirmwareVer",getFirmwareVer())
			.append("Remark",getRemark())
			.append("Repeater1",getRepeater1())
			.append("Repeater2",getRepeater2())
			.append("Repeater3",getRepeater3())
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
			.append(getTerminalId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Terminalinfo对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Terminalinfo == false) return false;
		if(this == obj) return true;
		Terminalinfo other = (Terminalinfo)obj;
		return new EqualsBuilder()
			.append(getTerminalId(),other.getTerminalId())
			.isEquals();
	}
}

