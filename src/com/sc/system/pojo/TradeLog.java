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
public class TradeLog  extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L; 
	
	///date formats
	public static final String FORMAT_TRADE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer productSn;
	private Long productPrice;
	private java.lang.Integer tradeUser;
	private java.util.Date tradeTime;
	private java.lang.String orgCode;
	private java.lang.Integer tradeState;
	private java.lang.String tradeNote;
	private java.util.Date date;
	///columns END

	public TradeLog(){
	}

	public TradeLog(
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
	public void setProductSn(java.lang.Integer value)
    {
		this.productSn = value;
	}
	
	public java.lang.Integer getProductSn()
    {
		return this.productSn;
	}
	public void setProductPrice(Long value)
    {
		this.productPrice = value;
	}
	
	public Long getProductPrice()
    {
		return this.productPrice;
	}
	public void setTradeUser(java.lang.Integer value)
    {
		this.tradeUser = value;
	}
	
	public java.lang.Integer getTradeUser()
    {
		return this.tradeUser;
	}
	public String getTradeTimeString()
    {
		return DateConvertUtils.format(getTradeTime(), FORMAT_TRADE_TIME);
	}
	public void setTradeTimeString(String value)
    {
		setTradeTime(DateConvertUtils.parse(value, FORMAT_TRADE_TIME,java.util.Date.class));
	}
	
	public void setTradeTime(java.util.Date value)
    {
		this.tradeTime = value;
	}
	
	public java.util.Date getTradeTime()
    {
		return this.tradeTime;
	}
	public void setOrgCode(java.lang.String value)
    {
		this.orgCode = value;
	}
	
	public java.lang.String getOrgCode()
    {
		return this.orgCode;
	}
	public void setTradeState(java.lang.Integer value)
    {
		this.tradeState = value;
	}
	
	public java.lang.Integer getTradeState()
    {
		return this.tradeState;
	}
	public void setTradeNote(java.lang.String value)
    {
		this.tradeNote = value;
	}
	
	public java.lang.String getTradeNote()
    {
		return this.tradeNote;
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
     * @brief   功能: 将TradeLog对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("ProductSn",getProductSn())
			.append("ProductPrice",getProductPrice())
			.append("TradeUser",getTradeUser())
			.append("TradeTime",getTradeTime())
			.append("OrgCode",getOrgCode())
			.append("TradeState",getTradeState())
			.append("TradeNote",getTradeNote())
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
     * @brief   功能: 检测两个TradeLog对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof TradeLog == false) return false;
		if(this == obj) return true;
		TradeLog other = (TradeLog)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

