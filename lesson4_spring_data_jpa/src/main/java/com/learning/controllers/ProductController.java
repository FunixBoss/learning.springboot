package com.learning.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learning.models.Product;
import com.learning.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "product/index";
	}

	@GetMapping("add")
	public String add(ModelMap modelMap) {
		Product product = new Product();
		product.setCreated(new Date());

		modelMap.put("product", product);
		return "product/add";
	}
	
//	sau khi thành công thì sẽ redirect về index và hiển thị thông báo thành công
//	Session Flash => cx là Session nhưng thời gian sống chỉ trong 1 lần request 
//	                . vì khi xử lý xong trong method này thì cần 1 cái biến,
//	                  biến này sẽ tồn tại tới lần request tiếp theo (redirect)
//	                
//	Session
	@PostMapping("add")
	public String add(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
		productService.save(product);
		redirectAttributes.addFlashAttribute("msg", "Product Added Successfully"); // Session Flash
		return "redirect:/product/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("product", productService.findById(id));
		
		return "product/edit";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
		productService.save(product);
		redirectAttributes.addFlashAttribute("msg", "Product Edited Successfully"); // Session Flash
		return "redirect:/product/index";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
		if(productService.delete(id)) {
			redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!!");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Deleted Failed");
		}
		return "redirect:/product/index";
	}
	
	
}
