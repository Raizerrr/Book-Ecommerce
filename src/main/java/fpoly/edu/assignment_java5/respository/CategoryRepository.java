package fpoly.edu.assignment_java5.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpoly.edu.assignment_java5.identity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	 List<Category> findAll();
		
	
}
