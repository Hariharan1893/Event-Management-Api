package com.eventmanagementapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	private String category_name;

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category_name=" + category_name + "]";
	}

	public Category(Long category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

	public Category() {
		
	}
	
	
}
