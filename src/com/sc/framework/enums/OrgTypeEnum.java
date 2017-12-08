package com.sc.framework.enums;

/**
 * 组织机构类型
 * 
 * @author cuibin
 * 
 */
public enum OrgTypeEnum {

	gs(0L) {
		public String value() {
			return "公司";
			//return "Company";
		}
	},
	ag(1L) {
		public String value() {
			return "经销商";
			//return "";
		}
	},
	dis(2L) {
		public String value() {
			return "餐饮连锁";
			//return "";
		}
	},
	sp(3L) {
		public String value() {
			return "超市连锁";
			//return "Supermarket Chain";
		}
	},
	ho(4L) {
		public String value() {
			return "总店";
			//return "Headquarters";
		}
	},
	il(5L) {
		public String value() {
			return "连锁";
			//return "Chain";
		}
	},
	jm(6L) {
		public String value() {
			return "加盟";
			//return "Franchising";
		}
	},
	cydd(7L) {
		public String value() {
			return "餐饮单店";
			//return "";
		}
	},
	csdd(8L) {
		public String value() {
			return "超市单店";
			//return "Supermarket Single Store";
		}
	},
	lsfu(9L) {
		public String value() {
			return "连锁分部";
			//return "Branch";
		}
	};

	private OrgTypeEnum(long id) {
		this.id = id;
	}

	public static OrgTypeEnum valueForState(Long lg) {
		for (OrgTypeEnum handle : OrgTypeEnum.values()) {
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
