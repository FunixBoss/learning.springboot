package com.learning.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.models.Product;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({ "/", "abc", "def", "xyz" })
public class HomeController  {

	@GetMapping({ "", "index", "home" })
	public String home() {

		return "demo/index";
	}

	@RequestMapping(value = "index2", method = RequestMethod.GET)
	// ModelMap -> truyền dữ liệu
	public String index2(ModelMap modelMap) {
		modelMap.put("id", 123);
		modelMap.put("username", "acc1");
		modelMap.put("product", new Product("pd01", "bcs", 5.3));
		List<Product> products = new ArrayList<>();
		products.add(new Product("pd2", "socala", 213));
		products.add(new Product("pd3", "candies", 231));
		products.add(new Product("pd4", "socket", 132));
		modelMap.put("products", products);
		return "demo/index2";
	}

	@RequestMapping(value = "index3/{id}", method = RequestMethod.GET)
	public String index3(@PathVariable("id") int id) {
		System.out.println(id);

		return "demo/index3";

	}

	@RequestMapping(value = "index3/{name}/{id}", method = RequestMethod.GET)
	public String index3(@PathVariable("name") String name, @PathVariable("id") int id) {
		System.out.println(id + " - " + name);

		return "demo/index3";
	}

//	Read parameter from Query String 
//	http://localhost:9090/abc/index4?id=123&name=abc
	@RequestMapping(value = "index4", method = RequestMethod.GET)
	public String index4(@RequestParam("id") int id, @RequestParam("name") String name) {
		System.out.println(id + " - " + name);

		return "demo/index4"; 

	}
 
//	Query String second way
	@RequestMapping(value = "index5", method = RequestMethod.GET)
	public String index5(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		System.out.println(id + " - " + name);

		return "demo/index5";

	}

}
