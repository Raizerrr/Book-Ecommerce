package fpoly.edu.assignment_java5.service.book;

import java.util.List;
import java.util.Optional;

import fpoly.edu.assignment_java5.identity.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
		
	public List<Book> getBookListByKeyword(String keyword);
	
	public void insertBook(Book paramBook);
	
	public void deleteBook(Book paramBook);
	
	public void updateBook(Book paramBook);
	
	public List<Book> priceDescPriceBookList();
	
	public List<Book> getBestSellerBooks();

	public Book getBookById(Long id);
	
	public List<Book> getTopTrendingList();

	List<Book> getBookListByCategory(String categoryName);

	List<Book> getAllBookToPage(int bookAmount, int pageOption);

	List<Book> getBooksByKeywordToPage(int bookAmount, int pageOption, String keyword);
	
	List<Book> getBooksByPriceRangeToPage(int bookAmount, int pageOption, Long min, Long max);
	
	List<Book> getBookListByCategoryString(int bookAmount, int pageOption, String catString);
}
