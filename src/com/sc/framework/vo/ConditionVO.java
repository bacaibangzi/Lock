package com.sc.framework.vo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.sc.framework.utils.StringUtil;

/**
 * 
 * 公共条件VO
 * 
 */
public class ConditionVO implements Serializable {

	private static final long serialVersionUID = -4137700668976477361L;
	// 用户名称
	private String userName;
	// 用户id
	private String userId;
	// 菜单等级
	private String level;
	// 菜单id
	private Long menuId;
	// id
	private Long id;
	// value
	private String value;
	// num
	private String num;
	// nums
	private String nums;
	// ids
	private String entityIds;
	// entityId
	private String entityId;
	// 组织编码
	private String orgCode;
	private String orgName;
	private String orgType;
	// 过滤名称
	private String nameFilter;
	private String nameFilter1;
	// 过滤审核
	private String shFilter;
	// code
	private String code;
	private String code1;
	private String code2;
	private String code3;
	private String code4;
	private String code5;
	// 错误信息
	private String errMsg;
	// 版本号
	private String version;

	// 查询时间段
	private String dateStr1;
	private String dateStr2;

	// 报表类型
	private String reportType;

	// 菜品类型(大)
	private String diChDishTypeNo;

	// 微信用户openid
	private String openid;
	// 订单sn(编号)
	private Long orderSn;
	// 订单类型
	private String orderType;
	// 订单状态
	private String orderState;
	// 订桌状态
	private Integer orderTableState;
	// 餐桌号
	private String tableNo;
	// 餐桌区域号
	private String dtChTypeNo;
	// 订桌失败原因
	private String refuseToReason;
	// 套菜编号
	private String dsChSuitNo;
	// 超市资料标识位
	private String flag;
	// 总店组织编码
	private String zongDianOrgCode;
	// 门店组织编码
	private String menDianOrgCode;
	// 当前选中机构组织码
	private String selectedOrgCode;
	// 共享门店提示
	private String reminder;
	// 共享门店URL
	private String shareUrl;

	/*
	 * get set method
	 */

	public String getUserName() {
		return userName;
	}

	public String getNums() {
		return nums;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public String getSelectedOrgCode() {
		return selectedOrgCode;
	}

	public void setSelectedOrgCode(String selectedOrgCode) {
		this.selectedOrgCode = selectedOrgCode;
	}

	public String getZongDianOrgCode() {
		return zongDianOrgCode;
	}

	public void setZongDianOrgCode(String zongDianOrgCode) {
		this.zongDianOrgCode = zongDianOrgCode;
	}

	public String getMenDianOrgCode() {
		return menDianOrgCode;
	}

	public void setMenDianOrgCode(String menDianOrgCode) {
		this.menDianOrgCode = menDianOrgCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDsChSuitNo() {
		return dsChSuitNo;
	}

	public void setDsChSuitNo(String dsChSuitNo) {
		this.dsChSuitNo = dsChSuitNo;
	}

	public String getCode3() {
		return code3;
	}

	public void setCode3(String code3) {
		this.code3 = code3;
	}

	public String getCode4() {
		return code4;
	}

	public void setCode4(String code4) {
		this.code4 = code4;
	}

	public String getDtChTypeNo() {
		return dtChTypeNo;
	}

	public void setDtChTypeNo(String dtChTypeNo) {
		this.dtChTypeNo = dtChTypeNo;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getRefuseToReason() {
		return refuseToReason;
	}

	public void setRefuseToReason(String refuseToReason) {
		this.refuseToReason = refuseToReason;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	public Integer getOrderTableState() {
		return orderTableState;
	}

	public void setOrderTableState(Integer orderTableState) {
		this.orderTableState = orderTableState;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Long getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(Long orderSn) {
		this.orderSn = orderSn;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getEntityIds() {
		return entityIds;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		try {
			this.orgName = StringUtil.encodeURIComponent(orgName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setEntityIds(String entityIds) {
		this.entityIds = entityIds;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getNameFilter() {
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) {
		try {
			this.nameFilter = URLDecoder.decode(nameFilter, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getNameFilter1() {
		return nameFilter1;
	}

	public void setNameFilter1(String nameFilter1) {
		try {
			this.nameFilter1 = URLDecoder.decode(nameFilter1, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getShFilter() {
		return shFilter;
	}

	public void setShFilter(String shFilter) {
		this.shFilter = shFilter;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDateStr1() {
		return dateStr1;
	}

	public void setDateStr1(String dateStr1) {
		this.dateStr1 = dateStr1;
	}

	public String getDateStr2() {
		return dateStr2;
	}

	public void setDateStr2(String dateStr2) {
		this.dateStr2 = dateStr2;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getDiChDishTypeNo() {
		return diChDishTypeNo;
	}

	public void setDiChDishTypeNo(String diChDishTypeNo) {
		this.diChDishTypeNo = diChDishTypeNo;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode5() {
		return code5;
	}

	public void setCode5(String code5) {
		this.code5 = code5;
	}

}
