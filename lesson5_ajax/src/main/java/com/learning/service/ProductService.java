package com.learning.service;

import java.util.List;

import com.learning.models.Product;

public interface ProductService {
	
	public Product find();
	
	public List<Product> findAll();
}
