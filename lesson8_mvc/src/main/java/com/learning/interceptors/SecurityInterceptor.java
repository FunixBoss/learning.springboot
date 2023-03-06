package com.learning.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// còn tồn tại
		if(request.getAttribute("id") != null) {
			int id = Integer.parseInt(request.getAttribute("id").toString());
			System.out.println("id - securityInterceptor: " + id );
			request.removeAttribute("id");
		}
		
		boolean status = true;
		if(status) {
			return true;
		}
		return false;
	}
	
	

}
