package com.sc.teminal.pojo;

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
public class VhuisYanc extends CubeBaseEntity implements java.io.Serializable,Cloneable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	///date formats
	public static final String FORMAT_EDITTIME = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.String uiName;
	private java.lang.String uiNum;
	private java.lang.String cardNum;
	private java.lang.String oiName;
	private java.util.Date edittime;
	private java.lang.String content;
	private java.lang.String terminalname;
	private java.lang.Integer namelistid;
	private String sjStr;
	private String type;
	private String updatetype;
	private String syncstate;
	

	private String updatetypeStr;
	private String syncstateStr;
	
	
	///columns END

	public java.lang.Integer getNamelistid() {
		return namelistid;
	}

	public String getType() {
		return type;
	}


	public String getSyncstate() {
		return syncstate;
	}

	public void setSyncstate(String syncstate) {
		this.syncstate = syncstate;
		if("1".equals(syncstate)){
			this.setSyncstateStr("正常");
		}else if("0".equals(syncstate)){
			this.setSyncstateStr("等待执行");
		}
	}

	public String getUpdatetype() {
		return updatetype;
	}

	public void setUpdatetype(String updatetype) {
		this.updatetype = updatetype;
		if("1".equals(updatetype)){
			this.setUpdatetypeStr("新增名单");
		}else if("2".equals(updatetype)){
			this.setUpdatetypeStr("覆盖名单");
		}else if("3".equals(updatetype)){
			this.setUpdatetypeStr("删除名单");
		}
	}

	public String getUpdatetypeStr() {
		return updatetypeStr;
	}

	public void setUpdatetypeStr(String updatetypeStr) {
		this.updatetypeStr = updatetypeStr;
	}

	public String getSyncstateStr() {
		return syncstateStr;
	}

	public void setSyncstateStr(String syncstateStr) {
		this.syncstateStr = syncstateStr;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getSjStr() {
		return sjStr;
	}


	public void setSjStr(String sjStr) {
		this.sjStr = sjStr;
	}


	public void setNamelistid(java.lang.Integer namelistid) {
		this.namelistid = namelistid;
		this.idStr = namelistid.toString();
	}


	public VhuisYanc(){
	}


	public void setUiName(java.lang.String value)
    {
		this.uiName = value;
	}
	
	public java.lang.String getUiName()
    {
		return this.uiName;
	}
	public void setUiNum(java.lang.String value)
    {
		this.uiNum = value;
	}
	
	public java.lang.String getUiNum() 
    {
		return this.uiNum;
	}
	public void setCardNum(java.lang.String value)
    {
		this.cardNum = value;
	}
	
	public java.lang.String getCardNum()
    {
		return this.cardNum;
	}
	public void setOiName(java.lang.String value)
    {
		this.oiName = value;
	}
	
	public java.lang.String getOiName()
    {
		return this.oiName;
	}
	public String getEdittimeString()
    {
		return DateConvertUtils.format(getEdittime(), FORMAT_EDITTIME);
	}
	public void setEdittimeString(String value)
    {
		setEdittime(DateConvertUtils.parse(value, FORMAT_EDITTIME,java.util.Date.class));
	}
	
	public void setEdittime(java.util.Date value)
    {
		this.edittime = value;
	}
	
	public java.util.Date getEdittime()
    {
		return this.edittime;
	}
	public void setContent(java.lang.String value)
    {
		this.content = value;
		// 解析时间
		//String sj = value.substring(8,18);//18040921
		//sj = "20"+sj.substring(0, 2)+"-"+sj.substring(2,4)+"-"+sj.substring(4,6)+" "+sj.substring(6,8)+":"+sj.substring(8);
		//this.setSjStr(sj);
		if(value.length()==32){
			String sj = value.substring(8,18);//18040921
			sj = "20"+sj.substring(0, 2)+"-"+sj.substring(2,4)+"-"+sj.substring(4,6)+" "+sj.substring(6,8)+":"+sj.substring(8);
			this.setSjStr(sj);
		}else{
			String sj = value.substring(36,46);//18040921
			sj = "20"+sj.substring(0, 2)+"-"+sj.substring(2,4)+"-"+sj.substring(4,6)+" "+sj.substring(6,8)+":"+sj.substring(8);
			this.setSjStr(sj);
		}
	}
	
	public java.lang.String getContent()
    {
		return this.content;
	}
	public void setTerminalname(java.lang.String value)
    {
		this.terminalname = value;
	}
	
	public java.lang.String getTerminalname()
    {
		return this.terminalname;
	}

    /**
     * @brief   功能: 将VhuisYanc对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("UiName",getUiName())
			.append("UiNum",getUiNum())
			.append("CardNum",getCardNum())
			.append("OiName",getOiName())
			.append("Edittime",getEdittime())
			.append("Content",getContent())
			.append("Terminalname",getTerminalname())
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
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个VhuisYanc对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof VhuisYanc == false) return false;
		if(this == obj) return true;
		VhuisYanc other = (VhuisYanc)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

