package com.sc.framework.enums;

/**
 * 用户审核枚举类
 * 
 * @author cuibin
 * 
 */
public enum UserShEnum {

	unSh(0L) {
		public String value() {
			return "Unaudited";
		}
	},
	sh(1L) {
		public String value() {
			return "Audited";
		}
	};

	private UserShEnum(long id) {
		this.id = id;
	}

	public static UserShEnum valueForState(Long lg) {
		for (UserShEnum handle : UserShEnum.values()) {
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
