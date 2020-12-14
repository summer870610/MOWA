package com.zyy.mowa.constant;

/**
 * @author USER
 * @date 2020/05/25
 */
public enum ExceptionEnum {
    UNKNOW_ERROR(-1, "未知错误"), USER_NOT_FIND(-101, "用户不存在"), UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Not Found"),;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
