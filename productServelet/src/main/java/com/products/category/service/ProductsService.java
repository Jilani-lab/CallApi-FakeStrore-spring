package com.products.category.service;

import java.util.List;

import com.products.category.dto.ProductDto;
import com.products.category.model.Category;
import com.products.category.model.Product;

public interface ProductsService {

	List<Product> getAllProducts();

	Product getSingleProduct(Long productId);

	Product addNewProduct(ProductDto product1);

	String updateProduct(String productId, Product product);

	String deleteProduct(Long productId);

}