package com.sc.framework.enums;

/**
 * 菜品提成枚举类
 * 
 * @author cuibin
 * 
 */
public enum TcEnum {

	bltc(1L) {
		public String value() {
			return "比例提成";
		}
	},
	detc(2L) {
		public String value() {
			return "定额提成";
		}
	};

	private TcEnum(long id) {
		this.id = id;
	}

	public static TcEnum valueForState(Long lg) {
		for (TcEnum handle : TcEnum.values()) {
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
