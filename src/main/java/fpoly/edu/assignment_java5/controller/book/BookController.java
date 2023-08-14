package fpoly.edu.assignment_java5.controller.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.identity.Category;
import fpoly.edu.assignment_java5.service.book.BookService;
import fpoly.edu.assignment_java5.service.category.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	HttpServletResponse response;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	@GetMapping("/{id}")
	public String goToBookDetail(@PathVariable Long id, Model model) {

		Book book = new Book();

		book = bookService.getBookById(id);

		request.setAttribute("BOOKITEM", book);

		return "/user/bookDetail";

	}

	@GetMapping("/querySearch/{po}")
	public String querySearchBook(
			@RequestParam("keyword") Optional<String> keyword, 
			@PathVariable int po, 
			Model model,
			@RequestParam("priceOrder") Optional<String> priceOrder,
			@RequestParam("nameOrder") Optional<String> nameOrder, 
			@RequestParam("minPrice") Optional<Long> minPrice,
			@RequestParam("maxPrice") Optional<Long> maxPrice,
			@RequestParam("Category") Optional<String> categoryString
	) {

		String keywords = keyword.orElse("");

		List<Book> result = null;

		List<Book> pageList = null;
		
		List<Book> resultStorage = new ArrayList<>();
		
		LinkedHashSet<String> uniqueWords = null;
		
		String[] catItemNew;
		
		List<String> checkedValues = new ArrayList<>(); 

		List<Category> categoryList = categoryService.getAllCategories();

		String queryString = "?" + request.getQueryString();

		model.addAttribute("key", keyword);

		String queryString2 = request.getQueryString();

		model.addAttribute("queryString", queryString);

		model.addAttribute("queryString2", queryString2);

		if (keyword.toString().equalsIgnoreCase("trending")) {
			result = bookService.getTopTrendingList();
			pageList = bookService.getAllBooks();
		} else if (keywords.equalsIgnoreCase("All")) {
			result = bookService.getAllBookToPage(12, po);
			pageList = bookService.getAllBooks();
		} else if (keyword.isEmpty()) {
			result = bookService.getAllBookToPage(12, po);
			pageList = bookService.getAllBooks();
		} else {
			result = bookService.getBooksByKeywordToPage(12, po, keywords);
			pageList = bookService.getBookListByKeyword(keywords);
		}

		if (!priceOrder.isEmpty()) {
			String priceBy = priceOrder.get();

			if (priceBy.equals("pa")) {
				result.sort(Comparator.comparing(Book::getPrice));
			} else if (priceBy.equals("pd")) {

				Book[] arr = new Book[result.size()];

				result.toArray(arr);

				Arrays.sort(arr, Comparator.comparing(Book::getPrice).reversed());

				result = Arrays.asList(arr);

			}
			model.addAttribute("priceOrder", priceBy);
		}

		if (!nameOrder.isEmpty()) {
			String nameBy = nameOrder.get();

			if (nameBy.equals("na")) {
				result.sort(Comparator.comparing(Book::getName));
			} else if (nameBy.equals("nd")) {

				Book[] arr = new Book[result.size()];

				result.toArray(arr);

				Arrays.sort(arr, Comparator.comparing(Book::getName).reversed());

				result = Arrays.asList(arr);

			}
			model.addAttribute("nameOrder", nameBy);
		}
		
		if (!minPrice.isEmpty() && !maxPrice.isEmpty()) {
			Long minVaule = minPrice.orElse(Long.MIN_VALUE);
	        Long maxVaule = maxPrice.orElse(Long.MAX_VALUE);
	        result = bookService.getBooksByPriceRangeToPage(12, po, minVaule, maxVaule);
	        
		}
		
		
		
		if (!categoryString.isEmpty()) {
			String categoryBy = categoryString.get(); 
			
			String[] catItem = categoryBy.split(","); 
			
			uniqueWords = new LinkedHashSet<>(Arrays.asList(catItem));
			
	        catItemNew = uniqueWords.toArray(new String[uniqueWords.size()]);
	        
	        checkedValues = Arrays.asList(catItemNew);
			
			System.out.println(catItem.toString());
						
			for (Book book : result) {
				
				for (int i = 0; i < catItemNew.length; i++) {
					
					if (book.getCategory().getName().equalsIgnoreCase(catItemNew[i])) {
						resultStorage.add(book);
						
					}
					
				}
								
			}	
						
			result = resultStorage;
			
			pageList = resultStorage;
		}
		

		model.addAttribute("checkedValues", checkedValues);

		model.addAttribute("bookPages", pageList);

		model.addAttribute("bookList", result);

		model.addAttribute("categoryList", categoryList);

		model.addAttribute("keyword", keywords);

		return "/user/categoryPage";
	}

	
	
	
}
