package com.zyy.mowa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeChatLoginDto {
	private int userId;
	private String usercode;
	private String nickname;

	private String avatarurl;
	private String username;
    private String telephone;
    private String verificationcode;
}
