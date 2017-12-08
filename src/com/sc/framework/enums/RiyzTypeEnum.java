package com.sc.framework.enums;

/**
 * 消费排行统计报表类型
 * 
 * @author cuibin
 * 
 */
public enum RiyzTypeEnum {

	ri("0") {
		public String value() {
			return "日分析";
		}
	},
	yue("1") {
		public String value() {
			return "月分析";
		}
	};

	private RiyzTypeEnum(String id) {
		this.id = id;
	}

	public static RiyzTypeEnum valueForState(String lg) {
		for (RiyzTypeEnum handle : RiyzTypeEnum.values()) {
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
