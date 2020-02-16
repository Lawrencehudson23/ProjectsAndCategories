package com.lawrence.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lawrence.product.models.CategoryProduct;

@Repository

public interface CategoryProductRepo extends CrudRepository<CategoryProduct,Long>{
	List<CategoryProduct> findAll();
}
