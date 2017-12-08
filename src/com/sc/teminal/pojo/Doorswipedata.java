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
public class Doorswipedata implements java.io.Serializable
{
	private static final long serialVersionUID = 5454155825314635342L;
	 
	
	///date formats
	public static final String FORMAT_SWIPE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_GATHER_TIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer id;
	private java.lang.Integer terminalId;
	private java.lang.Integer terminalCode;
	private java.lang.String cardNo;
	private Integer swipeType;
	private String swipeTypeStr;
	private java.lang.Integer tradeSerialNo;
	private java.util.Date swipeTime;
	private java.util.Date gatherTime;
	
	private java.lang.String uiName;
	private java.lang.String uiNum;
	private java.lang.String type;
	
	private String doorname;
	
	///columns END

	public Doorswipedata(){
	}

	public Doorswipedata(
		java.lang.Integer id
	){
		this.id = id;
	}

	public String getDoorname() {
		return doorname;
	}

	public void setDoorname(String doorname) {
		this.doorname = doorname;
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
	public void setSwipeType(Integer value)
    {
		this.swipeType = value;
		
		switch(value){
			case 1:
				this.swipeTypeStr = "正常刷卡";
			break;
			case 2:
				this.swipeTypeStr = "非法卡";
			break;
			case 3:
				this.swipeTypeStr = "钥匙开门";
			break;
			case 4:
				this.swipeTypeStr = "远程开门";
			break;
			case 5:
				this.swipeTypeStr = "远程常开";
			break;
			case 6:
				this.swipeTypeStr = "远程闭门";
			break;
			case 7:
				this.swipeTypeStr = "反锁";
			break;
			case 8:
				this.swipeTypeStr = "非反锁";
			break;
			case 9:
				this.swipeTypeStr = "闭门";
			break;
			case 10:
				this.swipeTypeStr = "假锁";
			break;
			case 11:
				this.swipeTypeStr = "卡格式错误";
			break;
			case 12:
				this.swipeTypeStr = "授权卡";
			break;
			case 13:
				this.swipeTypeStr = "名单卡";
			break;
			case 252:
				this.swipeTypeStr = "配置卡";
			break;
		
			default:
				break;
		}
		
	}
	
	public Integer getSwipeType()
    {
		return this.swipeType;
	}
	public void setTradeSerialNo(java.lang.Integer value)
    {
		this.tradeSerialNo = value;
	}
	
	public java.lang.Integer getTradeSerialNo()
    {
		return this.tradeSerialNo;
	}
	public String getSwipeTimeString()
    {
		return DateConvertUtils.format(getSwipeTime(), FORMAT_SWIPE_TIME);
	}
	public void setSwipeTimeString(String value)
    {
		setSwipeTime(DateConvertUtils.parse(value, FORMAT_SWIPE_TIME,java.util.Date.class));
	}
	
	public void setSwipeTime(java.util.Date value)
    {
		this.swipeTime = value;
	}
	
	public java.util.Date getSwipeTime()
    {
		return this.swipeTime;
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

    public java.lang.String getUiName() {
		return uiName;
	}

	public void setUiName(java.lang.String uiName) {
		this.uiName = uiName;
	}

	public java.lang.String getUiNum() {
		return uiNum;
	}

	public void setUiNum(java.lang.String uiNum) {
		this.uiNum = uiNum;
	}

	public java.lang.String getType() {
		return type;
	}

	public void setType(java.lang.String type) {
		this.type = type;
	}

	public String getSwipeTypeStr() {
		return swipeTypeStr;
	}

	public void setSwipeTypeStr(String swipeTypeStr) {
		this.swipeTypeStr = swipeTypeStr;
	}

	/**
     * @brief   功能: 将Doorswipedata对象数据进行串化
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
			.append("SwipeType",getSwipeType())
			.append("TradeSerialNo",getTradeSerialNo())
			.append("SwipeTime",getSwipeTime())
			.append("GatherTime",getGatherTime())
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
     * @brief   功能: 检测两个Doorswipedata对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Doorswipedata == false) return false;
		if(this == obj) return true;
		Doorswipedata other = (Doorswipedata)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

