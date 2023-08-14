package fpoly.edu.assignment_java5.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.respository.BookRepository;
import fpoly.edu.assignment_java5.service.book.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {

		List<Book> result = bookRepository.findAll();

		return result;
	}

	@Override
	public List<Book> getBookListByKeyword(String keyword) {

		List<Book> result = bookRepository.getBookListByKeyword(keyword.toString());

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

		Book result = new Book();

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

		List<Book> result = bookRepository.getBookListByCategoryName(categoryName);
		
		return result;
	}

	@Override
	public List<Book> getAllBookToPage(int bookAmount, int pageOption) {

		List<Book> bookList = bookRepository.findAll();

		List<Book> result = new ArrayList<>();

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption < bookList.size() / bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption == bookList.size() / bookAmount) {
			for (int i = pageOption * bookAmount; i < bookList.size(); i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() == (bookList.size() / bookAmount) * bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() < bookAmount) {
			result = bookList;

		}

		return result;
	}

	@Override
	public List<Book> getBooksByKeywordToPage(int bookAmount, int pageOption, String keyword) {

		List<Book> bookList = bookRepository.getBookListByKeyword(keyword);

		List<Book> result = new ArrayList<>();

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption < bookList.size() / bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption == bookList.size() / bookAmount) {
			for (int i = pageOption * bookAmount; i < bookList.size(); i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() == (bookList.size() / bookAmount) * bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() < bookAmount) {
			result = bookList;

		}

		return result;

	}

	@Override
	public List<Book> getBooksByPriceRangeToPage(int bookAmount, int pageOption, Long min, Long max) {

		List<Book> bookList = bookRepository.getBookListByPriceRange(min, max);

		List<Book> result = new ArrayList<>();

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption < bookList.size() / bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption == bookList.size() / bookAmount) {
			for (int i = pageOption * bookAmount; i < bookList.size(); i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() == (bookList.size() / bookAmount) * bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() < bookAmount) {
			result = bookList;

		}

		return result;
	}

	@Override
	public List<Book> getBookListByCategoryString(int bookAmount, int pageOption, String catString) {

		List<Book> bookList = bookRepository.getBookListByCategoryString(catString);

		List<Book> result = new ArrayList<>();

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption < bookList.size() / bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() > (bookList.size() / bookAmount) * bookAmount
				&& pageOption == bookList.size() / bookAmount) {
			for (int i = pageOption * bookAmount; i < bookList.size(); i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() == (bookList.size() / bookAmount) * bookAmount) {
			for (int i = (pageOption * bookAmount); i < (pageOption + 1) * bookAmount; i++) {
				result.add(bookList.get(i));
			}
		}

		if (bookList.size() < bookAmount) {
			result = bookList;

		}

		return result;
		
		
	}
	
	
	

}
