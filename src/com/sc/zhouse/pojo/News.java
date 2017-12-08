package com.sc.zhouse.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;
import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class News extends CubeBaseEntity implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "News";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_TITLE = "title";
	public static final String ALIAS_TITLE_IMG = "titleImg";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_USER_NAME = "userName";
	public static final String ALIAS_TYPE = "ç±»åž‹";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_DATE = "date";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String title;
	private java.lang.String titleImg;
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.Integer type;
	private java.lang.String content;
	private java.util.Date date;
	private Integer shenHe;
	private String zhaiYao;
	///columns END

	public News(){
	}

	public News(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public String getZhaiYao() {
		return zhaiYao;
	}

	public void setZhaiYao(String zhaiYao) {
		this.zhaiYao = zhaiYao;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = String.valueOf(value);
	}
	
	public Integer getShenHe() {
		return shenHe;
	}

	public void setShenHe(Integer shenHe) {
		this.shenHe = shenHe;
	}

	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setTitle(java.lang.String value)
    {
		this.title = value;
	}
	
	public java.lang.String getTitle()
    {
		return this.title;
	}
	public void setTitleImg(java.lang.String value)
    {
		this.titleImg = value;
	}
	
	public java.lang.String getTitleImg()
    {
		return this.titleImg;
	}
	public void setUserId(java.lang.Integer value)
    {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId()
    {
		return this.userId;
	}
	public void setUserName(java.lang.String value)
    {
		this.userName = value;
	}
	
	public java.lang.String getUserName()
    {
		return this.userName;
	}
	public void setType(java.lang.Integer value)
    {
		this.type = value;
	}
	
	public java.lang.Integer getType()
    {
		return this.type;
	}
	public void setContent(java.lang.String value)
    {
		this.content = value;
	}
	
	public java.lang.String getContent()
    {
		return this.content;
	}
	public String getDateString()
    {
		return DateConvertUtils.format(getDate(), FORMAT_DATE);
	}
	public void setDateString(String value)
    {
		setDate(DateConvertUtils.parse(value, FORMAT_DATE,java.util.Date.class));
	}
	
	public void setDate(java.util.Date value)
    {
		this.date = value;
	}
	
	public java.util.Date getDate()
    {
		return this.date;
	}

    /**
     * @brief   功能: 将News对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Title",getTitle())
			.append("TitleImg",getTitleImg())
			.append("UserId",getUserId())
			.append("UserName",getUserName())
			.append("Type",getType())
			.append("Content",getContent())
			.append("Date",getDate())
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
     * @brief   功能: 检测两个News对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof News == false) return false;
		if(this == obj) return true;
		News other = (News)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

