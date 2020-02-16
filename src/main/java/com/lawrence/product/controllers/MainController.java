package com.lawrence.product.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lawrence.product.models.Category;
import com.lawrence.product.models.CategoryProduct;
import com.lawrence.product.models.Product;
import com.lawrence.product.services.MainService;

@Controller
public class MainController {
	private final MainService mS;

	public MainController(MainService mS) {
		this.mS = mS;
	}

	@GetMapping("/api/products")
	public List<Product> getAllProducts() {
		return this.mS.allProducts();
	}

	@PostMapping("/api/products")
	public Product createProduct(@RequestParam("name") String name, 
			@RequestParam("description") String description,
			@RequestParam("price") double price
			) {
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		return this.mS.createProduct(product);
	}

	@PostMapping("/api/categories")
	public Category createCategory(@RequestParam("name") String name) {
		Category category = new Category();
		category.setName(name);
		return this.mS.createCategory(category);
	}

	@PostMapping("/api/someroute")
	public CategoryProduct createCategoryProduct(
			@RequestParam("productId") Long productId,
			@RequestParam("categoryId") Long categoryId
			) {
		Product product = this.mS.getProductById(productId);
		Category category = this.mS.getCategoryById(categoryId);
		CategoryProduct cp = new CategoryProduct();
		cp.setProduct(product);
		cp.setCategory(category);
		return this.mS.createCategoryProduct(cp);
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("newProduct") Product product) {
		return "/products/newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("newProduct") Product product,BindingResult result,RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			return "/products/newProduct.jsp";
		}
		this.mS.createProduct(product);
		redirectAttributes.addFlashAttribute("success", "you create a product!");
		return "redirect:/products/new";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("newCategory") Category category) {
	    return "/categories/newCategory.jsp";
	}

	@PostMapping("/categories/new")
	public String createProduct(@Valid @ModelAttribute("newCategory") Category category,BindingResult result,RedirectAttributes redirectAttributes) {
	    if(result.hasErrors()) {
	        return "/categories/newCategory.jsp";
	    }
	    this.mS.createCategory(category);
	    redirectAttributes.addFlashAttribute("success", "you create a category!");
	    return "redirect:/categories/new";
	}
	@GetMapping("/products/{id}")
	public String displayProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.mS.getProductById(id);
		model.addAttribute("product", product);
		List<Category> allCategories = this.mS.allCategories();
		model.addAttribute("allCategories", allCategories);
		List<Category> pc = product.getCategories();
		model.addAttribute("pc", pc);
		model.addAttribute("productId", id);
		
		return "/products/displayProduct.jsp";
	}
	@PostMapping("/products/{id}")
	public String createRelationship(
			@PathVariable("id") Long productId, @RequestParam("categoryId")Long categoryId,Model model){
		Product product = this.mS.getProductById(productId);
		Category category = this.mS.getCategoryById(categoryId);
		CategoryProduct cp = new CategoryProduct();
		cp.setProduct(product);
		cp.setCategory(category);
		this.mS.createCategoryProduct(cp);
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String displayCategory(@PathVariable("id") Long id, Model model) {
		Category category = this.mS.getCategoryById(id);
		model.addAttribute("category", category);
		List<Product> allProducts = this.mS.allProducts();
		model.addAttribute("allProducts", allProducts);
		List<Product> cp = category.getProducts();
		model.addAttribute("cp", cp);
		model.addAttribute("CategoryId", id);
		
		return "/categories/displayCategory.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String createRelationship2(
			@PathVariable("id") Long categoryId, @RequestParam("productId")Long productId,Model model){
		Category category = this.mS.getCategoryById(categoryId);
		Product product = this.mS.getProductById(productId);
		CategoryProduct cp = new CategoryProduct();
		cp.setCategory(category);
		cp.setProduct(product);
		this.mS.createCategoryProduct(cp);
		return "redirect:/categories/{id}";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
