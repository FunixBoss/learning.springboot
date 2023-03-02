package com.learning.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.learning.models.Employee;

@Component
public class EmployeeValidators implements Validator{

//	method này kiểm tra đối tượng mình validate xem đúng class mình cần hay không
//	giả sử kiểm tra Employee mà trả zo Product thì bỏ qua 
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Employee.class);
	}

//	nơi mà viết thêm nữa custom validate 
//	đọc annotation trên field của class Employee, và trả về lỗi trong error.properties
	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		if(employee.getUsername().equalsIgnoreCase("abc")) {
			errors.rejectValue("username", "exists");
		}
	}
	
}
