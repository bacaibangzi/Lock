package com.sc.framework.enums;
/**
 * 优惠方式
 * @author pan
 *
 */
public enum PreferentialWay {
	hytj("1"){
		public String value(){
			return "会员特价";
		}
	},
	gdzk("2"){
		public String value(){
			return "固定折扣";
		}
	};
	
	private PreferentialWay(String id){
		this.id = id;
	}
	public static PreferentialWay valueForState(String lg) {
		for (PreferentialWay handle : PreferentialWay.values()) {
			if (handle.id.intern() == lg) {
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
