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
public class Terminaltemplate implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer templateId;
	private java.lang.String templateName;
	private java.lang.Integer terminalType;
	private java.lang.Integer templateVersion;
	///columns END

	public Terminaltemplate(){
	}

	public Terminaltemplate(
		java.lang.Integer templateId
	){
		this.templateId = templateId;
	}

	public void setTemplateId(java.lang.Integer value)
    {
		this.templateId = value;
	}
	
	public java.lang.Integer getTemplateId()
    {
		return this.templateId;
	}
	public void setTemplateName(java.lang.String value)
    {
		this.templateName = value;
	}
	
	public java.lang.String getTemplateName()
    {
		return this.templateName;
	}
	public void setTerminalType(java.lang.Integer value)
    {
		this.terminalType = value;
	}
	
	public java.lang.Integer getTerminalType()
    {
		return this.terminalType;
	}
	public void setTemplateVersion(java.lang.Integer value)
    {
		this.templateVersion = value;
	}
	
	public java.lang.Integer getTemplateVersion()
    {
		return this.templateVersion;
	}
	
	private Set terminalparameters = new HashSet(0);
	public void setTerminalparameters(Set<Terminalparameter> terminalparameter)
    {
		this.terminalparameters = terminalparameter;
	}
	
	public Set<Terminalparameter> getTerminalparameters()
    {
		return terminalparameters;
	}

    /**
     * @brief   功能: 将Terminaltemplate对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("TemplateId",getTemplateId())
			.append("TemplateName",getTemplateName())
			.append("TerminalType",getTerminalType())
			.append("TemplateVersion",getTemplateVersion())
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
			.append(getTemplateId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Terminaltemplate对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Terminaltemplate == false) return false;
		if(this == obj) return true;
		Terminaltemplate other = (Terminaltemplate)obj;
		return new EqualsBuilder()
			.append(getTemplateId(),other.getTemplateId())
			.isEquals();
	}
}

