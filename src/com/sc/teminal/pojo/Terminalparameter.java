package com.sc.teminal.pojo;

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
public class Terminalparameter implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L; 
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer parameterId;
	private java.lang.Integer templateId;
	private java.lang.Integer paraNo;
	private java.lang.String paraContent;
	private Integer isChange;
	///columns END

	public Terminalparameter(){
	}

	public Terminalparameter(
		java.lang.Integer parameterId
	){
		this.parameterId = parameterId;
	}

	public void setParameterId(java.lang.Integer value)
    {
		this.parameterId = value;
	}
	
	public java.lang.Integer getParameterId()
    {
		return this.parameterId;
	}
	public void setTemplateId(java.lang.Integer value)
    {
		this.templateId = value;
	}
	
	public java.lang.Integer getTemplateId()
    {
		return this.templateId;
	}
	public void setParaNo(java.lang.Integer value)
    {
		this.paraNo = value;
	}
	
	public java.lang.Integer getParaNo()
    {
		return this.paraNo;
	}
	public void setParaContent(java.lang.String value)
    {
		this.paraContent = value;
	}
	
	public java.lang.String getParaContent()
    {
		return this.paraContent;
	}
	public void setIsChange(Integer value)
    {
		this.isChange = value;
	}
	
	public Integer getIsChange()
    {
		return this.isChange;
	}
	
	private Terminaltemplate terminaltemplate;
	
	public void setTerminaltemplate(Terminaltemplate terminaltemplate)
    {
		this.terminaltemplate = terminaltemplate;
	}
	
	public Terminaltemplate getTerminaltemplate()
    {
		return terminaltemplate;
	}

    /**
     * @brief   功能: 将Terminalparameter对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("ParameterId",getParameterId())
			.append("TemplateId",getTemplateId())
			.append("ParaNo",getParaNo())
			.append("ParaContent",getParaContent())
			.append("IsChange",getIsChange())
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
			.append(getParameterId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Terminalparameter对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Terminalparameter == false) return false;
		if(this == obj) return true;
		Terminalparameter other = (Terminalparameter)obj;
		return new EqualsBuilder()
			.append(getParameterId(),other.getParameterId())
			.isEquals();
	}
}

