package com.lawrence.product.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lawrence.product.models.Product;

@Repository

public interface ProductRepo extends CrudRepository<Product,Long>{
	List<Product> findAll();
}
