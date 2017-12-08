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
public class RoleInfo extends CubeBaseEntity implements java.io.Serializable,Cloneable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long riId;
	private java.lang.String riName;
	private java.lang.String riMemo;
	private java.lang.Long riLevel;
	private java.lang.String orgCode;

	// /columns END

	public RoleInfo() {
	}

	public RoleInfo(java.lang.Long riId) {
		this.riId = riId;
	}

	public void setRiId(java.lang.Long value) {
		super.idStr = String.valueOf(value);
		this.riId = value;
	}

	public java.lang.Long getRiId() {
		return this.riId;
	}

	public void setRiName(java.lang.String value) {
		this.riName = value;
	}

	public java.lang.String getRiName() {
		return this.riName;
	}

	public void setRiMemo(java.lang.String value) {
		this.riMemo = value;
	}

	public java.lang.String getRiMemo() {
		return this.riMemo;
	}

	public void setRiLevel(java.lang.Long value) {
		this.riLevel = value;
	}

	public java.lang.Long getRiLevel() {
		return this.riLevel;
	}

	public void setOrgCode(java.lang.String value) {
		this.orgCode = value;
	}

	public java.lang.String getOrgCode() {
		return this.orgCode;
	}

	/**
	 * @brief 功能: 将RoleInfo对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RiId", getRiId()).append("RiName", getRiName())
				.append("RiMemo", getRiMemo()).append("RiLevel", getRiLevel())
				.append("OrgCode", getOrgCode()).toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getRiId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个RoleInfo对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof RoleInfo == false)
			return false;
		if (this == obj)
			return true;
		RoleInfo other = (RoleInfo) obj;
		return new EqualsBuilder().append(getRiId(), other.getRiId())
				.isEquals();
	}
}
