package com.sc.framework.enums;

public enum PurchaseEnum {
	wsq("0") {
		public String value() {
			return "未申请";
		}
	},
	wsh("1") {
		public String value() {
			return "未审核";
		}
	};

	private PurchaseEnum(String id) {
		this.id = id;
	}

	public static PurchaseEnum valueForState(String lg) {
		for (PurchaseEnum handle : PurchaseEnum.values()) {
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
