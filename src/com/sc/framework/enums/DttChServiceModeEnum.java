package com.sc.framework.enums;

/**
 * 服务模式
 * 
 * @author cuibin
 * 
 */
public enum DttChServiceModeEnum {

	bcl(0L) {
		public String value() {
			return "不处理";
		}
	},
	sjdw(1L) {
		public String value() {
			return "时间单位";
		}
	},
	xfefwfl(2L) {
		public String value() {
			return "消费额服务费率";
		}
	},
	czde(3L) {
		public String value() {
			return "餐桌定额";
		}
	},
	cpxffwfl(4L) {
		public String value() {
			return "菜品消费服务费率";
		}
	};

	private DttChServiceModeEnum(long id) {
		this.id = id;
	}

	public static DttChServiceModeEnum valueForState(Long lg) {
		for (DttChServiceModeEnum handle : DttChServiceModeEnum.values()) {
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
