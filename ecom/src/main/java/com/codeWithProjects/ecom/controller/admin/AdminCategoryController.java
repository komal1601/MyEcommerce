package com.codeWithProjects.ecom.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codeWithProjects.ecom.services.admin.CategoryService;

@RestController
@RequestMappin("/api/admin")
@RequiredArgsConstructor

public class AdminCategoryController {

	
	private final CategoryService categoryService;
	
	@PostMapping("category")
	public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
		Category category = categoryService.createcategory(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(category);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Category>> getAllCategories(){
		return ResponseEntity.ok(categoryService.getAllCategories());
	}
}
