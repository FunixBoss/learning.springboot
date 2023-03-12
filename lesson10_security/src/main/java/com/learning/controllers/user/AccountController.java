package com.learning.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.models.Account;
import com.learning.services.AccountService;
import com.learning.services.RoleService;

@Controller
@RequestMapping({"account"}) 
public class AccountController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AccountService accountService; 
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping({"login"})
	public String login(@RequestParam(value = "error", required = false) String error,
						ModelMap modelMap) {
		if(error != null) {
			modelMap.put("msg", "Invalid!");
		}
		
		return "account/login";
	}
	
	@GetMapping({"register"})
	public String register(ModelMap modelMap) {
		modelMap.put("roles", roleService.findAll());
		Account account = new Account();
		account.setBirthday(new Date());
		modelMap.put("account", account);
		return "account/register";
	}
	
	@PostMapping({"register"})
	public String register(@ModelAttribute("account") Account account, 
							@RequestParam("roles") int[] roles) {
		account.setPassword(encoder.encode(account.getPassword()));
		accountService.save(account);
		
		// chuyện đăng ký mình làm
//		còn việc đăng nhập thì framework sẽ làm, khi mình bấm login thì chúng ta cần cung cấp
//		cho spring 1 tk -> có username, pass, roles là gì 
//		sau đó spring tự động kiểm tra tk đó có hợp lệ hay ko, có quyền như vậy có được truy xuất vào hàm (đường dẫn) mình khai báo trc hay ko
//		(việc này fw lo)
//		 việc của mình là cung cấp cho nó tk nào
		return "redirect:/account/login";
	}
	
	@GetMapping("welcome")
	public String welcome(Authentication authentication) {
		System.out.println("======Authentication infomation===================================");
		System.out.println("username: " + authentication.getName());
		System.out.println("authorities: " + authentication.getAuthorities());
		System.out.println("credentials: " + authentication.getCredentials());
		System.out.println("details: " + authentication.getDetails());
		System.out.println("printcipal: " + authentication.getPrincipal());
		System.out.println("==================================================================");
		return "account/welcome";
	}
	
	@GetMapping("logout")
	public String logout() {		
		
		return "redirect:/account/login";
	}
	
	@GetMapping({"profile"})
	public String profile(ModelMap modelMap, Authentication authentication) {
		modelMap.put("roles", roleService.findAll());
		modelMap.put("account", accountService.findByUsername(authentication.getName()));
		
		return "account/profile";
	}
	
	@PostMapping({"profile"})
	public String profile(@ModelAttribute("account") Account account, @RequestParam("roles") int[] roles) {
		if(account.getPassword().isEmpty()) {
			account.setPassword(accountService.findByUsername(account.getUsername()).getPassword());
		} else {
			account.setPassword(encoder.encode(account.getPassword()));
		}
		
		accountService.save(account);
		return "redirect:/account/login";
	}
	
	@GetMapping("accessDenied")
	public String accessDenied() {
		return "account/accessDenied";
	}
	
	
}	
