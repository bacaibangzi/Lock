package com.sc.system.pojo;

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
public class ViewXsZhusu implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "ViewXsZhusu";
	public static final String ALIAS_STU_NO = "stuNo";
	public static final String ALIAS_STUDENT_NAME = "studentName";
	public static final String ALIAS_LYMC = "lymc";
	public static final String ALIAS_FJMC = "fjmc";
	public static final String ALIAS_CWH = "cwh";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.String stuNo;
	private java.lang.String studentName;
	private java.lang.String lymc;
	private java.lang.String fjmc;
	private java.lang.String cwh;
	///columns END

	public ViewXsZhusu(){
	}

	public ViewXsZhusu(
		java.lang.String stuNo
	){
		this.stuNo = stuNo;
	}

	public void setStuNo(java.lang.String value)
    {
		this.stuNo = value;
	}
	
	public java.lang.String getStuNo()
    {
		return this.stuNo;
	}
	public void setStudentName(java.lang.String value)
    {
		this.studentName = value;
	}
	
	public java.lang.String getStudentName()
    {
		return this.studentName;
	}
	public void setLymc(java.lang.String value)
    {
		this.lymc = value;
	}
	
	public java.lang.String getLymc()
    {
		return this.lymc;
	}
	public void setFjmc(java.lang.String value)
    {
		this.fjmc = value;
	}
	
	public java.lang.String getFjmc()
    {
		return this.fjmc;
	}
	public void setCwh(java.lang.String value)
    {
		this.cwh = value;
	}
	
	public java.lang.String getCwh()
    {
		return this.cwh;
	}

    /**
     * @brief   功能: 将ViewXsZhusu对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("StuNo",getStuNo())
			.append("StudentName",getStudentName())
			.append("Lymc",getLymc())
			.append("Fjmc",getFjmc())
			.append("Cwh",getCwh())
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
			.append(getStuNo())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个ViewXsZhusu对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof ViewXsZhusu == false) return false;
		if(this == obj) return true;
		ViewXsZhusu other = (ViewXsZhusu)obj;
		return new EqualsBuilder()
			.append(getStuNo(),other.getStuNo())
			.isEquals();
	}
}

