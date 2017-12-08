package com.sc.framework.enums;

/**
 * 消费排行统计报表类型
 * 
 * @author cuibin
 * 
 */
public enum ReportXiaofphtjTypeEnum {

	cpmx(0L) {
		public String value() {
			return "菜品明细";
		}
	},
	cplx(1L) {
		public String value() {
			return "菜品类型";
		}
	},
	czh(2L) {
		public String value() {
			return "餐桌号";
		}
	},
	czlx(3L) {
		public String value() {
			return "餐桌类型";
		}
	};

	private ReportXiaofphtjTypeEnum(long id) {
		this.id = id;
	}

	public static ReportXiaofphtjTypeEnum valueForState(Long lg) {
		for (ReportXiaofphtjTypeEnum handle : ReportXiaofphtjTypeEnum.values()) {
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
