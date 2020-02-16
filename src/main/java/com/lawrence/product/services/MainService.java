package com.lawrence.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawrence.product.models.Category;
import com.lawrence.product.models.CategoryProduct;
import com.lawrence.product.models.Product;
import com.lawrence.product.repositories.CategoryProductRepo;
import com.lawrence.product.repositories.CategoryRepo;
import com.lawrence.product.repositories.ProductRepo;

@Service
public class MainService {
	@Autowired
	private final ProductRepo pR;
	private final CategoryProductRepo cpR;
	private final CategoryRepo cR;
	
	public MainService(ProductRepo pR, CategoryProductRepo cpR, CategoryRepo cR) {
		this.pR = pR;
		this.cpR = cpR;
		this.cR = cR;
	}
	public List<Product> allProducts(){
		return pR.findAll();
	}
	
	public List<Category> allCategories() {
		
		return this.cR.findAll();
	}
	
	public Product createProduct(Product p) {
		return this.pR.save(p);
	}
	public Category createCategory(Category c) {
		return this.cR.save(c);
	}
	public CategoryProduct createCategoryProduct(CategoryProduct cp) {
		return this.cpR.save(cp);
	}
	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = this.pR.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	public Category getCategoryById(Long id) {
		Optional<Category> optionalCategory = this.cR.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}

	
	
}
