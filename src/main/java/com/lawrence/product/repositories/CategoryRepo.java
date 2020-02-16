package com.lawrence.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lawrence.product.models.Category;

@Repository

public interface CategoryRepo extends CrudRepository<Category,Long>{
	List<Category> findAll();

} 