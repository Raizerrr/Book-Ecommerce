package fpoly.edu.assignment_java5.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.Category;
import fpoly.edu.assignment_java5.respository.CategoryRepository;
import fpoly.edu.assignment_java5.service.category.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		
		List<Category> result = categoryRepository.findAll();
		
		return result;
	}
	
	
	
}
