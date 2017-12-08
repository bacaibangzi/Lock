package com.sc.developer.pojo;

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
public class AppCost  extends CubeBaseEntity implements java.io.Serializable,Cloneable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "AppCost";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_APPID = "appid";
	public static final String ALIAS_USERID = "userid";
	public static final String ALIAS_APP_USER_ID = "appUserId";
	public static final String ALIAS_APP_USER_NAME = "appUserName";
	public static final String ALIAS_APP_USER_PHONE = "appUserPhone";
	public static final String ALIAS_APP_USER_REMARK = "appUserRemark";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_PRODUCT_NAME = "productName";
	public static final String ALIAS_PRODUCT_COST = "productCost";
	public static final String ALIAS_PRODUCT_REMARK = "productRemark";
	public static final String ALIAS_DATE = "date";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String appid;
	private java.lang.Integer userid;
	private java.lang.String appUserId;
	private java.lang.String appUserName;
	private java.lang.String appUserPhone;
	private java.lang.String appUserRemark;
	private java.lang.String productId;
	private java.lang.String productName;
	private Double productCost;
	private java.lang.String productRemark;
	private java.util.Date date;
	///columns END

	public AppCost(){
	}

	public AppCost(
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
	public void setAppid(java.lang.String value)
    {
		this.appid = value;
	}
	
	public java.lang.String getAppid()
    {
		return this.appid;
	}
	public void setUserid(java.lang.Integer value)
    {
		this.userid = value;
	}
	
	public java.lang.Integer getUserid()
    {
		return this.userid;
	}
	public void setAppUserId(java.lang.String value)
    {
		this.appUserId = value;
	}
	
	public java.lang.String getAppUserId()
    {
		return this.appUserId;
	}
	public void setAppUserName(java.lang.String value)
    {
		this.appUserName = value;
	}
	
	public java.lang.String getAppUserName()
    {
		return this.appUserName;
	}
	public void setAppUserPhone(java.lang.String value)
    {
		this.appUserPhone = value;
	}
	
	public java.lang.String getAppUserPhone()
    {
		return this.appUserPhone;
	}
	public void setAppUserRemark(java.lang.String value)
    {
		this.appUserRemark = value;
	}
	
	public java.lang.String getAppUserRemark()
    {
		return this.appUserRemark;
	}
	public void setProductId(java.lang.String value)
    {
		this.productId = value;
	}
	
	public java.lang.String getProductId()
    {
		return this.productId;
	}
	public void setProductName(java.lang.String value)
    {
		this.productName = value;
	}
	
	public java.lang.String getProductName()
    {
		return this.productName;
	}
	public void setProductCost(Double value)
    {
		this.productCost = value;
	}
	
	public Double getProductCost()
    {
		return this.productCost;
	}
	public void setProductRemark(java.lang.String value)
    {
		this.productRemark = value;
	}
	
	public java.lang.String getProductRemark()
    {
		return this.productRemark;
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
     * @brief   功能: 将AppCost对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Appid",getAppid())
			.append("Userid",getUserid())
			.append("AppUserId",getAppUserId())
			.append("AppUserName",getAppUserName())
			.append("AppUserPhone",getAppUserPhone())
			.append("AppUserRemark",getAppUserRemark())
			.append("ProductId",getProductId())
			.append("ProductName",getProductName())
			.append("ProductCost",getProductCost())
			.append("ProductRemark",getProductRemark())
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
     * @brief   功能: 检测两个AppCost对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof AppCost == false) return false;
		if(this == obj) return true;
		AppCost other = (AppCost)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

