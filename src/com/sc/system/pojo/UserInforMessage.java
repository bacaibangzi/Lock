package com.sc.system.pojo;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class UserInforMessage implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "UserInforMessage";
	public static final String ALIAS_IDNUMBER = "idnumber";
	public static final String ALIAS_MESSAGE_TYPE = "messageType";
	public static final String ALIAS_CARDNO = "cardno";
	public static final String ALIAS_CARDID = "cardid";
	public static final String ALIAS_OLDCARDNO = "oldcardno";
	public static final String ALIAS_OLDCARDID = "oldcardid";
	public static final String ALIAS_CDTYPE = "cdtype";
	public static final String ALIAS_USERNAME = "username";
	public static final String ALIAS_IDTYPE = "idtype";
	public static final String ALIAS_IDSERIAL = "idserial";
	public static final String ALIAS_PID = "pid";
	public static final String ALIAS_DEPTSTR = "deptstr";
	public static final String ALIAS_CTRCODE = "ctrcode";
	public static final String ALIAS_NATCODE = "natcode";
	public static final String ALIAS_SEX = "sex";
	public static final String ALIAS_BIRTHDAY = "birthday";
	public static final String ALIAS_INSCHOOL = "inschool";
	public static final String ALIAS_JOBCODE = "jobcode";
	public static final String ALIAS_RECTYPE = "rectype";
	public static final String ALIAS_GRADE = "grade";
	public static final String ALIAS_IDSERIAL1 = "idserial1";
	public static final String ALIAS_OTHERSTR = "otherstr";
	public static final String ALIAS_READ_FLAG = "readFlag";
	public static final String ALIAS_DEAL_FLAG = "dealFlag";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer idnumber;
	private java.lang.String messageType;
	private java.lang.String cardno;
	private java.lang.String cardid;
	private java.lang.String oldcardno;
	private java.lang.String oldcardid;
	private java.lang.String cdtype;
	private java.lang.String username;
	private java.lang.String idtype;
	private java.lang.String idserial;
	private java.lang.String pid;
	private java.lang.String deptstr;
	private java.lang.String ctrcode;
	private java.lang.String natcode;
	private java.lang.String sex;
	private java.lang.String birthday;
	private java.lang.String inschool;
	private java.lang.String jobcode;
	private java.lang.String rectype;
	private java.lang.String grade;
	private java.lang.String idserial1;
	private java.lang.String otherstr;
	private java.lang.String readFlag;
	private java.lang.String dealFlag;
	private java.lang.String remark;
	private Date updatedate;
	private String updatedateString;
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	///columns END

	public UserInforMessage(){
	}

	public UserInforMessage(
		java.lang.Integer idnumber
	){
		this.idnumber = idnumber;
	}

	
	
	public String getUpdatedateString() {
		return 
				 DateConvertUtils.format(getUpdatedate(), FORMAT_DATE);
	}

	public void setUpdatedateString(String updatedateString) {

		setUpdatedate (DateConvertUtils.parse(updatedateString, FORMAT_DATE,java.util.Date.class));
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public void setIdnumber(java.lang.Integer value)
    {
		this.idnumber = value;
	}
	
	public java.lang.Integer getIdnumber()
    {
		return this.idnumber;
	}
	public void setMessageType(java.lang.String value)
    {
		this.messageType = value;
	}
	
	public java.lang.String getMessageType()
    {
		return this.messageType;
	}
	public void setCardno(java.lang.String value)
    {
		this.cardno = value;
	}
	
	public java.lang.String getCardno()
    {
		return this.cardno;
	}
	public void setCardid(java.lang.String value)
    {
		this.cardid = value;
	}
	
	public java.lang.String getCardid()
    {
		return this.cardid;
	}
	public void setOldcardno(java.lang.String value)
    {
		this.oldcardno = value;
	}
	
	public java.lang.String getOldcardno()
    {
		return this.oldcardno;
	}
	public void setOldcardid(java.lang.String value)
    {
		this.oldcardid = value;
	}
	
	public java.lang.String getOldcardid()
    {
		return this.oldcardid;
	}
	public void setCdtype(java.lang.String value)
    {
		this.cdtype = value;
	}
	
	public java.lang.String getCdtype()
    {
		return this.cdtype;
	}
	public void setUsername(java.lang.String value)
    {
		this.username = value;
	}
	
	public java.lang.String getUsername()
    {
		return this.username;
	}
	public void setIdtype(java.lang.String value)
    {
		this.idtype = value;
	}
	
	public java.lang.String getIdtype()
    {
		return this.idtype;
	}
	public void setIdserial(java.lang.String value)
    {
		this.idserial = value;
	}
	
	public java.lang.String getIdserial()
    {
		return this.idserial;
	}
	public void setPid(java.lang.String value)
    {
		this.pid = value;
	}
	
	public java.lang.String getPid()
    {
		return this.pid;
	}
	public void setDeptstr(java.lang.String value)
    {
		this.deptstr = value;
	}
	
	public java.lang.String getDeptstr()
    {
		return this.deptstr;
	}
	public void setCtrcode(java.lang.String value)
    {
		this.ctrcode = value;
	}
	
	public java.lang.String getCtrcode()
    {
		return this.ctrcode;
	}
	public void setNatcode(java.lang.String value)
    {
		this.natcode = value;
	}
	
	public java.lang.String getNatcode()
    {
		return this.natcode;
	}
	public void setSex(java.lang.String value)
    {
		this.sex = value;
	}
	
	public java.lang.String getSex()
    {
		return this.sex;
	}
	public void setBirthday(java.lang.String value)
    {
		this.birthday = value;
	}
	
	public java.lang.String getBirthday()
    {
		return this.birthday;
	}
	public void setInschool(java.lang.String value)
    {
		this.inschool = value;
	}
	
	public java.lang.String getInschool()
    {
		return this.inschool;
	}
	public void setJobcode(java.lang.String value)
    {
		this.jobcode = value;
	}
	
	public java.lang.String getJobcode()
    {
		return this.jobcode;
	}
	public void setRectype(java.lang.String value)
    {
		this.rectype = value;
	}
	
	public java.lang.String getRectype()
    {
		return this.rectype;
	}
	public void setGrade(java.lang.String value)
    {
		this.grade = value;
	}
	
	public java.lang.String getGrade()
    {
		return this.grade;
	}
	public void setIdserial1(java.lang.String value)
    {
		this.idserial1 = value;
	}
	
	public java.lang.String getIdserial1()
    {
		return this.idserial1;
	}
	public void setOtherstr(java.lang.String value)
    {
		this.otherstr = value;
	}
	
	public java.lang.String getOtherstr()
    {
		return this.otherstr;
	}
	public void setReadFlag(java.lang.String value)
    {
		this.readFlag = value;
	}
	
	public java.lang.String getReadFlag()
    {
		return this.readFlag;
	}
	public void setDealFlag(java.lang.String value)
    {
		this.dealFlag = value;
	}
	
	public java.lang.String getDealFlag()
    {
		return this.dealFlag;
	}

    /**
     * @brief   功能: 将UserInforMessage对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Idnumber",getIdnumber())
			.append("MessageType",getMessageType())
			.append("Cardno",getCardno())
			.append("Cardid",getCardid())
			.append("Oldcardno",getOldcardno())
			.append("Oldcardid",getOldcardid())
			.append("Cdtype",getCdtype())
			.append("Username",getUsername())
			.append("Idtype",getIdtype())
			.append("Idserial",getIdserial())
			.append("Pid",getPid())
			.append("Deptstr",getDeptstr())
			.append("Ctrcode",getCtrcode())
			.append("Natcode",getNatcode())
			.append("Sex",getSex())
			.append("Birthday",getBirthday())
			.append("Inschool",getInschool())
			.append("Jobcode",getJobcode())
			.append("Rectype",getRectype())
			.append("Grade",getGrade())
			.append("Idserial1",getIdserial1())
			.append("Otherstr",getOtherstr())
			.append("ReadFlag",getReadFlag())
			.append("DealFlag",getDealFlag())
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
			.append(getIdnumber())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个UserInforMessage对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof UserInforMessage == false) return false;
		if(this == obj) return true;
		UserInforMessage other = (UserInforMessage)obj;
		return new EqualsBuilder()
			.append(getIdnumber(),other.getIdnumber())
			.isEquals();
	}
}

