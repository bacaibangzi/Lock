package com.sc.framework.enums;
/**
 * 卡类型
 * @author pan
 *
 */
public enum CardTypes {
	ck("磁卡"){
		public String value(){
			return "磁卡";
		}
	},
	ICk("IC卡") {
		public String value() {
			return "IC卡";
		}
	},
	whyk("无会员卡"){
		public String value(){
			return "无会员卡";
		}
	};
	
	private CardTypes(String id){
		this.id = id;
	}
	public static CardTypes valueForState(String lg) {
		for (CardTypes handle : CardTypes.values()) {
			if (handle.id.intern()==lg) {
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
