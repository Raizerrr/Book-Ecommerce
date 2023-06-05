package fpoly.edu.assignment_java5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.service.book.BookService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/index")
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
    
	@GetMapping("/home")
    public String goToHome(Model model){
		
		List<Book> bestSellerBooks = bookService.getBestSellerBooks();
		
		model.addAttribute("bestSellerBooks",bestSellerBooks);
		
        return "/user/index";  
    }
	
	@GetMapping("/book/{id}")
	public String goToBookDetail(@PathVariable Long id, Model model) {
		
		Book book = new Book();
		
		book = bookService.getBookById(id);
		
		request.setAttribute("BOOKITEM", book);
		
		
		return "/user/bookDetail";
		
	}
	

	
}
