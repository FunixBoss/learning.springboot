package com.learning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.models.Product;
import com.learning.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Override
	public Product find() {
		return new Product("p1", "product 01", 123.12D, "thumb1.jpg", "food");
	}

	@Override
	public List<Product> findAll() {
		return new ArrayList<Product>() {
			{
				add(new Product("p1", "product 01", 123.12D, "thumb1.jpg", "food"));
				add(new Product("p2", "product 02", 124.12D, "thumb1.jpg", "food"));
				add(new Product("p3", "product 03", 125.12D, "thumb1.jpg", "food"));
				add(new Product("p4", "product 04", 126.12D, "thumb1.jpg", "food"));
			}
		};
	}
}
