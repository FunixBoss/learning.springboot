package com.learning.services;

import com.learning.models.Product;

public interface ProductService {
	Iterable<Product> findAll();
	Product findById(int id);
}
