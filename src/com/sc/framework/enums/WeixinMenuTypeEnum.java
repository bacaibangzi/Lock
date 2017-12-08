package com.sc.framework.enums;

/**
 * 微信菜单类型
 * 
 * @author cuibin
 * 
 */
public enum WeixinMenuTypeEnum {
	one(1L) {
		public String value() {
			return "一级文本菜单";
		}
	},
	two(2L) {
		public String value() {
			return "二级文本菜单";
		}
	}
	;
	
	private WeixinMenuTypeEnum(Long id) {
		this.id = id;
	}
	public static WeixinMenuTypeEnum valueForState(Long lg) {
		for (WeixinMenuTypeEnum handle : WeixinMenuTypeEnum.values()) {
			if (handle.id == lg) {
				return handle;
			}
		}
		return null;
	}

	public long id() {
		return id;
	}

	public abstract String value();

	private long id;
}
