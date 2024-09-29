package com.eventmanagementapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagementapi.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
