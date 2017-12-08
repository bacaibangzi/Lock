package com.sc.framework.enums;
/**
 * 是否积分
 * @author pan
 *
 */
public enum Isintegral {
	jf("Y"){
		public String value(){
			return "积分";
		}
	},
	bjf("N") {
		public String value() {
			return "不积分";
		}
	};
	
	private Isintegral(String id){
		this.id = id;
	}
	public static Isintegral valueForState(String lg) {
		for (Isintegral handle : Isintegral.values()) {
			if (handle.id.intern() == lg.intern()) {
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
