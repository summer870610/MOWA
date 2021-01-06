package com.zyy.mowa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeChatLoginDto {
	private int userId;
	private String usercode;
	private String nickname;
	private String avatarurl;
	private String username;
    private String telephone;
    private String verificationcode;
}
