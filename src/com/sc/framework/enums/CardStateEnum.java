package com.sc.framework.enums;

public enum CardStateEnum {
	yck("Y") {
		public String value() {
			return "已持卡";
		}
	},
	wck("N") {
		public String value() {
			return "未持卡";
		}
	};
	
	private CardStateEnum(String id) {
		this.id = id;
	}
	public static CardStateEnum valueForState(String lg) {
		for (CardStateEnum handle : CardStateEnum.values()) {
			if (handle.id == lg) {
				return handle;
			}
		}
		return null;
	}

	public String id() {
		return id;
	}

	public abstract String value();

	private String id;
}
