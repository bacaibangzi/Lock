package com.sc.framework.enums;

/**
 * 退菜情况报表类型
 * 
 * @author cuibin
 * 
 */
public enum ReportTcqkTypeEnum {

	cp(0L) {
		public String value() {
			return "菜品";
		}
	},
	cz(1L) {
		public String value() {
			return "餐桌";
		}
	},
	czlx(2L) {
		public String value() {
			return "餐桌类型";
		}
	},
	tcr(3L) {
		public String value() {
			return "退菜人";
		}
	},
	tcmx(4L) {
		public String value() {
			return "退菜明细";
		}
	};

	private ReportTcqkTypeEnum(long id) {
		this.id = id;
	}

	public static ReportTcqkTypeEnum valueForState(Long lg) {
		for (ReportTcqkTypeEnum handle : ReportTcqkTypeEnum.values()) {
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
