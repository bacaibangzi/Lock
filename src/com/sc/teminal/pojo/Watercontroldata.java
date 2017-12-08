package com.sc.teminal.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class Watercontroldata implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_CONSUMPTION_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_GATHER_TIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer id;
	private java.lang.Integer terminalId;
	private java.lang.Integer terminalCode;
	private java.lang.String cardNo;
	private java.lang.Integer mainBalance;
	private java.lang.Integer expenditure;
	private java.lang.Integer newBalance;
	private java.lang.Integer waterAmount;
	private java.lang.Integer surplusAmount;
	private java.lang.Integer pulseFlag;
	private java.lang.Integer cardSerialNo;
	private java.lang.Integer tradeSerialNo;
	private java.util.Date consumptionTime;
	private java.util.Date gatherTime;
	private java.lang.Integer chargingType;
	private java.lang.Integer succeedFlag;
	///columns END

	public Watercontroldata(){
	}

	public Watercontroldata(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer value)
    {
		this.id = value;
	}
	
	public java.lang.Integer getId()
    {
		return this.id;
	}
	public void setTerminalId(java.lang.Integer value)
    {
		this.terminalId = value;
	}
	
	public java.lang.Integer getTerminalId()
    {
		return this.terminalId;
	}
	public void setTerminalCode(java.lang.Integer value)
    {
		this.terminalCode = value;
	}
	
	public java.lang.Integer getTerminalCode()
    {
		return this.terminalCode;
	}
	public void setCardNo(java.lang.String value)
    {
		this.cardNo = value;
	}
	
	public java.lang.String getCardNo()
    {
		return this.cardNo;
	}
	public void setMainBalance(java.lang.Integer value)
    {
		this.mainBalance = value;
	}
	
	public java.lang.Integer getMainBalance()
    {
		return this.mainBalance;
	}
	public void setExpenditure(java.lang.Integer value)
    {
		this.expenditure = value;
	}
	
	public java.lang.Integer getExpenditure()
    {
		return this.expenditure;
	}
	public void setNewBalance(java.lang.Integer value)
    {
		this.newBalance = value;
	}
	
	public java.lang.Integer getNewBalance()
    {
		return this.newBalance;
	}
	public void setWaterAmount(java.lang.Integer value)
    {
		this.waterAmount = value;
	}
	
	public java.lang.Integer getWaterAmount()
    {
		return this.waterAmount;
	}
	public void setSurplusAmount(java.lang.Integer value)
    {
		this.surplusAmount = value;
	}
	
	public java.lang.Integer getSurplusAmount()
    {
		return this.surplusAmount;
	}
	public void setPulseFlag(java.lang.Integer value)
    {
		this.pulseFlag = value;
	}
	
	public java.lang.Integer getPulseFlag()
    {
		return this.pulseFlag;
	}
	public void setCardSerialNo(java.lang.Integer value)
    {
		this.cardSerialNo = value;
	}
	
	public java.lang.Integer getCardSerialNo()
    {
		return this.cardSerialNo;
	}
	public void setTradeSerialNo(java.lang.Integer value)
    {
		this.tradeSerialNo = value;
	}
	
	public java.lang.Integer getTradeSerialNo()
    {
		return this.tradeSerialNo;
	}
	public String getConsumptionTimeString()
    {
		return DateConvertUtils.format(getConsumptionTime(), FORMAT_CONSUMPTION_TIME);
	}
	public void setConsumptionTimeString(String value)
    {
		setConsumptionTime(DateConvertUtils.parse(value, FORMAT_CONSUMPTION_TIME,java.util.Date.class));
	}
	
	public void setConsumptionTime(java.util.Date value)
    {
		this.consumptionTime = value;
	}
	
	public java.util.Date getConsumptionTime()
    {
		return this.consumptionTime;
	}
	public String getGatherTimeString()
    {
		return DateConvertUtils.format(getGatherTime(), FORMAT_GATHER_TIME);
	}
	public void setGatherTimeString(String value)
    {
		setGatherTime(DateConvertUtils.parse(value, FORMAT_GATHER_TIME,java.util.Date.class));
	}
	
	public void setGatherTime(java.util.Date value)
    {
		this.gatherTime = value;
	}
	
	public java.util.Date getGatherTime()
    {
		return this.gatherTime;
	}
	public void setChargingType(java.lang.Integer value)
    {
		this.chargingType = value;
	}
	
	public java.lang.Integer getChargingType()
    {
		return this.chargingType;
	}
	public void setSucceedFlag(java.lang.Integer value)
    {
		this.succeedFlag = value;
	}
	
	public java.lang.Integer getSucceedFlag()
    {
		return this.succeedFlag;
	}

    /**
     * @brief   功能: 将Watercontroldata对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("TerminalId",getTerminalId())
			.append("TerminalCode",getTerminalCode())
			.append("CardNo",getCardNo())
			.append("MainBalance",getMainBalance())
			.append("Expenditure",getExpenditure())
			.append("NewBalance",getNewBalance())
			.append("WaterAmount",getWaterAmount())
			.append("SurplusAmount",getSurplusAmount())
			.append("PulseFlag",getPulseFlag())
			.append("CardSerialNo",getCardSerialNo())
			.append("TradeSerialNo",getTradeSerialNo())
			.append("ConsumptionTime",getConsumptionTime())
			.append("GatherTime",getGatherTime())
			.append("ChargingType",getChargingType())
			.append("SucceedFlag",getSucceedFlag())
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
			.append(getId())
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Watercontroldata对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Watercontroldata == false) return false;
		if(this == obj) return true;
		Watercontroldata other = (Watercontroldata)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

