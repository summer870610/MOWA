package com.zyy.mowa.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zyy.mowa.utils.SenInfoCheckUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin
@Api(tags = "校验敏感信息(内容、图片)对外接口")
@RestController
@RequestMapping("api/Check")
public class CheckController {
	/**
     * 校验内容
     * @param content
     * @return
     * @throws IOException
     */
	@ApiOperation(value = "校验文本")
    @GetMapping("/content/{content}")
    public Boolean checkContent(@PathVariable String content) {
        String accessToken = SenInfoCheckUtil.getWxToken();
        return SenInfoCheckUtil.toCheckText(content, accessToken);
    }

    /**
     * 校验图片
     * @param multipartFile
     * @return
     * @throws IOException 
     */
	@ApiOperation(value = "校验图片")
    @PostMapping("/image")
    public boolean checkImage(@RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        String accessToken = SenInfoCheckUtil.getWxToken();
      
			return SenInfoCheckUtil.toCheckImg(multipartFile, accessToken);
		
    }
}
