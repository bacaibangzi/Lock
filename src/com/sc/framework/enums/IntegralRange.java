package com.sc.framework.enums;
/**
 * 消费积分范围
 * @author pan
 *
 */
public enum IntegralRange {
	xfe(0L){
		public String value(){
			return "消费额";
		}
	},
	bqz(1L) {
		public String value() {
			return "折付额或卡付额";
		}
	},
	kfe(2L) {
		public String value() {
			return "实际收入";
		}
	};
	
	private IntegralRange(Long id){
		this.id = id;
	}
	public static IntegralRange valueForState(Long lg) {
		for (IntegralRange handle : IntegralRange.values()) {
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
