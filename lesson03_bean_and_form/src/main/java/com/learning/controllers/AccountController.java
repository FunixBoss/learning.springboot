package com.learning.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.learning.models.Account;
import com.learning.models.Address;
import com.learning.services.CertService;
import com.learning.services.LanguageService;
import com.learning.services.RoleService;


@Controller
@RequestMapping({"", "account"})
public class AccountController implements ServletContextAware{

	@Autowired
	private LanguageService langService;
	
	@Autowired
	private CertService certService;
	
	@Autowired
	private RoleService roleService;
	
	private javax.servlet.ServletContext servletContext;
	
	@GetMapping({"/", "/register"})
	public String register(ModelMap modelMap) {
		modelMap.put("languages", langService.findAll());
		modelMap.put("certs", certService.findAll());
		modelMap.put("roles", roleService.findAll());
		
		Account account = new Account();
		account.setId(1);
		account.setUsername("acc1");
		account.setStatus(true);
		account.setLanguages(new String[] {"Japanese", "Vietnamese"});
		account.setGender("female");
		account.setCert("cert2"); // set id -> and jsp display name
		account.setRole("r2");
		account.setBirthday(new Date());
		account.setAddress(new Address("Lien Ap 123", "Binbh Chanh"));
		modelMap.put("account", account); 
		return "account/register";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute("account") Account account, 
							@RequestParam("photo") MultipartFile photo,
							@RequestParam("photos") MultipartFile[] photos) {
		System.out.println("Account info: ");
		System.out.println("id: " + account.getId());
		System.out.println("username: " + account.getUsername());
		System.out.println("password: " + account.getPassword());
		System.out.println("status: " + account.getStatus());
		System.out.println("description: " + account.getDescription());
		System.out.println("languages: " + account.getLanguages().length);
		if(account.getLanguages().length > 0) {
			System.out.println(
				Arrays.asList(account.getLanguages())
					.stream().collect(Collectors.joining(" ,")));
			
		}
		System.out.println("gender: " + account.getGender());
		System.out.println("cert: " + account.getCert());
		System.out.println("role: " + account.getRole());
//		submit l?? ng??y th??ng n??m nh??ng format l???i n??m th??ng ng??y
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("birthday: " + simpleDateFormat.format(account.getBirthday()));
		Address address = account.getAddress();
		System.out.println("address: " + address.getStreet() + " - " + address.getWard());
		
		
//		File 
		if(photo != null && photo.getSize() > 0) {
			System.out.println("======File Info=================================");
			System.out.println("file name: " + photo.getOriginalFilename());
			System.out.println("file size: " + photo.getSize());
			System.out.println("file type: " + photo.getContentType());
			String filename = upload(photo);
			System.out.println("new file name: " + filename);
		}
		
		if(photos != null && photos.length > 0) {
			System.out.println("numbet of files: " + photos.length);
			for(MultipartFile file : photos) {
				String filename = upload(file);
				System.out.println("new file name: " + filename);
			}
		}
		
		return "redirect:/account/register";
	}

	// 1 injection s??? ch??nh ?????i t?????ng n??y, ?????i t?????ng ch???a ???????ng d???n ?????n th?? m???c webapp
	// spring t??? ?????ng ch??ch th??nh ?????i t?????ng ho??n ch???nh, ko c???n @Autowired
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;  
	}
	
//	return t??n file upload
	private String upload(MultipartFile file) {
		try {
			String name = UUID.randomUUID().toString().replace("-", "");
			int lastIndex = file.getOriginalFilename().lastIndexOf(".");
			String fileName = name + file.getOriginalFilename().substring(lastIndex);

//			getRealPath() -> tr??? v??? ???????ng d???n webapp
			Path path = Paths.get(this.servletContext.getRealPath("/assets/upload/" + fileName));
			byte[] bytes = file.getBytes();
			Files.write(path, bytes);
			
			return fileName;
		} catch (Exception e) {
			return null;
		}
	}
}
