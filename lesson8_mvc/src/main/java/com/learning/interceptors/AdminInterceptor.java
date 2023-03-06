package com.learning.interceptors;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		if(request.getSession().getAttribute("username_admin") == null) {
			response.sendRedirect("/admin/login");
			return false;
		}
			
		return true;
	}
	
	

}
