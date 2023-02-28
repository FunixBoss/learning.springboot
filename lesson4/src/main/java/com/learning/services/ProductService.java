package com.learning.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.learning.models.Product;

public interface ProductService {
	
	Iterable<Product> findAll();
	
	Product findById(int id);
	
	Product save(Product product);
	
	boolean delete(int id);
	
	long count1();
	
	List<Product> condition1(boolean status);
	
	List<Product> condition2(double min, double max);
	
	List<Product> like(String keyword);
	
	List<Product> findByYear(int year);
	
	List<Product> findByYearAndMonth(int year, int month);
	
	List<Product> findByYearAndMonthandDay(int year, int month, int day);
	
	List<Product> findByDates(Date start, Date end);

	List<Product> sortPriceDesc();
	
	List<Product> sortWithCondition(boolean status);
	
	List<Product> limit1(int n);
	
	List<Product> limit2(int start, int n);

	List<Product> limit3(boolean status, int start, int n);

	long count2(boolean status);
	long sum1();
	double sum2(boolean status);
	double minPrice();
	double maxPrice();
	double avgPrice();
}
