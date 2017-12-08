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
public class ProductService  extends CubeBaseEntity implements java.io.Serializable,Cloneable 
{
	private static final long serialVersionUID = 5454155825314635342L; 
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String productName;
	private java.lang.Integer type;
	private java.lang.Integer quantity;
	private java.lang.Integer timeLimit;
	private Long currentPrice;
	private Long historyPrice;
	private java.lang.String unit;
	private java.lang.String operateGuide;
	private java.lang.String functionTrait;
	private java.util.Date date;
	///columns END

	public ProductService(){
	}

	public ProductService(
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
	public void setProductName(java.lang.String value)
    {
		this.productName = value;
	}
	
	public java.lang.String getProductName()
    {
		return this.productName;
	}
	public void setType(java.lang.Integer value)
    {
		this.type = value;
	}
	
	public java.lang.Integer getType()
    {
		return this.type;
	}
	public void setQuantity(java.lang.Integer value)
    {
		this.quantity = value;
	}
	
	public java.lang.Integer getQuantity()
    {
		return this.quantity;
	}
	public void setTimeLimit(java.lang.Integer value)
    {
		this.timeLimit = value;
	}
	
	public java.lang.Integer getTimeLimit()
    {
		return this.timeLimit;
	}
	public void setCurrentPrice(Long value)
    {
		this.currentPrice = value;
	}
	
	public Long getCurrentPrice()
    {
		return this.currentPrice;
	}
	public void setHistoryPrice(Long value)
    {
		this.historyPrice = value;
	}
	
	public Long getHistoryPrice()
    {
		return this.historyPrice;
	}
	public void setUnit(java.lang.String value)
    {
		this.unit = value;
	}
	
	public java.lang.String getUnit()
    {
		return this.unit;
	}
	public void setOperateGuide(java.lang.String value)
    {
		this.operateGuide = value;
	}
	
	public java.lang.String getOperateGuide()
    {
		return this.operateGuide;
	}
	public void setFunctionTrait(java.lang.String value)
    {
		this.functionTrait = value;
	}
	
	public java.lang.String getFunctionTrait()
    {
		return this.functionTrait;
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
     * @brief   功能: 将ProductService对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("ProductName",getProductName())
			.append("Type",getType())
			.append("Quantity",getQuantity())
			.append("TimeLimit",getTimeLimit())
			.append("CurrentPrice",getCurrentPrice())
			.append("HistoryPrice",getHistoryPrice())
			.append("Unit",getUnit())
			.append("OperateGuide",getOperateGuide())
			.append("FunctionTrait",getFunctionTrait())
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
     * @brief   功能: 检测两个ProductService对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof ProductService == false) return false;
		if(this == obj) return true;
		ProductService other = (ProductService)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

