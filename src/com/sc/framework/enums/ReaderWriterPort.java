package com.sc.framework.enums;

public enum ReaderWriterPort {
	usb("USB"){
		public String value(){
			return "USB";
		}
	};
	
	private ReaderWriterPort(String id){
		this.id = id;
	}
	public static ReaderWriterPort valueForState(String lg) {
		for (ReaderWriterPort handle : ReaderWriterPort.values()) {
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
