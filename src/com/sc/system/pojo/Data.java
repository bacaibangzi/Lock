package com.sc.system.pojo;

import com.sc.framework.base.pojo.CubeBaseEntity;

public class Data extends CubeBaseEntity implements java.io.Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	private Long sn;
	private String code;
	private String name;
	private String keys;
	
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
		this.idStr = String.valueOf(sn);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}
	
	
}
