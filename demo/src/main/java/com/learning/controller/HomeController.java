package com.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learning.entity.Person;

@Controller
public class HomeController {

	private static List<Person> persons = new ArrayList<>();
	static {
		persons.add(new Person("abc", 1));
		persons.add(new Person("xyz", 2));
	}

	@GetMapping("/addPerson")
	public String showAddPersonPage(Model model) {
		Person personForm = new Person();
		model.addAttribute("personForm", personForm);
		return "form";
		
	}
	
	@PostMapping("/addPerson")
	public String savePerson(Model model, @ModelAttribute("personForm") Person personForm) {
		String name = personForm.getName();
		Integer age = personForm.getAge();
		
		if(name == null || name.length() <= 0 
				|| age == null || age <= 0) {
			model.addAttribute("errorMessage", "Error");
			return "form";
		}
		
		persons.add(personForm);
		return "redirect:/index" ;
		
	}

	@GetMapping({"/index", "/"})
	public String welcome(final Model model) {
		model.addAttribute("persons", persons);
		model.addAttribute("message", "hello");
		return "index";
	}

	@RequestMapping("/hi/{param}")
	@ResponseBody
	public String hello(@PathVariable("param") String param) {
		String response = "Hello " + param;
		return response;
	}
}
