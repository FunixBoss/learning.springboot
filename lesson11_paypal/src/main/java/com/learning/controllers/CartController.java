package com.learning.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.models.Account;
import com.learning.models.Invoice;
import com.learning.models.InvoiceDetail;
import com.learning.models.InvoiceDetailId;
import com.learning.models.Item;
import com.learning.models.Product;
import com.learning.paypal.PaypalConfig;
import com.learning.paypal.PaypalResult;
import com.learning.paypal.PaypalSuccess;
import com.learning.services.InvoiceDetailService;
import com.learning.services.InvoiceService;
import com.learning.services.ProductService;


@Controller
@RequestMapping({"cart"})
public class CartController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private InvoiceDetailService invoiceDetailService;
	
	@GetMapping({"", "index"})
	public String index(ModelMap modelMap) {
		modelMap.put("posturl", environment.getProperty("paypal.posturl"));
		modelMap.put("returnurl", environment.getProperty("paypal.returnurl"));
		modelMap.put("business", environment.getProperty("paypal.business"));
		return "cart/index";
	}
	
	@GetMapping("buy/{id}")
	public String buy(@PathVariable("id") int id, HttpSession session) {
		Product product = productService.findById(id);
		List<Item> cart;
		if(session.getAttribute("cart") == null) {
			cart = new ArrayList<>();
			cart.add(new Item(product, 1));
		} else {
			cart = (List<Item>) session.getAttribute("cart");
//			nếu mua nhiều sản phẩm giống nhau
			int index = exists(id, cart);
			if(index == -1) {
				cart.add(new Item(product, 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
		}
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
	private int exists(int id, List<Item> cart) {
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	@GetMapping("remove/{index}")
	public String remove(@PathVariable("index") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		
		return "redirect:/cart/index";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("quantities") int[] quantities, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(int i = 0; i < cart.size(); i++) {
			cart.get(i).setQuantity(quantities[i]);
		}
		session.setAttribute("cart", cart);
		
		return "redirect:/cart/index";
	}
	
//	http://localhost:9090/cart/success?amt=51.00&cc=USD&st=Completed&tx=8PC68363UE4757037
//	tx=8PC68363UE4757037 -> mã transaction + authtoken ==> thông tin thanh toán
	@GetMapping("success")
	public String success(HttpServletRequest request, HttpSession session) {
		PaypalConfig paypalConfig = new PaypalConfig();
		paypalConfig.setAuthToken(environment.getProperty("paypal.authtoken"));
		paypalConfig.setBusiness(environment.getProperty("paypal.business"));
		paypalConfig.setPostUrl(environment.getProperty("paypal.posturl"));
		paypalConfig.setReturnurl(environment.getProperty("paypal.returnurl"));
		PaypalResult result = PaypalSuccess.getPaypal(request, paypalConfig);
		System.out.println("first name: " + result.getFirst_name());
		System.out.println("last_name: " + result.getLast_name());
		
		// luu gio hang vua thanh toan vao 2 table: invoice va invoice details
		Invoice invoice = new Invoice();
		Account account = new Account();
		account.setId(1);
		invoice.setAccount(account);
		invoice.setCreated(new Date());
		invoice.setName("invoice 111");
		invoice.setPayment("paypal");
		invoice.setStatus("done");
		invoice = invoiceService.save(invoice);
		
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		for(Item item : cart) {
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			invoiceDetail.setId(new InvoiceDetailId(invoice.getId(), item.getProduct().getId()));
			invoiceDetail.setPrice(item.getProduct().getPrice());
			invoiceDetail.setQuantity(item.getQuantity());
			invoiceDetailService.save(invoiceDetail);
		}
		
		// huy session
		session.removeAttribute("cart");
		
		return "cart/success";
	}
	
	
}
