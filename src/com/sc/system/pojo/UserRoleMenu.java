package com.sc.system.pojo;

import java.util.LinkedList;

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
public class UserRoleMenu implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "UserRoleMenu";
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
	private Long uiId;
	// 默认功能引导页面
	private UserRoleMenu indexMenu;

	private LinkedList<UserRoleMenu> leftMenus = new LinkedList<UserRoleMenu>();
	// /columns END

	public UserRoleMenu() {
	}

	public void setMiId(java.lang.Long value) {
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

	public UserRoleMenu getIndexMenu() {
		return indexMenu;
	}

	public void setIndexMenu(UserRoleMenu indexMenu) {
		this.indexMenu = indexMenu;
	}

	public Long getUiId() {
		return uiId;
	}

	public void setUiId(Long uiId) {
		this.uiId = uiId;
	}

	public LinkedList<UserRoleMenu> getLeftMenus() {
		return leftMenus;
	}

	public void setLeftMenus(LinkedList<UserRoleMenu> leftMenus) {
		this.leftMenus = leftMenus;
	}

	/**
	 * @brief 功能: 将UserRoleMenu对象数据进行串化
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
		return new HashCodeBuilder().toHashCode();
	}

	/**
	 * @brief 功能: 检测两个UserRoleMenu对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof UserRoleMenu == false)
			return false;
		if (this == obj)
			return true;
		UserRoleMenu other = (UserRoleMenu) obj;
		return new EqualsBuilder().isEquals();
	}
}
