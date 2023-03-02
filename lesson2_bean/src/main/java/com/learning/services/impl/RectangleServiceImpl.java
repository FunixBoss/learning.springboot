package com.learning.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.services.CalculateService;
import com.learning.services.RectangleService;

@Service
public class RectangleServiceImpl implements RectangleService {

	@Autowired
	private CalculateService calcService;
	
	@Override
	public double area(double a, double b) {
		return calcService.mul(a, b);
	}

	@Override
	public double perimeter(double a, double b) {
		return calcService.add(a, b) * 2;
	}
	
	
}
