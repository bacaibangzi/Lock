package com.sc.framework.enums;

/**
 * 出库方式
 * 
 * @author cuibin
 *
 * 
#define TYPE_INVENTORY_CSKC           1     //初始库存
#define TYPE_INVENTORY_CGJH           2     //采购进货
#define TYPE_INVENTORY_CGTH           3     //采购退货
#define TYPE_INVENTORY_ZSRK           4     //赠送入库
#define TYPE_INVENTORY_ZSCK           5     //赠送出库
#define TYPE_INVENTORY_QTRK           6     //其他出库
#define TYPE_INVENTORY_QTCK           7     //其他出库
#define TYPE_INVENTORY_KCPD           8     //库存盘点
#define TYPE_INVENTORY_SALE           9     //销售
#define TYPE_INVENTORY_RETURN         10    //退货
#define TYPE_INVENTORY_EXCHANGE       11    //兑换
#define TYPE_INVENTORY_WHOLESALE      12    //批发
#define TYPE_INVENTORY_WEIXIN         13    //微商城订货

 *
 */
public enum InventoryType {
	CSKC("1"){
		public String value(){
			return "初始库存";
		}
	},
	CGJH("2") {
		public String value() {
			return "采购进货";
		}
	},
	CGTH("3") {
		public String value() {
			return "采购退货";
		}
	},
	ZSRK("4") {
		public String value() {
			return "赠送入库";
		}
	},
	ZSCK("5") {
		public String value() {
			return "赠送出库";
		}
	},
	QTRK("6") {
		public String value() {
			return "其他入库";
		}
	},
	QTCK("7") {
		public String value() {
			return "其他出库";
		}
	},
	KCPD("8") {
		public String value() {
			return "库存盘点";
		}
	},
	SALE("9") {
		public String value() {
			return "销售";
		}
	},
	RETURN("10") {
		public String value() {
			return "退货";
		}
	},
	EXCHANGE("11") {
		public String value() {
			return "兑换";
		}
	},
	WHOLESALE("12") {
		public String value() {
			return "批发";
		}
	},
	WEIXIN("13") {
		public String value() {
			return "微商城订货";
		}
	};
	
	private InventoryType(String id){
		this.id = id;
	}
	public static InventoryType valueForState(String lg) {
		for (InventoryType handle : InventoryType.values()) {
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
