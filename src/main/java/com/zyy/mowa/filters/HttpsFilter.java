package com.zyy.mowa.filters;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



/**
 *  过滤器，将http 请求转发到https请求上来
 *  重定向类型：307
 * 
 *
 */
@WebFilter(filterName="HttpsFilter",urlPatterns="/*")
public class HttpsFilter implements Filter{
    private Logger logger = LoggerFactory.getLogger(HttpsFilter.class);
    private static final String HTTPS ="https";
    @Value("${server.port}")
    private int HTTPS_PORT;
    private String url;
    @Override
    public void destroy() {
        logger.info("------------destroy HttpsFilter --------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
         URL newUrl = null;
       if(request.getScheme().equals(HTTPS)) {
            chain.doFilter(request, response);
         }else {
             HttpServletRequest httpRequest = (HttpServletRequest)request;
             HttpServletResponse httpResponse = (HttpServletResponse)response;
             String queryString = httpRequest.getQueryString()==null ? "":"?"+httpRequest.getQueryString();
             httpResponse.setStatus(307);
             String requestUrl = httpRequest.getRequestURL().toString();
             URL reqUrl = new URL(requestUrl+queryString);
             logger.info("【original request-】 "+reqUrl.toString());
             newUrl = new URL(HTTPS,reqUrl.getHost(),HTTPS_PORT,reqUrl.getFile());
             //进行重定向
             logger.info("【new request-】 "+newUrl.toString());
             httpResponse.setHeader("Location", newUrl.toString());
             httpResponse.setHeader("Connection", "close");
             //允许所有跨域请求
             //httpResponse.addHeader("Access-Control-Allow-Origin", "*");     
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      

        logger.info("------------init HttpsFilter --------------");

    }

}