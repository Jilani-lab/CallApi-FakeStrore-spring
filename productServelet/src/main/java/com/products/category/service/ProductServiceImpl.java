package com.products.category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.products.category.dto.ProductDto;
import com.products.category.model.Category;
import com.products.category.model.Product;

@Service
public class ProductServiceImpl implements ProductsService {

	private RestTemplateBuilder restTemplateBuilder;

	public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}

	@Override
	public List<Product> getAllProducts() {
		RestTemplate restTemplate = restTemplateBuilder.build();
	 ResponseEntity<ProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class); //typeErarsor);
		ArrayList<Product> result = new ArrayList<>();
		for(ProductDto productDto:response.getBody()) {
			Product product = new Product();
			product.setDescription(productDto.getDescription());
			product.setImageUrl(productDto.getImage());
			product.setTitle(productDto.getTitle());
			product.setId(productDto.getId());

			Category category = new Category();
			category.setName(productDto.getCategory());
			product.setCategory(category);
			result.add(product);
			
		}
		return result;
	}

	/*
	 * Return a Product object with all the details of the fetched product. The ID
	 * of the category will be null but the name of the category shall be correct.
	 */
	@Override
	public Product getSingleProduct(Long productId) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<ProductDto> response = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
				ProductDto.class, productId);
		ProductDto productDto = response.getBody();
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImage());
		
		product.setTitle(productDto.getTitle());
		product.setId(productDto.getId());

		Category category = new Category();
		category.setName(productDto.getCategory());
		
		product.setCategory(category);

//		if(response.getStatusCode().is2xxSuccessful()) {
//			ProductDto productDto = response.getBody();
//		}else {
//			
//		}
		return product;
	}

	@Override
	public Product addNewProduct(ProductDto product1) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<ProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products", product1,
				ProductDto.class);
		ProductDto productDto = response.getBody();
		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setImageUrl(productDto.getImage());
		
		product.setTitle(productDto.getTitle());
		product.setId(productDto.getId());

		Category category = new Category();
		category.setName(productDto.getCategory());
		
		product.setCategory(category);
		
		return product;
	}

	@Override
	public String updateProduct(String productId, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
