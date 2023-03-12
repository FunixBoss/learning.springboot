package com.learning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.learning.services.AccountService;


@EnableWebSecurity // for security, một số hàm sẽ Extend class cũ, còn mới nhất sẽ xài annotation này
@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private AccountService accountService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		// mình muốn chặn 1 số phương thức tấn công cơ bản
		// 1. giả sử 1 web khác, submit 1 form qua cái web của mình => khóa lại
		http.cors().and().csrf().disable(); // submit trang khác qua trang mình là chặn hết, và 1 số cái khác
		// Ban đầu ko setting thì sẽ tự động redirect all requests đến login page
		// nếu thêm dòng này ý chỉ báo cho spring security biết là mình muốn tự custom lại 
		// -> do đó tất cả request sẽ trở lại bth
		
		
//		custom
		// những đường link bắt đầu bằng home thì cho xài
		http.authorizeRequests()
			.antMatchers("/home/**", "/about/**").permitAll()
			.antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')") // hasRole() do spring cung cấp, trả về 403 Unauthorized
			.antMatchers("/admin/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
			.antMatchers("/employee/**").access("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
			.and()
			
//			===== login =========
			.formLogin().loginPage("/account/login") // nếu ko có quyền thì sẽ redirect tới trang này
			.usernameParameter("username") // chỉ ra field input có name = username
			.passwordParameter("password") // chỉ ra field input có name = password
			.loginProcessingUrl("/account/processLogin") // đường link sẽ xử lý khi bấm nút login
			.failureUrl("/account/login?error") // nếu đăng nhập thất bại thì trả về trang nào
			.defaultSuccessUrl("/account/welcome") // nếu đăng nhập thành công thì đi vào trang này
			// lấy ra đối tượng đang đăng nhập có 2 dạng
			// 1. ${pageContext.request.userPrincipal.name} -> trả về username
			// 2. dùng obj Authentication trong controller
			.and()
			.logout().logoutUrl("/account/logout")
			.logoutSuccessUrl("/account/login")
			.and()
			.exceptionHandling().accessDeniedPage("/account/accessDenied") // khi ko có quyền truy cập
			;
		return http.build();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
//	mục đích: chỉ spring biết, khi người dùng nhấn vào nút login khi người dùng bấm vào đg dẫn login đã khai báo
//	=> hãy kiếm vào cái service nào để xử lý hành động login
//	(fw đã tự động so sánh username = username, password = password)
//	mình chỉ cung cấp service nào để nó xử lý ==> AccountService
	@Autowired // chích đối tượng builder
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		// nhận vào UserDetailService ==> chạy hàm loadUserByUsername
		builder.userDetailsService(accountService); // nhận vào User của UserDetailService 
		
//		Nếu đăng nhập thất bại có xuất hiện query string login?error 
//		=> http://localhost:9090/account/login?error
		
		
	}
}
