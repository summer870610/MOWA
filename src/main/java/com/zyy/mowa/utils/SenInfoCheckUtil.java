package com.zyy.mowa.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.zyy.mowa.constant.GeneralToken;




public class SenInfoCheckUtil {
	
	    private static final String RESPONSE_SUCCEED="0";  //返回结果 code
	    
	    private static final String WX_API_TOKEN="WX_API_TOKEN";   //缓存KEY
	    
	    private static final long TOKEN_TIME_OUT_SECOND=60*60*1;	//1小时   //官方2小时失效
	    
	  
	    
	  
	    
	    /**
	     * 获取微信 API TOKEN校验
	     * @return
	     */
	    public static String getWxToken(){
	    String token="";
		    	String url ="https://api.weixin.qq.com/cgi-bin/token";
		    	StringBuffer stringBuffer=new StringBuffer(url);
		    	Map<String,String> map=new HashMap<>();

		    	map.put("grant_type", JwtUtils.GRANT_TYPE);
		    	map.put("appid", JwtUtils.WX_APPID);
   	    	    map.put("secret", JwtUtils.WX_SECRET);
		    	
		    	Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
				if (iterator.hasNext()) {
				    stringBuffer.append("?");
				    while (iterator.hasNext()) {
					    Map.Entry<String, String> entry = iterator.next();
					    //过滤value为null，value为null时进行拼接字符串会变成 "null"字符串
					    if (entry.getValue() != null) {
					    stringBuffer.append(entry).append("&");
				    }
				    url = stringBuffer.substring(0, stringBuffer.length() - 1);
				    }
				}
				RestTemplate restTemplate = new RestTemplate();
		    	GeneralToken responseEntity = restTemplate.getForObject(url, GeneralToken.class);
		    	token = responseEntity.getAccess_token();
		    	
	    	return token;
	    }
	    
	    

	    /**
	     * 校验 文本内容是否违规
	     * @return
	     */
	    public static boolean toCheckText(String content,String token){
	    	String url ="https://api.weixin.qq.com/wxa/msg_sec_check?access_token="+token;
	        //header参数
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        
	        //放入body中的json参数
	        JSONObject obj = new JSONObject();
	        obj.put("content", content);

	        //组装
	        HttpEntity<JSONObject> request = new HttpEntity<>(obj, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<JSONObject> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, JSONObject.class);
	        JSONObject json = responseEntity.getBody();
	        if(RESPONSE_SUCCEED.equals(json.getString("errcode"))){
	        	return true;
	        }
	        return false;
	    }
	    
	    /**
	     * 校验 图片内容是否违规
	     * @return
	     * @throws IOException 
	     */
	    public static boolean toCheckImg(MultipartFile file,String token) throws IOException{
	    	String url ="https://api.weixin.qq.com/wxa/img_sec_check?access_token="+token;
	    	
	        //header参数
	        HttpHeaders headers = new HttpHeaders();
	        MediaType type = MediaType.parseMediaType("multipart/form-data");
	        headers.setContentType(type);
	              
	        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
	        map.add("media", file.getResource());
	        
	        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
	        RestTemplate restTemplate = new RestTemplate();
	        JSONObject json = restTemplate.postForObject(url, request, JSONObject.class);
	        if(RESPONSE_SUCCEED.equals(json.getString("errcode"))){
	        	return true;
	        }
	        return false;
	    }
	
}
