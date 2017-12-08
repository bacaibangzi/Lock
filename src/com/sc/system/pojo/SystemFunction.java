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
public class SystemFunction implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "SystemFunction";
	public static final String ALIAS_FI_ID = "功能";
	public static final String ALIAS_FI_NAME = "功能名称";
	public static final String ALIAS_FI_PIC = "功能图片";
	public static final String ALIAS_FI_MEMO = "功能描述";
	public static final String ALIAS_FI_INDEX = "功能排序";

	// /date formats

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Integer fiId;
	private java.lang.String fiName;
	private java.lang.String fiPic;
	private java.lang.String fiMemo;
	private java.lang.Integer fiIndex;

	// /columns END

	public SystemFunction() {
	}

	public SystemFunction(java.lang.Integer fiId) {
		this.fiId = fiId;
	}

	public void setFiId(java.lang.Integer value) {
		this.fiId = value;
	}

	public java.lang.Integer getFiId() {
		return this.fiId;
	}

	public void setFiName(java.lang.String value) {
		this.fiName = value;
	}

	public java.lang.String getFiName() {
		return this.fiName;
	}

	public void setFiPic(java.lang.String value) {
		this.fiPic = value;
	}

	public java.lang.String getFiPic() {
		return this.fiPic;
	}

	public void setFiMemo(java.lang.String value) {
		this.fiMemo = value;
	}

	public java.lang.String getFiMemo() {
		return this.fiMemo;
	}

	public void setFiIndex(java.lang.Integer value) {
		this.fiIndex = value;
	}

	public java.lang.Integer getFiIndex() {
		return this.fiIndex;
	}

	/**
	 * @brief 功能: 将SystemFunction对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("FiId", getFiId()).append("FiName", getFiName())
				.append("FiPic", getFiPic()).append("FiMemo", getFiMemo())
				.append("FiIndex", getFiIndex()).toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getFiId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个SystemFunction对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof SystemFunction == false)
			return false;
		if (this == obj)
			return true;
		SystemFunction other = (SystemFunction) obj;
		return new EqualsBuilder().append(getFiId(), other.getFiId())
				.isEquals();
	}
}
