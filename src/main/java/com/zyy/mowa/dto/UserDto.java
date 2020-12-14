package com.zyy.mowa.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author USER
 * @date 2020/05/25
 */
@Data // 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@NoArgsConstructor // 注解在类上；为类提供一个无参的构造方法
@AllArgsConstructor // 注解在类上；为类提供一个全参的构造方法
public class UserDto {
	private Integer id;

    private String usercode;

    private String username;

    private String sex;

    private String telephone;

    private String email;

    private String departmentcode;

    private String status;

    private String remark;

    private Date createtime;

    private Boolean isdeleteflag;

    private String position;

    private String nickname;

    private String avatarurl;
    private String sessionkey;
    private String rolename;
}
