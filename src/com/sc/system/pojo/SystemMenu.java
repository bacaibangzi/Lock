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
public class SystemMenu extends CubeBaseEntity implements java.io.Serializable ,Cloneable{
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "SystemMenu";
	public static final String ALIAS_MI_ID = "菜单ID";
	public static final String ALIAS_FI_ID = "功能ID";
	public static final String ALIAS_MI_NAME = "菜单名称";
	public static final String ALIAS_MI_URL = "菜单链接";
	public static final String ALIAS_MI_PIC = "菜单工作图片";
	public static final String ALIAS_MI_MEMO = "菜单备注";
	public static final String ALIAS_MI_INDEX = "菜单排序";
	public static final String ALIAS_MI_LEVEL = "菜单等级";

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long miId;
	private java.lang.Long fiId;
	private java.lang.String miName;
	private java.lang.String miUrl;
	private java.lang.String miPic;
	private java.lang.String miMemo;
	private java.lang.Integer miIndex;
	private java.lang.Integer miLevel;

	// /columns END

	public SystemMenu() {
	}

	public SystemMenu(java.lang.Long miId) {
		this.miId = miId;
	}

	public void setMiId(java.lang.Long value) {
		super.idStr = String.valueOf(value);
		this.miId = value;
	}

	public java.lang.Long getMiId() {
		return this.miId;
	}

	public void setFiId(java.lang.Long value) {
		this.fiId = value;
	}

	public java.lang.Long getFiId() {
		return this.fiId;
	}

	public void setMiName(java.lang.String value) {
		this.miName = value;
	}

	public java.lang.String getMiName() {
		return this.miName;
	}

	public void setMiUrl(java.lang.String value) {
		this.miUrl = value;
	}

	public java.lang.String getMiUrl() {
		return this.miUrl;
	}

	public void setMiPic(java.lang.String value) {
		this.miPic = value;
	}

	public java.lang.String getMiPic() {
		return this.miPic;
	}

	public void setMiMemo(java.lang.String value) {
		this.miMemo = value;
	}

	public java.lang.String getMiMemo() {
		return this.miMemo;
	}

	public void setMiIndex(java.lang.Integer value) {
		this.miIndex = value;
	}

	public java.lang.Integer getMiIndex() {
		return this.miIndex;
	}

	public void setMiLevel(java.lang.Integer value) {
		this.miLevel = value;
	}

	public java.lang.Integer getMiLevel() {
		return this.miLevel;
	}

	/**
	 * @brief 功能: 将SystemMenu对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("MiId", getMiId()).append("FiId", getFiId()).append(
						"MiName", getMiName()).append("MiUrl", getMiUrl())
				.append("MiPic", getMiPic()).append("MiMemo", getMiMemo())
				.append("MiIndex", getMiIndex())
				.append("MiLevel", getMiLevel()).toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getMiId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个SystemMenu对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof SystemMenu == false)
			return false;
		if (this == obj)
			return true;
		SystemMenu other = (SystemMenu) obj;
		return new EqualsBuilder().append(getMiId(), other.getMiId())
				.isEquals();
	}
}
