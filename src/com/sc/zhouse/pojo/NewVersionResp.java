package com.sc.zhouse.pojo;

import com.google.gson.annotations.SerializedName ;

/**
 *	ClassName:	NewVersionResp
 *	Function: 版本更新
 */
public class NewVersionResp extends CommonResp {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L ;

	@ SerializedName ( "version" )
	private String version ;

	@ SerializedName ( "url" )
	private String url ;

	public String getVersion() {
		return version ;
	}

	public void setVersion(String version) {
		this.version = version ;
	}

	public String getUrl() {
		return url ;
	}

	public void setUrl(String url) {
		this.url = url ;
	}
}
