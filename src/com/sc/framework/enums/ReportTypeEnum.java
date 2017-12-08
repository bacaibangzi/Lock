package com.sc.framework.enums;

/**
 * 报表类型
 * 
 * @author cuibin
 * 
 */
public enum ReportTypeEnum {

	cplb(0L) {
		public String value() {
			return "按菜品类别";
		}
	},
	cz(1L) {
		public String value() {
			return "按餐桌";
		}
	},
	czlx(2L) {
		public String value() {
			return "按餐桌类型";
		}
	},
	czy(3L) {
		public String value() {
			return "按操作员";
		}
	},
	fkdh(4L) {
		public String value() {
			return "按付款单号";
		}
	};

	private ReportTypeEnum(long id) {
		this.id = id;
	}

	public static ReportTypeEnum valueForState(Long lg) {
		for (ReportTypeEnum handle : ReportTypeEnum.values()) {
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
