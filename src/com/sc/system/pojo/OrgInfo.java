package com.sc.system.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;

/**
 * @ingroup system
 * @author
 * @brief 类简单描述
 * 
 *        类功能详细描述
 */
public class OrgInfo extends CubeBaseEntity implements java.io.Serializable,Cloneable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long oiId;
	private String oiCode;
	private String oiName;
	private String oiMemo;
	private String oiType;
	private String areaCode;
	private String areaName;
	private String printContext;

	public static final String FORMAT_DQ_DATE = "yyyy-MM-dd HH:mm:ss";

	// /columns END

	public OrgInfo() {
	}
 

	public OrgInfo(java.lang.Long oiId) {
		this.oiId = oiId;
	}

	public void setOiId(java.lang.Long value) {
		super.idStr = String.valueOf(value);
		this.oiId = value;
	}
 
	public String getPrintContext() {
		return printContext;
	}


	public void setPrintContext(String printContext) {
		this.printContext = printContext;
	}


	public java.lang.Long getOiId() {
		return this.oiId;
	}

	public void setOiCode(String value) {
		this.oiCode = value;
	}

	public String getOiCode() {
		return this.oiCode;
	}

	public void setOiName(String value) {
		this.oiName = value;
	}

	public String getOiName() {
		return this.oiName;
	}

	public void setOiMemo(String value) {
		this.oiMemo = value;
	}

	public String getOiMemo() {
		return this.oiMemo;
	}

	public String getOiType() {
		return oiType;
	}

	public void setOiType(String oiType) {
		this.oiType = oiType;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	
	/**
	 * @brief 功能: 将OrgInfo对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("OiId", getOiId()).append("OiCode", getOiCode())
				.append("OiName", getOiName()).append("OiMemo", getOiMemo())
				.toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getOiId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个OrgInfo对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof OrgInfo == false)
			return false;
		if (this == obj)
			return true;
		OrgInfo other = (OrgInfo) obj;
		return new EqualsBuilder().append(getOiId(), other.getOiId())
				.isEquals();
	}
}
