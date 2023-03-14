package com.learning.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocaleConfiguration implements WebMvcConfigurer{

//	Đọc file messages.properties
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		source.setDefaultEncoding("UTF-8");
		return source;
	}
	
	
//	Lưu trữ lại Session ngta đang chọn cái ngôn ngữ đó
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
			
		return resolver;
	}
	
//	phát hiện kiểm tra trên đường dẫn -> set ngôn ngữ 
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName("lang");
		return changeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		mỗi lần có request thì truyền vào interceptor này, phát hiện query string là lang (Bean 3)
//		sau đó, tự động khởi gán SessionLocaleResolver, chứa ngôn ngữ đang được chọn (Bean 2)
//		đồng thời, nó tự biết lấy thông minh từ file properties nào ra (Bean 1)
		registry.addInterceptor(localeChangeInterceptor());
	}

		
}
