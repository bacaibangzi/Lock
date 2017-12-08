package com.sc.teminal.pojo;

import com.sc.framework.base.pojo.CubeBaseEntity;

public class Cmdlog  extends CubeBaseEntity implements java.io.Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	private String sn;
	private String type;
	private String value;
	
	public Cmdlog(){
		
	}
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
		this.idStr = sn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
