package com.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.models.Contact;
import com.learning.services.MailService;

@Controller
@RequestMapping({"/", "contact"})
public class ContactController {

	
	@Autowired
	private MailService mailService;
	
	@GetMapping({"index", ""})
	public String index(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact/index";
	}
	
	@PostMapping("send")
	public String send(@ModelAttribute("contact") Contact contact, RedirectAttributes redirectAttributes) {
		try {
			String content = "Fullname: " + contact.getFullname();
			content += "<br/>Phone: " + contact.getPhone();
			content += "<br/>Email: " + contact.getEmail();
			content += "<br/>Content: " + contact.getContent();
			System.out.println(contact.getSubject());
			mailService.send(contact.getEmail(), "nguyenphu1147@gmail.com", contact.getSubject(), content);
			
			redirectAttributes.addFlashAttribute("msg", "Sent");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "Failed");

		}
		return "redirect:/contact/index";
	}
	
	@GetMapping({"index2", ""})
	public String index2(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact/index2";
	}
	
	@PostMapping("send2")
	public String send2(@ModelAttribute("contact") Contact contact,
			@RequestParam("file") MultipartFile multipartFile,
			RedirectAttributes redirectAttributes) {
		try {
			String content = "Fullname: " + contact.getFullname();
			content += "<br/>Phone: " + contact.getPhone();
			content += "<br/>Email: " + contact.getEmail();
			content += "<br/>Content: " + contact.getContent();
			System.out.println(contact.getSubject());
			mailService.sentWithFile(contact.getEmail(), "nguyenphu1147@gmail.com", 
					contact.getSubject(), content, multipartFile);
			
			redirectAttributes.addFlashAttribute("msg", "Sent");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "Failed");

		}
		return "redirect:/contact/index2";
	}
	
	@GetMapping({"index3", ""})
	public String index3(ModelMap modelMap) {
		modelMap.put("contact", new Contact());
		return "contact/index3";
	}
	
	@PostMapping("send3")
	public String send3(@ModelAttribute("contact") Contact contact,
			@RequestParam("files") MultipartFile[] multipartFiles,
			RedirectAttributes redirectAttributes) {
		try {
			String content = "Fullname: " + contact.getFullname();
			content += "<br/>Phone: " + contact.getPhone();
			content += "<br/>Email: " + contact.getEmail();
			content += "<br/>Content: " + contact.getContent();
			System.out.println(contact.getSubject());
			mailService.sentWithFiles(contact.getEmail(), "nguyenphu1147@gmail.com", 
					contact.getSubject(), content, multipartFiles);
			
			redirectAttributes.addFlashAttribute("msg", "Sent");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("msg", "Failed");

		}
		return "redirect:/contact/index3";
	}
}
