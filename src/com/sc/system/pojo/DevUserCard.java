package com.sc.system.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;

/**
 * @ingroup system
 * @author  
 * @brief   类简单描述
 *
 * 类功能详细描述
 */
public class DevUserCard extends CubeBaseEntity implements java.io.Serializable,Cloneable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "DevUserCard";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_CARD_NUM = "cardNum";
	
	///date formats
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.Integer userId;
	private java.lang.String cardNum;
	private String type;
	
	private String flag;
	private String bm;
	private String kh;
	private String gh;
	private String mc;
	private String zt;
	private String flagStr;
	private String snStr;
	
	///columns END

	public String getSnStr() {
		return snStr;
	}

	public void setSnStr(String snStr) {
		this.snStr = snStr;
	}

	public DevUserCard(){
	}

	public DevUserCard(
		java.lang.Integer sn
	){
		this.sn = sn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
		if("1".equals(flag)){
			this.setFlagStr("<font color=''>正常</font>");
		}else if("0".equals(flag)){
			this.setFlagStr("<font color='red'>已挂失</font>");
		}
	}

	public String getFlagStr() {
		return flagStr;
	}

	public void setFlagStr(String flagStr) {
		this.flagStr = flagStr;
	}

	public void setSn(java.lang.Integer value)
    {
		this.sn = value;
		super.idStr = String.valueOf(value);
		if(value!=null)
		this.setSnStr(value.toString());
	}
	
	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getKh() {
		return kh;
	}

	public void setKh(String kh) {
		this.kh = kh;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public java.lang.Integer getSn()
    {
		return this.sn;
	}
	public void setUserId(java.lang.Integer value)
    {
		this.userId = value;
	}
	
	public java.lang.Integer getUserId()
    {
		return this.userId;
	}
	public void setCardNum(java.lang.String value)
    {
		this.cardNum = value;
	}
	
	public java.lang.String getCardNum()
    {
		return this.cardNum;
	}

    /**
     * @brief   功能: 将DevUserCard对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("UserId",getUserId())
			.append("CardNum",getCardNum())
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
     * @brief   功能: 检测两个DevUserCard对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof DevUserCard == false) return false;
		if(this == obj) return true;
		DevUserCard other = (DevUserCard)obj;
		return new EqualsBuilder()
			.append(getSn(),other.getSn())
			.isEquals();
	}
}

