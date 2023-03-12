package com.learning.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInfoInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("url: " + request.getRequestURL().toString());
		System.out.println(" : " + request.getAuthType());
		System.out.println(" : " + request.getCharacterEncoding());
		System.out.println(" : " + request.getContentLength());
		System.out.println(" : " + request.getContentLengthLong());
		System.out.println(" : " + request.getContentType());
		System.out.println(" : " + request.getContextPath());
		System.out.println(" : " + request.getDateHeader(null));
		System.out.println(" : " + request.getHeader(null));
		System.out.println(" : " + request.getIntHeader(null));
		System.out.println(" : " + request.getLocalAddr());
		System.out.println(" : " + request.getLocalName());
		System.out.println(" : " + request.getLocalPort());
		System.out.println(" : " + request.getMethod());
		System.out.println(" : " + request.getParameter(null));
		System.out.println(" : " + request.getPathInfo());
		System.out.println(" : " + request.getPathTranslated());
		System.out.println(" : " + request.getProtocol());
		System.out.println(" : " + request.getParameterMap());
		System.out.println(" : " + request.getParameterNames());
		System.out.println(" : " + request.getParameterValues(null));
		System.out.println(" : " + request.getPart(null));
		System.out.println(" : " + request.getParts());
		System.out.println(" : " + request.getQueryString());

		return true;
	}
	
	

}
