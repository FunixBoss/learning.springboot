package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.services.ProductService;

@Controller
@RequestMapping({"product"})
public class ProductController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"", "index"})
	public String index(ModelMap modelMap) {
		String authtoken = environment.getProperty("paypal.authtoken");
		System.out.println(authtoken);
		modelMap.put("products", productService.findAll());
		
		return "product/index";
	}
	
	
	
	
}
