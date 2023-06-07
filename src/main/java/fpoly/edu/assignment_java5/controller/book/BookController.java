package fpoly.edu.assignment_java5.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.service.book.BookService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/{id}")
	public String goToBookDetail(@PathVariable Long id, Model model) {
		
		Book book = new Book();
		
		book = bookService.getBookById(id);
		
		request.setAttribute("BOOKITEM", book);
		
		
		return "/user/bookDetail";
		
	}
	
	//@Param("keyword") String keyword
	
	
	
	@GetMapping("/querySearch/{po}")
	public String querySearchBook(@RequestParam("keyword") String keyword, @PathVariable int po, Model model) throws Exception {
		
		List<Book> result = null;
		
		
		
		if (keyword.equalsIgnoreCase("trending")) {
			result = bookService.getTopTrendingList();
		}else if(keyword.equalsIgnoreCase("All")) {
			result = bookService.getAllBooks();
		}else if (keyword.isEmpty()) {
			
			result = bookService.getAllBookToPage(12, po);
			
		}
		else{
			result = bookService.getBookListByKeyword(keyword);
		}
		
		
		
		model.addAttribute("bookCategoryList", result);
		
		
		return "/user/categoryPage"; 
	}
		
	@GetMapping("/shop")
	public String goToShop() {
		
		
		
		return "/user/categoryPage";
	}
	
	
	
	
}
