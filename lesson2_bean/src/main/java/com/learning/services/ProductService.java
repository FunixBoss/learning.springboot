package com.learning.services;

import java.util.List;

import com.learning.models.Product;

public interface ProductService {
	Product findById();
	
	List<Product> findAll();
}
