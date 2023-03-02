package com.learning.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.models.Employee;
import com.learning.validators.EmployeeValidators;

import jakarta.validation.Valid;

@Controller
@RequestMapping({"employee"})
public class EmployeeController{

	@Autowired
	private EmployeeValidators employeeValidator;
	
	@GetMapping({"", "/register"})
	public String register(ModelMap modelMap) {
		modelMap.put("employee", new Employee());
		return "employee/register";
	}
	
	
//	@Valid ==> cần validate cho đối tượng đó
//	Binding Result -> chứa thông báo lỗi
	@PostMapping("register")
	public String register(@ModelAttribute("employee") @Valid Employee employee, 
								BindingResult bindingResult) {
//		nếu có lỗi thì bỏ zo bindingResult để hứng cái lỗi
		employeeValidator.validate(employee, bindingResult);
		if(bindingResult.hasErrors()) {
			return "employee/register";
		}
		
		System.out.println("Employee info");
		System.out.println("Username: " + employee.getUsername());
		System.out.println("password: " + employee.getPassword());
		return "employee/success";
	}

}
