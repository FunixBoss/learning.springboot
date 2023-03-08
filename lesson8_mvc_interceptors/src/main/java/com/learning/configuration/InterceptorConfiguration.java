package com.learning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learning.interceptors.AdminInterceptor;
import com.learning.interceptors.Log1Interceptor;
import com.learning.interceptors.Log2Interceptor;
import com.learning.interceptors.Log3Interceptor;
import com.learning.interceptors.Log4Interceptor;
import com.learning.interceptors.SecurityInterceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{

	@Autowired
	private Log1Interceptor log1Interceptor;
	
	@Autowired
	private Log2Interceptor log2Interceptor;
	
	@Autowired
	private Log3Interceptor log3Interceptor;
	
	@Autowired
	private Log4Interceptor log4Interceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private SecurityInterceptor securityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	////		add interceptors, theo thứ tự
	//		registry.addInterceptor(log1Interceptor);
	//		// nếu securityInterceptor.addInterceptors = false thì sẽ ko chạy qua các interceptor tiếp theo
	//		registry.addInterceptor(securityInterceptor); 
	//		registry.addInterceptor(log2Interceptor);
	//		registry.addInterceptor(log3Interceptor);
	//		
	//		// chi zo 1 so page nhat dinh
	//		registry.addInterceptor(log4Interceptor).addPathPatterns("/demo/index4", "");
		
//		phải thêm exclude admin/login, nếu ko nó sẽ bị vòng lặp
		registry.addInterceptor(adminInterceptor)
				.addPathPatterns("/admin/**")
				.excludePathPatterns("/admin/login", "/admin/login/index", "/admin/login/process");
		
//		Nâng cao nữa là kết hợp với Security & và làm I18n
	}
	
}
