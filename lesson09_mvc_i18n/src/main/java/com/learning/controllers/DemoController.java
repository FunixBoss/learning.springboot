package com.learning.controllers;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "demo"})
public class DemoController {

	@Autowired
	private MessageSource messageSource;
	
//	Locale -> tự biết ngôn ngữ là gì (do đã cấu hình)
	@GetMapping({"", "index"})
	public String index(Locale locale, ModelMap modelMap) {
		System.out.println("language id: " + locale.getLanguage());
		System.out.println("country id: " + locale.getCountry());
		
		String msg = messageSource.getMessage("msg", null, locale);
		System.out.println("msg: "  + msg);
		
//		with parameter
		String msg2 = messageSource.getMessage("msg2", new Object[] {123, 23}, locale);
		System.out.println("msg2: " + msg2);
	
//		tùy ngôn ngữ là gì mà mình format theo nó
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
		System.out.println("date: " + dateFormat.format(new Date()));
		modelMap.put("today", new Date());
		
//		Tiền tệ
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println("currency: " + currencyFormat.format(123456));
		modelMap.put("currency", 1234567);
		
//		số
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		System.out.println("number: " + numberFormat.format(1234567));
		modelMap.put("number", 1234567);
		
		NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);
		System.out.println("percent: " + percentFormat.format(34.56));
		modelMap.put("percent", 34.56);
		
		return "demo/index";
	}
	
	
}
