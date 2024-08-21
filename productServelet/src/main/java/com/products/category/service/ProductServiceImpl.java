package com.products.category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.products.category.client.FakeStoreClient;
import com.products.category.dto.FakeStoreProductDto;
import com.products.category.dto.ProductDto;
import com.products.category.exception.NotFoundException;
import com.products.category.model.Category;
import com.products.category.model.Product;

@Service
public class ProductServiceImpl implements ProductsService {
	private FakeStoreClient fakeStoreClient;

	public ProductServiceImpl(FakeStoreClient fakeStoreClient) {
		this.fakeStoreClient = fakeStoreClient;
	}

	private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
		Product product = new Product();
		product.setDescription(fakeStoreProductDto.getDescription());
		product.setImageUrl(fakeStoreProductDto.getImage());
		product.setTitle(fakeStoreProductDto.getTitle());
		product.setId(fakeStoreProductDto.getId());

		Category category = new Category();
		category.setName(fakeStoreProductDto.getCategory());
		product.setCategory(category);
		return product;
	}

	private FakeStoreProductDto convertProductToFakeStoreDto(Product product) {
		FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
		fakeStoreProductDto.setCategory(product.getCategory().getName());
		fakeStoreProductDto.setDescription(product.getDescription());
		fakeStoreProductDto.setTitle(product.getTitle());
		fakeStoreProductDto.setImage(product.getImageUrl());
		fakeStoreProductDto.setPrice(product.getPrice());
		return fakeStoreProductDto;
	}

	@Override
	public List<Product> getAllProducts() {
		FakeStoreProductDto[] allProducts = fakeStoreClient.getAllProducts();
		ArrayList<Product> result = new ArrayList<>();
		for (FakeStoreProductDto productDto : allProducts) {
			Product product = convertFakeStoreProductDtoToProduct(productDto);
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
		FakeStoreProductDto productDto = fakeStoreClient.getSingleProduct(productId);
		Product product = convertFakeStoreProductDtoToProduct(productDto);
		return product;
	}

	@Override
	public Product addNewProduct(ProductDto product1) {
		FakeStoreProductDto productDto = fakeStoreClient.addNewProduct(product1);
		Product product = convertFakeStoreProductDtoToProduct(productDto);
		return product;
	}

	@Override
	public Product updateProduct(String productId, Product product) {
		// TODO Auto-generated method stub
		FakeStoreProductDto productDto = convertProductToFakeStoreDto(product);
		FakeStoreProductDto response = fakeStoreClient.updateProduct(productId, productDto);
		return convertFakeStoreProductDtoToProduct(response);
	}

	@Override
	public Product deleteProduct(Long productId) {
		FakeStoreProductDto deleteProduct = fakeStoreClient.deleteProduct(productId);
		return convertFakeStoreProductDtoToProduct(deleteProduct);
	}

}
