package com.products.category.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {

	String getAllCategories();

	String getProductsInCategory(Long categoryId);

}