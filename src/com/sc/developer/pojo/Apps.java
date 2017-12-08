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
public class Apps extends CubeBaseEntity implements java.io.Serializable,Cloneable
{
	private static final long serialVersionUID = 5454155825314635342L;
	
	///alias
	public static final String TABLE_ALIAS = "Apps";
	public static final String ALIAS_SN = "sn";
	public static final String ALIAS_APPID = "appid";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_ICON_PATH = "iconPath";
	public static final String ALIAS_IMG1_PATH = "img1Path";
	public static final String ALIAS_IMG2_PATH = "img2Path";
	public static final String ALIAS_IMG3_PATH = "img3Path";
	public static final String ALIAS_IMG4_PATH = "img4Path";
	public static final String ALIAS_FILE_PATH = "filePath";
	public static final String ALIAS_FILE_SIZE = "fileSize";
	public static final String ALIAS_STATE = "state";
	public static final String ALIAS_USERID = "userid";
	public static final String ALIAS_DATE = "date";
	
	///date formats
	public static final String FORMAT_DATE = "yyyy-MM-dd HH:mm:ss";
	
	///可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	///columns START
	private java.lang.Integer sn;
	private java.lang.String appid;
	private java.lang.String appkey;
	private java.lang.String name;
	private java.lang.String remark;
	private java.lang.String iconPath = "";
	private java.lang.String img1Path = "";
	private java.lang.String img2Path = "";
	private java.lang.String img3Path = "";
	private java.lang.String img4Path = "";
	private java.lang.String filePath = "";
	private java.lang.String fileSize;
	private java.lang.Integer state = 0;
	private java.lang.Integer userid;
	private java.util.Date date;
	
	private String stateStr;
	///columns END

	public Apps(){
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
	public void setName(java.lang.String value)
    {
		this.name = value;
	}
	
	public java.lang.String getName()
    {
		return this.name;
	}
	public void setRemark(java.lang.String value)
    {
		this.remark = value;
	}
	
	public java.lang.String getRemark()
    {
		return this.remark;
	}
	public void setIconPath(java.lang.String value)
    {
		this.iconPath = value;
	}
	
	public java.lang.String getIconPath()
    {
		return this.iconPath;
	}
	public void setImg1Path(java.lang.String value)
    {
		this.img1Path = value;
	}
	
	public java.lang.String getImg1Path()
    {
		return this.img1Path;
	}
	public void setImg2Path(java.lang.String value)
    {
		this.img2Path = value;
	}
	
	public java.lang.String getImg2Path()
    {
		return this.img2Path;
	}
	public void setImg3Path(java.lang.String value)
    {
		this.img3Path = value;
	}
	
	public java.lang.String getImg3Path()
    {
		return this.img3Path;
	}
	public void setImg4Path(java.lang.String value)
    {
		this.img4Path = value;
	}
	
	public java.lang.String getImg4Path()
    {
		return this.img4Path;
	}
	public void setFilePath(java.lang.String value)
    {
		this.filePath = value;
	}
	
	public java.lang.String getFilePath()
    {
		return this.filePath;
	}
	public void setFileSize(java.lang.String value)
    {
		this.fileSize = value;
	}
	
	public java.lang.String getFileSize()
    {
		return this.fileSize;
	}
	public void setState(java.lang.Integer value)
    {
		this.state = value;
		if(value==-1){
			this.stateStr = "未审核通过";
		}else if(value==0){
			this.stateStr = "未提交";
		}else if(value==1){
			this.stateStr = "未审核";
		}else if(value==2){
			this.stateStr = "审核通过";
		}
		
	}
	
	public java.lang.Integer getState()
    {
		return this.state;
	}
	public void setUserid(java.lang.Integer value)
    {
		this.userid = value;
	}
	
	public java.lang.Integer getUserid()
    {
		return this.userid;
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

    public String getStateStr() {
		return stateStr;
	}


	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}


	public java.lang.String getAppkey() {
		return appkey;
	}


	public void setAppkey(java.lang.String appkey) {
		this.appkey = appkey;
	}


	/**
     * @brief   功能: 将Apps对象数据进行串化
     * @param   
     * @return  
     */
	public String toString()
    {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sn",getSn())
			.append("Appid",getAppid())
			.append("Name",getName())
			.append("Remark",getRemark())
			.append("IconPath",getIconPath())
			.append("Img1Path",getImg1Path())
			.append("Img2Path",getImg2Path())
			.append("Img3Path",getImg3Path())
			.append("Img4Path",getImg4Path())
			.append("FilePath",getFilePath())
			.append("FileSize",getFileSize())
			.append("State",getState())
			.append("Userid",getUserid())
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
			.toHashCode();
	}
	
    /**
     * @brief   功能: 检测两个Apps对象是否相同
     * @param   
     * @return  
     */
	public boolean equals(Object obj) {
		if(obj instanceof Apps == false) return false;
		if(this == obj) return true;
		Apps other = (Apps)obj;
		return new EqualsBuilder()
			.isEquals();
	}
}

