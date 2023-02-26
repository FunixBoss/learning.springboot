package com.learning.services.impl;

import org.springframework.stereotype.Service;

import com.learning.services.CalculateService;

@Service
public class CalculateServiceImpl implements CalculateService {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

	@Override
	public double mul(double a, double b) {
		return a*b;
	}

}
