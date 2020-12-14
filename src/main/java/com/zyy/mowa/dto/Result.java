package com.zyy.mowa.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;

/**
 * @author USER
 * @date 2020/05/25
 */

@Getter
@Setter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4505655308965878999L;

    // 请求成功返回码为：0000
    private static final Integer successCode = 0;
    // 返回数据
    private T data;
    // 返回码
    private Integer status;
    // 返回描述
    private String msg;

    public Result() {
        this.status = successCode;
        this.msg = "success";
    }

    public Result(Integer code, String msg) {
        this();
        this.status = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this();
        this.status = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(T data) {
        this();
        this.data = data;
    }

}
