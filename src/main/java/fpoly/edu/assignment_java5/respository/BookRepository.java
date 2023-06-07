package fpoly.edu.assignment_java5.respository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.identity.Category;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findAll();
	
	@Query("SELECT b FROM Book b WHERE b.name LIKE CONCAT('%', :keyword, '%')")
	List<Book> getBookListByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT b FROM Book b ORDER by b.price DESC")
	List<Book> priceDescPriceBookList();
	
	@Query("SELECT bk " +
            "FROM Book bk " +
            "JOIN OrderDetail od " +
            "GROUP BY bk.id " +
            "ORDER BY COUNT(bk.id) DESC " +
            "LIMIT 4")
	List<Book> getBestSellerBooks();

	@Query("SELECT bk "
			+ "FROM Book bk "
			+ "WHERE bk.id = :bkid")
	Book getBookById(@Param("bkid") Long bkid);
	
	@Query("SELECT bk from Book bk "
			+ "ORDER BY bk.price ASC "
			+ "LIMIT 12	")
	List<Book> getLowestPriceBook();
	
	
	List<Book> findByCategory(Category category);
	
	
	
	
}
