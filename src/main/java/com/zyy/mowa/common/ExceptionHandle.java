package com.zyy.mowa.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyy.mowa.constant.ExceptionEnum;
import com.zyy.mowa.dto.Result;
import com.zyy.mowa.utils.ResultUtil;

/**
 * @author USER
 * @date 2020/05/25
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Exception e) {
        if (e instanceof DescribeException) {
            DescribeException myException = (DescribeException)e;
            return ResultUtil.error(myException.getCode(), myException.getMessage());
        }

        LOGGER.error("【系统异常】:{}", e);
        return ResultUtil.error(ExceptionEnum.UNKNOW_ERROR);
    }
}
