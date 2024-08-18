package com.products.category.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.category.service.CategoryService;

@RestController
public class CategoryController {

	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getAllCategories() {
		return "";
	}

	public String getProductsInCategory(@PathVariable("categoryId") Long categoryId) {
		return "";
	}

}
