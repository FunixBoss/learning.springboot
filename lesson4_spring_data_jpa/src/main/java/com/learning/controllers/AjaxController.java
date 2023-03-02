package com.learning.controllers;

import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.models.Product;
import com.learning.services.ProductService;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "search", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<String> search(@RequestParam("term") String term){
		return productService.searchByKeyword(term);
	}
	
	@GetMapping(value = "search2", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public List<Product> search2(@RequestParam("keyword") String keyword){
		return productService.like(keyword);
	}
}
