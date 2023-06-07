package fpoly.edu.assignment_java5.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.respository.BookRepository;
import fpoly.edu.assignment_java5.service.book.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		
		List<Book> result = bookRepository.findAll();
		
		return result;
	}

	@Override
	public List<Book> getBookListByKeyword(String keyword) {
		
		List<Book> result = bookRepository.getBookListByKeyword(keyword);
		
		return result;
	}

	@Override
	public void insertBook(Book paramBook) {
		bookRepository.save(paramBook);
		
	}

	@Override
	public void deleteBook(Book paramBook) {
		bookRepository.delete(paramBook);
		
	}

	@Override
	public void updateBook(Book paramBook) {
		
		
	}

	@Override
	public List<Book> priceDescPriceBookList() {
		
		List<Book> result = bookRepository.priceDescPriceBookList();
		
		return result;
	}

	@Override
	public List<Book> getBestSellerBooks() {
		
		List<Book> result = bookRepository.getBestSellerBooks();
		
		return result;
	}
	
	@Override
	public Book getBookById(Long id) {
		
		Book result =  new Book();
		
		result = bookRepository.getBookById(id);
		
		
		return result;
	}

	@Override
	public List<Book> getTopTrendingList() {
		
		List<Book> result = bookRepository.getLowestPriceBook();
		
		return result;
	}

	@Override
	public List<Book> getBookListByCategory(String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBookToPage(int bookAmount, int pageOption) throws Exception{
		
		List<Book> bookList = bookRepository.findAll();
		
		List<Book> result = new ArrayList<>();
				
		int pageAmount = bookList.size() / bookAmount;
	
//		if (pageOption > (bookList.size()/pageAmount)+1 || pageOption <= 0) {
//			throw new Exception("Out Of Bound Option");
//		}
		
//		if (bookList.size() > (bookList.size()/bookAmount)*bookAmount && pageOption <= bookList.size()/bookAmount) {
//			for (int i = (pageOption * bookAmount); i < (pageOption+1)*bookAmount; i++) {
//				result.add(bookList.get(i));
//			}
		
		
//		}
		
		if (bookList.size() > (bookList.size()/bookAmount)*bookAmount && pageOption > bookList.size()/bookAmount) {
			for (int i = pageOption * bookAmount; i < bookList.size(); i++) {
				result.add(bookList.get(i));
			}
			
			System.out.println("system 2 is running");
		}
		
		if (bookList.size() == (bookList.size()/bookAmount)*bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption+1)*bookAmount; i++) {
				result.add(bookList.get(i));
			}
			
			System.out.println("system 3 is running");
		}
		
		if (bookList.size() < bookAmount ) {
			result = bookList;
			
			System.out.println("system 4 is running");
		}
		
		System.out.println(bookList.size());
		
		return result;
	}
	
//	public List<Book> getBooksByKeywordToPage(String keyword){
//		
//		Page<Book> page = bookRepository.f
//		
//	}

	
	
}
