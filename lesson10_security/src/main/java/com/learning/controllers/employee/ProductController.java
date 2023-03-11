package com.learning.controllers.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"employee/product"})
public class ProductController {

	@GetMapping({"", "index"})
	public String index() {
		return "employee/product/index";
	}
}
