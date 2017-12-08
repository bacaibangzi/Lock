package com.sc.system.pojo;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.sc.framework.base.pojo.CubeBaseEntity;
import com.sc.framework.session.util.SessionConstants;
import com.sc.framework.utils.DateConvertUtils;

/**
 * @ingroup system
 * @author
 * @brief 类简单描述
 * 
 *        类功能详细描述
 */
public class UserInfo extends CubeBaseEntity implements java.io.Serializable,
		Cloneable {
	private static final long serialVersionUID = 5454155825314635342L;

	// /alias
	public static final String TABLE_ALIAS = "UserInfo";
	public static final String ALIAS_UI_ID = "用户ID";
	public static final String ALIAS_UI_TYPE = "用户类型";
	public static final String ALIAS_UI_LOGIN_NAME = "用户登录名";
	public static final String ALIAS_UI_PASSWORD = "用户密码";
	public static final String ALIAS_UI_NAME = "联系人";
	public static final String ALIAS_UI_NICK_NAME = "昵称";
	public static final String ALIAS_UI_SEX = "性别";
	public static final String ALIAS_UI_IMG = "用户头像";
	public static final String ALIAS_UI_PR_ID = "省份ID";
	public static final String ALIAS_UI_CY_ID = "城市ID";
	public static final String ALIAS_UI_AR_ID = "区域ID";
	public static final String ALIAS_UI_PROVINCE = "省份";
	public static final String ALIAS_UI_CITY = "城市";
	public static final String ALIAS_UI_AREA = "区域"; 
	public static final String ALIAS_UI_MOBILE = "绑定手机号码";
	public static final String ALIAS_UI_EMAIL = "绑定电子邮箱";
	public static final String ALIAS_UI_COMPANY = "公司名称";
	public static final String ALIAS_UI_ADDRESS = "公司地址";
	public static final String ALIAS_UI_TELPHONE = "公司电话";
	public static final String ALIAS_UI_VIP_LEVEL_ID = "用户VIP等级ID";
	public static final String ALIAS_UI_VIP_LEVEL_NAME = "用户VIP等级名称";
	public static final String ALIAS_UI_VIP_LEVEL_TIME = "用户VIP等级到期时间";
	public static final String ALIAS_UI_CT_LIMIT = "用户餐厅上限";
	public static final String ALIAS_UI_TOTAL_SMS_COUNT = "短信总条数";
	public static final String ALIAS_UI_BALANCE = "账号余额";
	public static final String ALIAS_UI_FIND_PASSWORD_CODE = "找回密码验证码";
	public static final String ALIAS_UI_FIND_PASSWORD_TIME = "找回密码验证码生成时间";
	public static final String ALIAS_UI_ORG_CODE = "机构CODE";

	// /date formats
	public static final String FORMAT_UI_VIP_LEVEL_TIME = "YYYY-MM-DD";
	public static final String FORMAT_UI_FIND_PASSWORD_TIME = "YYYY-MM-DD";

	// /可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// /columns START
	private java.lang.Long uiId;
	private java.lang.Long uiId1;
	private java.lang.Long uiType;
	private java.lang.String uiLoginName;
	private java.lang.String uiPassword;
	private java.lang.String uiName;
	private java.lang.String uiNickName;
	private java.lang.Long uiSex;
	private java.lang.String uiImg;
	private java.lang.Long uiPrId;
	private java.lang.Long uiCyId;
	private java.lang.Long uiArId;
	private java.lang.String uiProvince;
	private java.lang.String uiCity;
	private java.lang.String uiArea;
	private java.lang.String uiMobile;
	private java.lang.String uiEmail;
	private java.lang.String uiCompany;
	private java.lang.String uiAddress; // 暂住地址
	private java.lang.String uiTelphone;
	private java.lang.Long uiVipLevelId; 
	private java.lang.String uiVipLevelName;// 所属年级
	private java.lang.String uiVipLevelTime;
	private java.lang.Long uiCtLimit;
	private java.lang.Long uiTotalSmsCount;
	private Long uiBalance;
	private java.lang.String uiFindPasswordCode;
	private java.lang.String uiFindPasswordTime;
	private java.lang.String uiOrgCode;
	private Date uiRegTime; // 入学时间
	private Long uiSh;
	private String uiSexStr;
	private String uiShStr;
	private String uiNum;
	private String uiTypeStr;
	
	private String uiVipLevelTimeString;
	private String uiFindPasswordTimeString;
	public static final String FORMAT_DATE = "yyyy-MM-dd";

	private String bm;
	
	// /columns END

	
	
	public Long getUiSh() {
		return uiSh;
	}

	public java.lang.Long getUiId1() {
		return uiId1;
	}

	public void setUiId1(java.lang.Long uiId1) {
		this.uiId1 = uiId1;
	}

	public String getBm() {
		return bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getUiTypeStr() {
		return uiTypeStr;
	}

	public void setUiTypeStr(String uiTypeStr) {
		this.uiTypeStr = uiTypeStr;
	}

	/*
	public String getUiVipLevelTimeString() {
		return DateConvertUtils.format(getUiVipLevelTime(), FORMAT_DATE);
	}

	public void setUiVipLevelTimeString(String uiVipLevelTimeString) {
		setUiVipLevelTime(DateConvertUtils.parse(uiVipLevelTimeString, FORMAT_DATE,java.util.Date.class));
	}

	public String getUiFindPasswordTimeString() {
		return DateConvertUtils.format(getUiFindPasswordTime(), FORMAT_DATE);
	}

	public void setUiFindPasswordTimeString(String uiFindPasswordTimeString) {
		setUiFindPasswordTime(DateConvertUtils.parse(uiFindPasswordTimeString, FORMAT_DATE,java.util.Date.class));
	}*/

	public void setUiSh(Long uiSh) {

		this.uiShStr = SessionConstants.user_sh.get(uiSh);
		this.uiSh = uiSh;
	}

	public UserInfo() {
	}

	public UserInfo(java.lang.Long uiId) {
		this.uiId = uiId;
	}

	public void setUiId(java.lang.Long value) {
		super.idStr = String.valueOf(value);
		this.uiId = value;
		this.setUiId1(value);
	}

	public java.lang.Long getUiId() {
		return this.uiId;
	}

	public void setUiType(java.lang.Long value) {
		this.uiType = value;
		this.uiTypeStr = SessionConstants.user_type.get(value);
	}

	public java.lang.Long getUiType() {
		return this.uiType;
	}

	public String getUiNum() {
		return uiNum;
	}

	public void setUiNum(String uiNum) {
		this.uiNum = uiNum;
	}

	public void setUiLoginName(java.lang.String value) {
		this.uiLoginName = value;
	}

	public java.lang.String getUiLoginName() {
		return this.uiLoginName;
	}

	public void setUiPassword(java.lang.String value) {
		this.uiPassword = value;
	}

	public java.lang.String getUiPassword() {
		return this.uiPassword;
	}

	public void setUiName(java.lang.String value) {
		this.uiName = value;
	}

	public java.lang.String getUiName() {
		return this.uiName;
	}

	public void setUiNickName(java.lang.String value) {
		this.uiNickName = value;
	}

	public java.lang.String getUiNickName() {
		return this.uiNickName;
	}

	public void setUiSex(java.lang.Long value) {
		this.uiSexStr = SessionConstants.user_sex.get(value);
		this.uiSex = value;
	}

	public java.lang.Long getUiSex() {
		return this.uiSex;
	}

	public void setUiImg(java.lang.String value) {
		this.uiImg = value;
	}

	public java.lang.String getUiImg() {
		return this.uiImg;
	}

	public void setUiPrId(java.lang.Long value) {
		this.uiPrId = value;
	}

	public java.lang.Long getUiPrId() {
		return this.uiPrId;
	}

	public void setUiCyId(java.lang.Long value) {
		this.uiCyId = value;
	}

	public java.lang.Long getUiCyId() {
		return this.uiCyId;
	}

	public void setUiArId(java.lang.Long value) {
		this.uiArId = value;
	}

	public java.lang.Long getUiArId() {
		return this.uiArId;
	}

	public void setUiProvince(java.lang.String value) {
		this.uiProvince = value;
	}

	public java.lang.String getUiProvince() {
		return this.uiProvince;
	}

	public void setUiCity(java.lang.String value) {
		this.uiCity = value;
	}

	public java.lang.String getUiCity() {
		return this.uiCity;
	}

	public void setUiArea(java.lang.String value) {
		this.uiArea = value;
	}

	public java.lang.String getUiArea() {
		return this.uiArea;
	}

	public void setUiMobile(java.lang.String value) {
		this.uiMobile = value;
	}

	public java.lang.String getUiMobile() {
		return this.uiMobile;
	}

	public void setUiEmail(java.lang.String value) {
		this.uiEmail = value;
	}

	public java.lang.String getUiEmail() {
		return this.uiEmail;
	}

	public void setUiCompany(java.lang.String value) {
		this.uiCompany = value;
	}

	public java.lang.String getUiCompany() {
		return this.uiCompany;
	}

	public void setUiAddress(java.lang.String value) {
		this.uiAddress = value;
	}

	public java.lang.String getUiAddress() {
		return this.uiAddress;
	}

	public void setUiTelphone(java.lang.String value) {
		this.uiTelphone = value;
	}

	public java.lang.String getUiTelphone() {
		return this.uiTelphone;
	}

	public void setUiVipLevelId(java.lang.Long value) {
		this.uiVipLevelId = value;
	}

	public java.lang.Long getUiVipLevelId() {
		return this.uiVipLevelId;
	}

	public void setUiVipLevelName(java.lang.String value) {
		this.uiVipLevelName = value;
	}

	public java.lang.String getUiVipLevelName() {
		return this.uiVipLevelName;
	}

	public void setUiVipLevelTime(java.lang.String value) {
		this.uiVipLevelTime = value;
	}

	public java.lang.String getUiVipLevelTime() {
		return this.uiVipLevelTime;
	}

	public void setUiCtLimit(java.lang.Long value) {
		this.uiCtLimit = value;
	}

	public java.lang.Long getUiCtLimit() {
		return this.uiCtLimit;
	}

	public void setUiTotalSmsCount(java.lang.Long value) {
		this.uiTotalSmsCount = value;
	}

	public java.lang.Long getUiTotalSmsCount() {
		return this.uiTotalSmsCount;
	}

	public void setUiBalance(Long value) {
		this.uiBalance = value;
	}

	public Long getUiBalance() {
		return this.uiBalance;
	}

	public void setUiFindPasswordCode(java.lang.String value) {
		this.uiFindPasswordCode = value;
	}

	public java.lang.String getUiFindPasswordCode() {
		return this.uiFindPasswordCode;
	}

	public void setUiFindPasswordTime(java.lang.String value) {
		this.uiFindPasswordTime = value;
	}

	public java.lang.String getUiFindPasswordTime() {
		return this.uiFindPasswordTime;
	}

	public void setUiOrgCode(java.lang.String value) {
		this.uiOrgCode = value;
	}

	public java.lang.String getUiOrgCode() {
		return this.uiOrgCode;
	}

	public String getUiShStr() {
		return uiShStr;
	}

	public void setUiShStr(String uiShStr) {
		this.uiShStr = uiShStr;
	}

	public String getUiSexStr() {
		return uiSexStr;
	}

	public void setUiSexStr(String uiSexStr) {
		this.uiSexStr = uiSexStr;
	}

	public Date getUiRegTime() {
		return uiRegTime;
	}

	public void setUiRegTime(Date uiRegTime) {
		this.uiRegTime = uiRegTime;
	}

	/**
	 * @brief 功能: 将UserInfo对象数据进行串化
	 * @param
	 * @return
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("UiId", getUiId()).append("UiType", getUiType())
				.append("UiLoginName", getUiLoginName()).append("UiPassword",
						getUiPassword()).append("UiName", getUiName()).append(
						"UiNickName", getUiNickName()).append("UiSex",
						getUiSex()).append("UiImg", getUiImg()).append(
						"UiPrId", getUiPrId()).append("UiCyId", getUiCyId())
				.append("UiArId", getUiArId()).append("UiProvince",
						getUiProvince()).append("UiCity", getUiCity()).append(
						"UiArea", getUiArea())
				.append("UiMobile", getUiMobile()).append("UiEmail",
						getUiEmail()).append("UiCompany", getUiCompany())
				.append("UiAddress", getUiAddress()).append("UiTelphone",
						getUiTelphone()).append("UiVipLevelId",
						getUiVipLevelId()).append("UiVipLevelName",
						getUiVipLevelName()).append("UiVipLevelTime",
						getUiVipLevelTime())
				.append("UiCtLimit", getUiCtLimit()).append("UiTotalSmsCount",
						getUiTotalSmsCount()).append("UiBalance",
						getUiBalance()).append("UiFindPasswordCode",
						getUiFindPasswordCode()).append("UiFindPasswordTime",
						getUiFindPasswordTime()).append("UiOrgCode",
						getUiOrgCode()).toString();
	}

	/**
	 * @brief 功能:
	 * @param
	 * @return
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getUiId()).toHashCode();
	}

	/**
	 * @brief 功能: 检测两个UserInfo对象是否相同
	 * @param
	 * @return
	 */
	public boolean equals(Object obj) {
		if (obj instanceof UserInfo == false)
			return false;
		if (this == obj)
			return true;
		UserInfo other = (UserInfo) obj;
		return new EqualsBuilder().append(getUiId(), other.getUiId())
				.isEquals();
	}
}
