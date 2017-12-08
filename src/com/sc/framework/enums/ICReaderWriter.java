package com.sc.framework.enums;

public enum ICReaderWriter {
	mh("明华RF"){
		public String value(){
			return "明华RF";
		}
	};
	
	private ICReaderWriter(String id){
		this.id = id;
	}
	public static ICReaderWriter valueForState(String lg) {
		for (ICReaderWriter handle : ICReaderWriter.values()) {
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
