package com.learning.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.learning.models.Product;
import com.learning.repositories.ProductRepository;
import com.learning.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public boolean delete(int id) {
		try {
			productRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> condition1(boolean status) {
		return productRepository.condition1(status);
	}

	@Override
	public List<Product> condition2(double min, double max) {
		return productRepository.condition2(min, max);
	}

	@Override
	public List<Product> like(String keyword) {
		return productRepository.like(keyword);
	}

	@Override
	public List<Product> findByYear(int year) {
		return productRepository.findByYear(year);
	}

	@Override
	public List<Product> findByYearAndMonth(int year, int month) {
		return productRepository.findByYearAndMonth(year, month);
	}

	@Override
	public List<Product> findByYearAndMonthandDay(int year, int month, int day) {
		return productRepository.findByYearAndMonthandDay(year, month, day);
	}

	@Override
	public List<Product> findByDates(Date start, Date end) {
		return productRepository.findByDates(start, end);
	}

	@Override
	public List<Product> sortPriceDesc() {
		return productRepository.sortPriceDesc();
	}

	@Override
	public List<Product> sortWithCondition(boolean status) {
		return productRepository.sortWithCondition(status);
	}

	@Override
	public List<Product> limit1(int n) {
		return productRepository.limit1(n);
	}

	@Override
	public List<Product> limit2(int start, int n) {
		return productRepository.limit2(start, n);
	}

	@Override
	public List<Product> limit3(boolean status, int start, int n) {
		return productRepository.limit3(status, start, n);
	}

	@Override
	public long count1() {
		return productRepository.count();
	}

	@Override
	public long count2(boolean status) {
		return productRepository.count2(status);
	}

	@Override
	public long sum1() {
		return productRepository.sum1();
	}

	@Override
	public	double sum2(boolean status) {
		return productRepository.sum2(status);
	}
	
	@Override
	public double minPrice() {
		return productRepository.minPrice();
	}
	
	@Override
	public double maxPrice() {
		return productRepository.maxPrice();
	}
	
	@Override
	public double avgPrice() {
		return productRepository.avgPrice();
	}
	

}
