package com.example.codeengine.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	public CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/categories")
	Collection<Category>  categories(){
		
		
		System.out.println(" Find All ");
		
		return categoryRepository.findAll();
		
		// select * from category
		
	}
	
	
	@GetMapping("/categories/{id}")
	
	ResponseEntity<?> getCategory(@PathVariable Long id){
		
		Optional<Category> category = categoryRepository.findById(id);
		
		System.out.println(" Single ");
		
		return category.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus
				.NOT_FOUND));
		
	}
	
	@PostMapping("/categories")
	ResponseEntity<Category>  createCategory(@Valid @RequestBody Category category) throws URISyntaxException   {
		
		
		Category result = categoryRepository.save(category);
		
		System.out.println(result);
		
		return ResponseEntity.created(new URI("/api/categories"+result.getId())).body(result);
		
	}
	
	@PutMapping("/categories/{id}")
	
	ResponseEntity<Category>  updateCategory(@Valid @RequestBody Category category) {
		
		
		Category category2 = categoryRepository.save(category);
		
		return ResponseEntity.ok().body(category2);
		
	}
	
	
	
	@DeleteMapping("/categories/{id}") 
	ResponseEntity<?> deleteCategory(@PathVariable Long id){
		
		categoryRepository.deleteById(id);
		
		return 	ResponseEntity.ok().build();
	}
	
	
	
}
