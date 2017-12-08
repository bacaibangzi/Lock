package com.sc.zhouse.pojo;

import java.io.Serializable ;
import org.json.JSONObject ;
import com.google.gson.annotations.SerializedName ;

/**
 * 公共响应参数
 * @author  jinlong
 * @version  [版本号, 2015-3-3]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CommonResp extends JSONObject implements Serializable {

	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 1L ;

	/**
	 * 返回码
	 */
	@ SerializedName ( "result" )
	private String result ;

	/**
	 * 返回消息
	 */
	@ SerializedName ( "message" )
	private String message ;

	public String getResult() {
		return result ;
	}

	public void setResult(String result) {
		this.result = result ;
	}

	public String getMessage() {
		return message ;
	}

	public void setMessage(String message) {
		this.message = message ;
	}
}
