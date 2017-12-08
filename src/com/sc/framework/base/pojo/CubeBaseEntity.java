package com.sc.framework.base.pojo;

import java.io.Serializable;

/**
 * 基类
 * 
 */
public class CubeBaseEntity implements Serializable {
	private static final long serialVersionUID = 5811842824313827700L;
	/** 字符串存放子类ID属性 解决实体转JSON后，前台JS获取精度失真问题 */
	protected String idStr;
	/** 操作 当子类实体涉及到列表行级操作（编辑、删除、查看...）的时候，可以继承该属性 */
	private String operate;

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}
}
