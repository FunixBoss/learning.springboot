package com.learning.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.services.DatabaseService;
import com.learning.services.DemoService;
import com.learning.services.ProductService;
import com.learning.services.RectangleService;

@Controller
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RectangleService ractangleSerivce;
	
	@Autowired
	@Qualifier(value = "mySQLDatabaseService")
	private DatabaseService dbService;
	
	@GetMapping("/")
	public String home(ModelMap modelMap) {
		modelMap.put("result1", demoService.hello());
		modelMap.put("result2", demoService.hi("Phu"));
		modelMap.put("product", productService.findById());
		modelMap.put("area", ractangleSerivce.area(2, 5));
		modelMap.put("dbService", dbService.findAll());
		return "demo/index";
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "demo/index2" ; 
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword) {
		System.out.println("keyword: " +  keyword);
		return "redirect:/index2";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		return "redirect:/index2";
	}
	
	@PostMapping("/update")
	public String update(@RequestParam("email") String[] emails, @RequestParam int[] quantity) {
		List<String> emailsList = Arrays.asList(emails);
		String emailStr = emailsList.stream().collect(Collectors.joining(", "));
		System.out.println(emailStr);
		
		for(int qtt : quantity) {
			System.out.println("Quantity: " + qtt);
		}
		
		return "redirect:/index2";
	}
}
