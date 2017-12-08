package com.sc.framework.enums;
/**
 * 是否取整
 * @author pan
 *
 */
public enum IsRounding {
	qz("0"){
		public String value(){
			return "取整";
		}
	},
	bqz("1") {
		public String value() {
			return "保留小数";
		}
	};
	
	private IsRounding(String id){
		this.id = id;
	}
	public static IsRounding valueForState(String lg) {
		for (IsRounding handle : IsRounding.values()) {
			if (handle.id.intern().equals(lg)) {
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
