package com.learning.services.impl;

import org.springframework.stereotype.Service;
import com.learning.services.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String hello() {
		return "Hello Services";
	}

	@Override
	public String hi(String name) {
		return "Hi " + name;
	}

}
