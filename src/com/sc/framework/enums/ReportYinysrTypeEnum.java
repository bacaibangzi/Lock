package com.sc.framework.enums;

/**
 * 营业收银报表类型
 * 
 * @author cuibin
 * 
 */
public enum ReportYinysrTypeEnum {

	cz(0L) {
		public String value() {
			return "餐桌";
		}
	},
	syy(1L) {
		public String value() {
			return "收银员";
		}
	},
	crmx(2L) {
		public String value() {
			return "收入明细";
		}
	};

	private ReportYinysrTypeEnum(long id) {
		this.id = id;
	}

	public static ReportYinysrTypeEnum valueForState(Long lg) {
		for (ReportYinysrTypeEnum handle : ReportYinysrTypeEnum.values()) {
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
