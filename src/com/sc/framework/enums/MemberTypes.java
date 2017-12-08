package com.sc.framework.enums;
/**
 * 会员类型
 * @author pan
 *
 */
public enum MemberTypes {
	
	yhk("1"){
		public String value(){
			return "优惠卡";
		}
	},
	czk("2") {
		public String value() {
			return "充值卡";
		}
	};
	
	private MemberTypes(String id){
		this.id = id;
	}
	public static MemberTypes valueForState(String lg) {
		for (MemberTypes handle : MemberTypes.values()) {
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
