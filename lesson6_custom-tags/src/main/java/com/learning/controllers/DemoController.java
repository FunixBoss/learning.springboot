package com.learning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "demo"})
public class DemoController {

	@GetMapping({"index", ""})
	public String index() {
		return "demo/index";
	}
	
}
