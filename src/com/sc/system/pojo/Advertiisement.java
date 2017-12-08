package com.sc.system.pojo;

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
public class Advertiisement  extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "Advertiisement";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_IMG = "img";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_INDEX_S = "indexS";
	public static final String ALIAS_ORG_CODE = "orgCode";
	public static final String ALIAS_DATE = "date";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START     
	private java.lang.Integer sn;
	private java.lang.String img;
	private java.lang.String remark;
	private java.lang.Integer indexS;
	private java.lang.String orgCode;
	private java.util.Date date;
	private String imgstr;
	private int version;
	///columns END

	public Advertiisement(){
	}

	public Advertiisement(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		this.idStr = String.valueOf(value);
	}
	
	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setImg(java.lang.String value)
    {
		this.img = value;
	}
	
	public String getImgstr() {
		return imgstr;
	}

	public void setImgstr(String imgstr) {
		this.imgstr = imgstr;
	}

	public java.lang.String getImg()
    {
		return this.img;
	}
	public void setRemark(java.lang.String value)
    {
		this.remark = value;
	}
	
	public java.lang.String getRemark()
    {
		return this.remark;
	}
	public void setIndexS(java.lang.Integer value)
    {
		this.indexS = value;
	}
	
	public java.lang.Integer getIndexS()
    {
		return this.indexS;
	}
	public void setOrgCode(java.lang.String value)
    {
		this.orgCode = value;
	}
	
	public java.lang.String getOrgCode()
    {
		return this.orgCode;
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

    public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
     * @brief   功能: 将Advertiisement对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Img",getImg())
			.append("Remark",getRemark())
			.append("IndexS",getIndexS())
			.append("OrgCode",getOrgCode())
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
     * @brief   功能: 检测两个Advertiisement对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Advertiisement == false) return false;
		if(this == obj) return true;
		Advertiisement other = (Advertiisement)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

