package com.learning.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.models.Product;
import com.learning.service.ProductService;

// những hàm bên trong sẽ tạo ra 1 chuỗi hoặc json hoặc giá trị nào đso
// còn @Controller sẽ tra về đường dẫn

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "ajax1", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax1() {
		return "Hello ajax world!";
	}

//	http://localhost:9090/ajax/ajax1?fullname=a -> Query String
	@GetMapping(value = "ajax2", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax2(@RequestParam("fullname") String fullname) {
		
		return "Hello " + fullname;
	}
	
	@PostMapping(value = "ajax3", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public String ajax3(@RequestParam("fullname") String username, @RequestParam("password") String password) {
		
		if(username.equalsIgnoreCase("abc") && password.equalsIgnoreCase("123")) {
			return "Valid";
		} 
		return "Invalid";
	}
	
	@GetMapping(value="ajax4", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public Product ajax4() {
		return productService.find();
	}
	
	@GetMapping(value="ajax5", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<Product> ajax5() {
		return productService.findAll();
	}
	
	
	
}
