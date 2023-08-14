package fpoly.edu.assignment_java5.controller.PaymentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.identity.CartItem;
import fpoly.edu.assignment_java5.service.book.BookService;
import fpoly.edu.assignment_java5.service.order.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired 
	HttpServletResponse response;
			
	@GetMapping("/views")
	public String viewCart(Model model) {
		model.addAttribute("CART_ITEMS", orderService.getAllItems());
		model.addAttribute("TOTAL", orderService.getAmount());
		model.addAttribute("COUNTBOOK", orderService.getCount());
		return "/user/payment";
	}
	
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable("id") Long id) {
		
		Book book = bookService.getBookById(id);
		
		if(book != null) {
			CartItem item = new CartItem();
			item.setBookId(book.getId());
			item.setBookName(book.getName());
			item.setBookPrice(book.getPrice());
			item.setBookImage(book.getImage());
			item.setQty(1);
			orderService.add(item);
		}
		
		
		return "redirect:/payment/views";
	}
	
	@GetMapping("/clear")
	public String clearCart() {
		orderService.clear();
		return "redirect:/payment/views";		
	}
	
	@GetMapping("/del/{id}")
	public String removeCart(@PathVariable("id") Long id) {
		orderService.remove(id);
		
		return "redirect:/payment/views";
	}
	
	@PostMapping("/update")
	public String updateCart(@RequestParam("id") Long id, @RequestParam("qty") long qty) {
		orderService.update(id, qty);
		
		
		return "redirect:/shoppingcart/views";
	}
	
}
