package com.zyy.mowa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeChartResultDto {
	//用户唯一标识
	public String openid;	
	//会话密钥
	public String	session_key;
	//	用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回，详见 UnionID 机制说明。
	public String unionid	;
	//错误码
	public int errcode;	
	//错误信息	
	public String errmsg;

}
