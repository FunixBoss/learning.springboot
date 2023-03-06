package com.learning.controllers.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@GetMapping("/login")
	public String login() {
		return "admin/login";  
	}
	
	@GetMapping({"", "/welcome"})
	public String welcome() {
		return "admin/welcome";
	}
	
	@PostMapping("/login/process")
	public String process(@RequestParam("username") String username, 
						@RequestParam("password") String password,
						HttpSession session,
						RedirectAttributes redirectAttributes) {
		System.out.println("username: " + username + "\tpassword: " + password);
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
			session.setAttribute("username_admin", username);
			return "redirect:/admin/welcome";
		} else {
			redirectAttributes.addFlashAttribute("msg", "Invalid");
			return "redirect:/admin/login";
		}
			
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username_admin");
		return "redirect:/admin/login";
	}
	
	
}
