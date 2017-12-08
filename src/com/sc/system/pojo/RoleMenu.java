package com.sc.system.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @ingroup system
 * @author
 * @brief 类简单描述
 * 
 *        类功能详细描述
 */
public class RoleMenu implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "RoleMenu";
	public static final String ALIAS_RM_ID = "è§’è‰²åŠŸèƒ½ID";
	public static final String ALIAS_RI_ID = "è§’è‰²ID";
	public static final String ALIAS_MI_ID = "åŠŸèƒ½ID";
	public static final String ALIAS_RM_MEMO = "è§’è‰²åŠŸèƒ½è¯´æ˜Ž";

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long rmId;
	private java.lang.Long riId;
	private java.lang.Long miId;
	private java.lang.String rmMemo;
	private String orgCode;

	// /columns END

	public RoleMenu() {
	}

	public RoleMenu(java.lang.Long rmId) {
		this.rmId = rmId;
	}

	public void setRmId(java.lang.Long value) {
		this.rmId = value;
	}

	public java.lang.Long getRmId() {
		return this.rmId;
	}

	public void setRiId(java.lang.Long value) {
		this.riId = value;
	}

	public java.lang.Long getRiId() {
		return this.riId;
	}

	public void setMiId(java.lang.Long value) {
		this.miId = value;
	}

	public java.lang.Long getMiId() {
		return this.miId;
	}

	public void setRmMemo(java.lang.String value) {
		this.rmMemo = value;
	}

	public java.lang.String getRmMemo() {
		return this.rmMemo;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @brief 功能: 将RoleMenu对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("RmId", getRmId()).append("RiId", getRiId()).append(
						"MiId", getMiId()).append("RmMemo", getRmMemo())
				.toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getRmId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个RoleMenu对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof RoleMenu == false)
			return false;
		if (this == obj)
			return true;
		RoleMenu other = (RoleMenu) obj;
		return new EqualsBuilder().append(getRmId(), other.getRmId())
				.isEquals();
	}
}
