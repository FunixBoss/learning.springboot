package com.learning.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.models.Product;
import com.learning.services.ProductService;

@Controller
@RequestMapping("demo")
public class DemoController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("index")
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "demo/index";
	}
	
	@GetMapping("index2")
	public String index2(ModelMap modelMap) {
		modelMap.put("product", productService.findById(3));
		return "demo/index2";
	}
	
	@GetMapping("index3")
	public String index3(ModelMap modelMap) {
		Product product = new Product();
		product.setCreated(new Date());
		product.setDescription("description of new product");
		product.setName("new product");
		product.setPrice(5.6);
		product.setQuantity(2);
		product.setStatus(true);
		product = productService.save(product); // save trả về chính product đó
		System.out.println("id: " + product.getId());
		
		return "redirect:/demo/index";
	}
	
	@GetMapping("index4")
	public String index4(ModelMap modelMap) {
		Product product = productService.findById(10);
		product.setCreated(new Date());
		product.setDescription("description of old product have been updated");
		product.setName("product have been updated");
		product.setPrice(10);
		product.setQuantity(10);
		product.setStatus(true);
		product = productService.save(product); // save trả về chính product đó
		System.out.println("id: " + product.getId());
		
		return "redirect:/demo/index";
	}
	
	@GetMapping("index5")
	public String index5(ModelMap modelMap) {
		System.out.println("delete: " + productService.delete(1));
		
		return "redirect:/demo/index";
	}
	
	@GetMapping("condition1")
	public String condition1(ModelMap modelMap) {
		modelMap.put("products", productService.condition1(false));
		return "demo/index";
	}
	
	@GetMapping("condition2")
	public String condition2(ModelMap modelMap) {
		modelMap.put("products", productService.condition2(5, 10));
		return "demo/index";
	}
	
	@GetMapping("like")
	public String like(ModelMap modelMap) {
		modelMap.put("products", productService.like("new"));
		return "demo/index";
	}
	
	@GetMapping("query1")
	public String query1(ModelMap modelMap) {
		modelMap.put("products", productService.findByYear(2023));
		return "demo/index";
	}
	
	@GetMapping("query2")
	public String query2(ModelMap modelMap) {
		modelMap.put("products", productService.findByYearAndMonth(2023, 2));
		return "demo/index";
	}
	
	@GetMapping("query3")
	public String query3(ModelMap modelMap) {
		modelMap.put("products", productService.findByYearAndMonthandDay(2023, 2, 28));
		return "demo/index";
	}
	
	@GetMapping("query4")
	public String query4(ModelMap modelMap) throws ParseException {
		String dateStartString = "1/1/2023";
        String dateEndString = "3/1/2023";
        SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
        Date start = format.parse(dateStartString);
        Date end = format.parse(dateEndString);
		modelMap.put("products", productService.findByDates(start, end));
		return "demo/index";
	}
	
	@GetMapping("sort1")
	public String sort1(ModelMap modelMap) {
		modelMap.put("products", productService.sortPriceDesc());
		return "demo/index";
	}
	
	@GetMapping("sort2")
	public String sort2(ModelMap modelMap) {
		modelMap.put("products", productService.sortWithCondition(false));
		return "demo/index";
	}
	
	@GetMapping("limit1")
	public String limit1(ModelMap modelMap) {
		modelMap.put("products", productService.limit1(5));
		return "demo/index";
	}
	
	@GetMapping("limit2")
	public String limit2(ModelMap modelMap) {
		modelMap.put("products", productService.limit2(3,5));
		return "demo/index";
	}
	
	@GetMapping("limit3")
	public String limit3(ModelMap modelMap) {
		modelMap.put("products", productService.limit3(true,3,5));
		return "demo/index";
	}
	
	@GetMapping("aggregate")
	public String aggregate(ModelMap modelMap) {
//		count
		modelMap.put("countDefault", productService.count1());
		modelMap.put("countByStatus", productService.count2(true));
		modelMap.put("status", true);
		
//		sum
		modelMap.put("sum1", productService.sum1());
		modelMap.put("sum2", productService.sum2(true));
		
//		min, max, avg
		modelMap.put("minPrice", productService.minPrice());
		modelMap.put("maxPrice", productService.maxPrice());
		modelMap.put("avgPrice", productService.avgPrice());
		
		return "demo/index3";
	}
	
	
	
}
