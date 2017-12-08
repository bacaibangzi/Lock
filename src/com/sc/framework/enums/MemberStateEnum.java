package com.sc.framework.enums;

public enum MemberStateEnum {
	zc(1L) {
		public String value() {
			return "正常";
		}
	},
	zf(2L) {
		public String value() {
			return "止付";
		}
	},
	gs(3L) {
		public String value() {
			return "挂失";
		}
	},
	zuofei(4L) {
		public String value() {
			return "作废";
		}
	},
	ytk(5L) {
		public String value() {
			return "已退卡";
		}
	}
	;
	
	private MemberStateEnum(Long id) {
		this.id = id;
	}
	public static MemberStateEnum valueForState(Long lg) {
		for (MemberStateEnum handle : MemberStateEnum.values()) {
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
