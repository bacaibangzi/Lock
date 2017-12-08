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
public class AreaInfo extends CubeBaseEntity implements java.io.Serializable,Cloneable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "AreaInfo";
	public static final String ALIAS_AREA_ID = "areaId";
	public static final String ALIAS_AREA_CODE = "areaCode";
	public static final String ALIAS_AREA_NAME = "areaName";
	public static final String ALIAS_AREA_MEMO = "areaMemo";

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long areaId;
	private java.lang.String areaCode;
	private java.lang.String areaName;
	private java.lang.String areaMemo;
	private String areaParentCode;
	private String lon;
	private String lat;
	private String qy;

	// /columns END

	public AreaInfo() {
	}

	public AreaInfo(java.lang.Long areaId) {
		this.areaId = areaId;
	}

	public void setAreaId(java.lang.Long value) {
		super.idStr = String.valueOf(value);
		this.areaId = value;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}

	public java.lang.Long getAreaId() {
		return this.areaId;
	}

	public void setAreaCode(java.lang.String value) {
		this.areaCode = value;
	}

	public java.lang.String getAreaCode() {
		return this.areaCode;
	}

	public void setAreaName(java.lang.String value) {
		this.areaName = value;
	}

	public java.lang.String getAreaName() {
		return this.areaName;
	}

	public void setAreaMemo(java.lang.String value) {
		this.areaMemo = value;
	}

	public java.lang.String getAreaMemo() {
		return this.areaMemo;
	}

	public String getAreaParentCode() {
		return areaParentCode;
	}

	public void setAreaParentCode(String areaParentCode) {
		this.areaParentCode = areaParentCode;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	/**
	 * @brief 功能: 将AreaInfo对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("AreaId", getAreaId())
				.append("AreaCode", getAreaCode()).append("AreaName",
						getAreaName()).append("AreaMemo", getAreaMemo())
				.toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getAreaId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个AreaInfo对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof AreaInfo == false)
			return false;
		if (this == obj)
			return true;
		AreaInfo other = (AreaInfo) obj;
		return new EqualsBuilder().append(getAreaId(), other.getAreaId())
				.isEquals();
	}
}
