package com.learning.interceptors;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Log1Interceptor implements HandlerInterceptor{

//	return true -> request sẽ chuyển vào Interceptor ở phía sau hoặc Controller để thực hiện
//	return false -> request sẽ bị dừng ở Interceptor
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// gửi giá trị cho các interceptor khác
		request.setAttribute("id", 123); 
		request.setAttribute("username", "acc1");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("date: " + simpleDateFormat.format(new Date()));
		return true;
	}
	
	

}
