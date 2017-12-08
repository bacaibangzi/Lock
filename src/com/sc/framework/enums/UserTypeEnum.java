package com.sc.framework.enums;

/**
 * 用户类型
 * 
 * @author cuibin
 * 
 */
public enum UserTypeEnum {

	merchant(0L) {
		public String value() {
			return "领导";
		}
	},
	employee(1L) {
		public String value() {
			return "教师";
		}
	},
	distributor(2L) {
		public String value() {
			return "职工";
		}
	},
	distributor1(3L) {
		public String value() {
			return "学生";
		}
	},
	distributor2(4L) {
		public String value() {
			return "临时人员";
		}
	},
	distributor3(5L) {
		public String value() {
			return "其他";
		}
	};

	private UserTypeEnum(long id) {
		this.id = id;
	}

	public static UserTypeEnum valueForState(Long lg) {
		for (UserTypeEnum handle : UserTypeEnum.values()) {
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
