package com.sc.framework.enums;

/**
 * 低消方式
 * 
 * @author cuibin
 * 
 */
public enum DttChLowModeEnum {

	czdx(1L) {
		public String value() {
			return "餐桌低消";
		}
	},
	rzdx(2L) {
		public String value() {
			return "人均低消";
		}
	};
	
	private DttChLowModeEnum(long id) {
		this.id = id;
	}
	public static DttChLowModeEnum valueForState(Long lg) {
		for (DttChLowModeEnum handle : DttChLowModeEnum.values()) {
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
