package com.learning.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

// spring tự động đọc class khi chạy chương trình 
// đọc cấu hình khai báo
@Configuration
public class ValidationConfiguration {

//	 Bean -> mục đích: đối tượng tham gia vào quá trình xử lý của fw 
//	khi làm việc thì mình chỉ cần khai báo đối tượng, fw sẽ khởi gán và xử lý hành động tiếp theo
	
//	giả sử mình cần đọc thông báo lỗi từ error.properties
//	-> chỉ cần khai báo đối tượng chỉ ra là khi có lỗi thì zo error.properties
//	-> còn việc đọc file ntn, nó lấy thông tin ra sao, thì fw lo
//	-> nhiệm vụ của mình chỉ là khai báo
	

//	nên bik mình làm gì, và fw làm gì
	@Bean // fw lấy đối tượng xử lý hành động tiếp theo của fw 
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("errors"); // => chỉ ra tên file
		return source;
	}
	
	
	
	
}
