package com.zyy.mowa.constant;

import lombok.Data;

/**
 * @author USER
 *
 */
@Data
public class GeneralToken {
	// 获取到的凭证
	private String access_token;

	// 凭证有效时间，单位：秒。目前是7200秒之内的值。
	private Number expires_in;
	
	// 错误码
	private Number errcode;
	
	// 错误信息
	private String errmsg;
}
