package com.sc.framework.enums;

/**
 * 微信排队类型
 * 
 * @author cuibin
 * 
 */
public enum WinXiQueueEnum {

	del(-1L) {
		public String value() {
			return "作废";
		}
	},
	unUse(0L) {
		public String value() {
			return "未叫号";
		}
	},
	use(1L) {
		public String value() {
			return "已叫号";
		}
	};

	private WinXiQueueEnum(long id) {
		this.id = id;
	}

	public static WinXiQueueEnum valueForState(Long lg) {
		for (WinXiQueueEnum handle : WinXiQueueEnum.values()) {
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
