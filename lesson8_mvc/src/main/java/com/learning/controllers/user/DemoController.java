package com.learning.controllers.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "demo"})
public class DemoController {
	
	@GetMapping({"", "index"})
	public String index() {
		return "demo/index";
	}
	
	@GetMapping("index2")
	public String index2(HttpServletRequest request) {
		if(request.getAttribute("username") != null) {
			String username = request.getAttribute("username").toString();
			System.out.println("username - DemoController: " + username);
		}
		return "demo/index2";
	}
	
	@GetMapping("index3")
	public String index3() {
		return "demo/index3";
	}
	
	@GetMapping("index4")
	public String index4() {
		return "demo/index4";
	}
}
