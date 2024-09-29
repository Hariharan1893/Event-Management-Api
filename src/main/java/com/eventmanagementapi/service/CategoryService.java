package com.eventmanagementapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagementapi.model.Category;
import com.eventmanagementapi.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo catrepo;
	
	public List<Category> getAllCategory(){
		return catrepo.findAll();
	}
	
	public Category getCategoryById(Long category_id) {
		return catrepo.findById(category_id)
				.orElseThrow(() -> new RuntimeException("No category found"));
	}
	
	public Category createCategory(Category cat) {
		return catrepo.save(cat);
	}
	
	public void deleteCategory(Long category_id) {
		
		Optional<Category> exist = catrepo.findById(category_id);

		if (exist != null) {
			catrepo.deleteById(category_id);
		} else {
			throw new RuntimeException("No category to delete");
		}
		
		
	}
}
