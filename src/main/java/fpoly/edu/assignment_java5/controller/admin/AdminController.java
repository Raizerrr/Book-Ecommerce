package fpoly.edu.assignment_java5.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.identity.User;
import fpoly.edu.assignment_java5.service.book.BookService;
import fpoly.edu.assignment_java5.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired 
	HttpServletResponse response;
	
	@GetMapping("/home")
	public String viewDashboard() {
		
		
		return "/admin/index";
	}
	
	@GetMapping("/booklist")
	public String viewBookList(Model model) {
		
		List<Book> result = bookService.getAllBooks();
		
		model.addAttribute("bookList", result);
		
		return "/admin/app/booklist";
	}
	
	@GetMapping("/useradd")
	public String viewUserAdd() {
		
		
		return "/admin/app/user-add";
	}
	
	@GetMapping("/accountsetting")
	public String viewUserAccountSetting() {
		
		
		return "/admin/app/booklist";
	}
	
	@GetMapping("/userlist")
	public String userList(Model model) {
		
		List<User> result = userService.getAllUsers();
		
		model.addAttribute("userList", result);
		
		
		return "/admin/app/user-list";
	}

	
}
