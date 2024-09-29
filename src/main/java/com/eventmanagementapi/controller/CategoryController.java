package com.eventmanagementapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagementapi.model.Category;
import com.eventmanagementapi.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService catservice;
	
	@GetMapping("/allcategory")
	public List<Category> getAllCategory(){
		return catservice.getAllCategory();
	}
	
	@GetMapping("/getcategory/{category_id}") 
	public Category getCategoryById(@PathVariable Long category_id) {
		return catservice.getCategoryById(category_id);
	}
	
	@PostMapping("/createcategory")
	@ResponseStatus(HttpStatus.CREATED)
	public Category createCategory(@RequestBody Category cat) {
		return catservice.createCategory(cat);
	}
	
	@DeleteMapping("/deletecategory/{category_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategory(@PathVariable Long category_id) {
		catservice.deleteCategory(category_id);
	}
}
