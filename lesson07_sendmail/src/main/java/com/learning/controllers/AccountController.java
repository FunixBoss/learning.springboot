package com.learning.controllers;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.models.Account;
import com.learning.services.AccountService;
import com.learning.services.MailService;

@Controller
@RequestMapping({"", "account"})
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private Environment environment; // get information from application.properties 
	
	@GetMapping({"register"})
	public String register(ModelMap modelMap) {
		modelMap.put("account", new Account());
		return "account/register";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute("account") Account account, RedirectAttributes redirectAttributes) {
		try {
			
			String password = account.getPassword();
			account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
			account.setStatus(false);
			String securityCode = UUID.randomUUID().toString().replace("-", "");
			account.setSecurityCode(securityCode);
			accountService.save(account);	
			
//			Send mail
//			verify include: email nao`, ma kich hoat la gi
			String from = environment.getProperty("spring.mail.username");
			String content ="<a href='http://localhost:9090/account/verify?email=" + account.getEmail() 
							+ "&securityCode=" + securityCode + " '>Verify</a>";
			
			mailService.send(from, account.getEmail(), "Verify", content);
			
			return "account/login";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("msg", "register failed");
			return "account/register";
		}
	}
	
	@GetMapping("login")
	public String login() {
		return "account/login"; 
	}
	
	@PostMapping("login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes,
			HttpSession session) {
		if(accountService.login(username, password) == null) {
			redirectAttributes.addFlashAttribute("msg", "Invalid");
			return "redirect:/account/login";
		} else {
			session.setAttribute("username", username);
			return "redirect:/account/welcome";
		}
	}
	
//	http://localhost:9090/account/verify?email=nguyenphu1147@gmail.com&securityCode=a4cb4d9b3f2c4e6daa4c609e47fd079f
	@GetMapping("verify")
	public String verify(@RequestParam("email") String email, 
						@RequestParam("securityCode") String securityCode,
						RedirectAttributes redirectAttributes) {
		Account account = accountService.findByEmail(email);
		if(account.getSecurityCode().equals(securityCode)) {
			account.setStatus(true);
			accountService.save(account);
			redirectAttributes.addFlashAttribute("msg", "Verified Email Successfully!");
		} 
		return "redirect:/account/login";
	}
	
	@GetMapping("welcome")
	public String welcome() {
		return "account/welcome";
	}
	
	@GetMapping("forgetPassword")
	public String forgetPassword() {
		return "account/forgetPassword";
	}
	
	@PostMapping("forgetPassword")
	public String forgetPassword(@RequestParam("email") String email,
				RedirectAttributes redirectAttributes) {
		Account account = accountService.findByEmail(email);
		try {
			if(account == null) {
				redirectAttributes.addFlashAttribute("msg", "invalid email");
			} else {
				String securityCode = UUID.randomUUID().toString().replace("-", "");
				account.setSecurityCode(securityCode);
				accountService.save(account);
				
//				Send mail
//				verify include: email nao`, ma kich hoat la gi
				String from = environment.getProperty("spring.mail.username");
				String content ="<a href='http://localhost:9090/account/resetPassword?email=" + email 
								+ "&securityCode=" + securityCode + " '>Reset Password</a>";
				
				mailService.send(from, email, "ResetPsasword", content);
				redirectAttributes.addFlashAttribute("msg", "Sent");

				return "account/forgetPassword";
			}
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "invalid email");
		}
		return "redirect:/account/forgetPassword";
	}
	
	@GetMapping("resetPassword")
	public String resetPassword(ModelMap modelMap, 
	                            @RequestParam("email") String email,
	                            @RequestParam("securityCode") String securityCode,
	                            RedirectAttributes redirectAttributes){
	    Account account = accountService.findByEmail(email);
	    
	    if (account == null || !account.getSecurityCode().equals(securityCode)) {
	        // Account not found or security code doesn't match, return error message
	    	redirectAttributes.addFlashAttribute("msg", "the email does not exists");
	        return "redirect:/account/forgetPassword";
	    }
	    
	    System.out.println(account);
	    modelMap.addAttribute("tempAccount", account);
	    
	    return "account/resetPassword";
	}

	@PostMapping("resetPassword")
	public String resetPassword(@RequestParam("email") String email,
								@RequestParam("securityCode") String securityCode,
								@RequestParam("password") String password,
								RedirectAttributes redirectAttributes) {

	    Account account = accountService.findByEmail(email);
	    if (account == null || !account.getSecurityCode().equals(securityCode)) {
	        // Account not found or security code doesn't match, return error message
	        redirectAttributes.addFlashAttribute("msg", "Invalid reset link");
	        return "redirect:/account/resetPassword";
	    }

	    account.setStatus(true);
	    System.out.println("email: " + email + "\tpassword: " + password);
	    account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
	    accountService.save(account);

	    redirectAttributes.addFlashAttribute("msg", "Reset Password Successfully!");
	    return "redirect:/account/login";
	}
}
