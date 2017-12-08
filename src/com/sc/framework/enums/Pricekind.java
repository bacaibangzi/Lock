package com.sc.framework.enums;

/**
 * 会员价
 * 
 * @author cuibin
 *
 */
public enum Pricekind {
	one("1"){
		public String value(){
			return "会员价1";
		}
	};
	
	private Pricekind(String id){
		this.id = id;
	}
	public static Pricekind valueForState(String lg) {
		for (Pricekind handle : Pricekind.values()) {
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
