package com.products.category.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.category.dto.GetSingleProductResponseDto;
import com.products.category.dto.ProductDto;
import com.products.category.model.Category;
import com.products.category.model.Product;
import com.products.category.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductsService productsService;

	public ProductController(ProductsService productsService) {
		this.productsService = productsService;
	}

	@GetMapping()
	public ResponseEntity<List<Product>> getAllProducts() {

		ResponseEntity<List<Product>> response = new ResponseEntity<>(productsService.getAllProducts(), HttpStatus.OK);
		return response;
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
//		GetSingleProductResponseDto responseDto = new GetSingleProductResponseDto();
//		responseDto.setProduct(productsService.getSingleProduct(productId));
//		return responseDto;
		MultiValueMap<String, String> headders = new LinkedMultiValueMap<>();
		headders.add("Auth-token", "sdfghj");
		ResponseEntity<Product> response = new ResponseEntity<>(productsService.getSingleProduct(productId), headders,
				HttpStatus.OK);
		return response;
	}

	@PostMapping()
	public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {

		ResponseEntity<Product> respone = new ResponseEntity<>(productsService.addNewProduct(productDto),
				HttpStatus.CREATED);
		return respone;
	}

	@PutMapping("/{productId}")
	public String updateProduct(@RequestBody ProductDto productDto
			,@PathVariable("productId") Long productId) {
		return "";
	}

	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable("productId") Long productId) {
		return "";
	}
}
