package com.sc.framework.enums;

/**
 * 显示枚举类
 * 
 * @author cuibin
 * 
 */
public enum ShowEnum {

	on(0L) {
		public String value() {
			return "不显示";
		}
	},
	off(1L) {
		public String value() {
			return "显示";
		}
	};

	private ShowEnum(long id) {
		this.id = id;
	}

	public static ShowEnum valueForState(Long lg) {
		for (ShowEnum handle : ShowEnum.values()) {
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
