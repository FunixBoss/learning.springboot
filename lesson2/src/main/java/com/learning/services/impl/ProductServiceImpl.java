package com.learning.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.models.Product;
import com.learning.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product findById() {
		return new Product("p01", "Bcs", 5.6, "asd", "asd");
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<>();
		products.add(new Product("p01", "condomA", 123, "condomA.gif", "t1"));
		products.add(new Product("p02", "condomB", 123, "condomB.gif", "t2"));
		products.add(new Product("p03", "condomC", 123, "condomA.gif", "t3"));
		products.add(new Product("p04", "condomD", 123, "condomB.gif", "t4"));
		products.add(new Product("p05", "condomE", 123, "condomA.gif", "t5"));

		return null;
	}

}
