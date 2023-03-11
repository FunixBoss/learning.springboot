package com.learning.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"about"})
public class AboutUsController {

	@GetMapping({"", "index"})
	public String index() {
		return "user/aboutus/index";
	}
}
