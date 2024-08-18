package com.products.category.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Override
	public String getAllCategories() {
		return "";
	}

	@Override
	public String getProductsInCategory(Long categoryId) {
		return "";
	}
}
