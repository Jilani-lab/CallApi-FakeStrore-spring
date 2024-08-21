package com.products.category.client;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.products.category.dto.FakeStoreListOfCategoryDto;
import com.products.category.dto.FakeStoreProductDto;
import com.products.category.dto.ProductDto;
import com.products.category.model.Product;

@Component
public class FakeStoreClient {
	private RestTemplateBuilder restTemplateBuilder;

	public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}

	private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
			Class<T> responseType, Object... uriVariables) throws RestClientException {
		RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class)
				.build();
		RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
		ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
		return restTemplate.execute(url, HttpMethod.POST, requestCallback, responseExtractor, uriVariables);
	}

	public FakeStoreProductDto[] getAllProducts() {
//		RestTemplate restTemplate = restTemplateBuilder.build();
//		ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity("https://fakestoreapi.com/products",
//				FakeStoreProductDto[].class); // typeErarsor);

		ResponseEntity<FakeStoreProductDto[]> response = requestForEntity(HttpMethod.GET,
				"https://fakestoreapi.com/products", null, FakeStoreProductDto[].class, null);
		return response.getBody();

	}

	public FakeStoreProductDto getSingleProduct(Long productId) {
//		RestTemplate restTemplate = restTemplateBuilder.build();
//		ResponseEntity<FakeStoreProductDto> response = restTemplate
//				.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId);
		ResponseEntity<FakeStoreProductDto> response = requestForEntity(HttpMethod.GET,
				"https://fakestoreapi.com/products/{id}", null, FakeStoreProductDto.class, productId);
		return response.getBody();
	}

	public FakeStoreProductDto addNewProduct(ProductDto product) {
//		RestTemplate restTemplate = restTemplateBuilder.build();
//		ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity("https://fakestoreapi.com/products",
//				product, FakeStoreProductDto.class);
		ResponseEntity<FakeStoreProductDto> response = requestForEntity(HttpMethod.POST,
				"https://fakestoreapi.com/products", product, FakeStoreProductDto.class, null);
		return response.getBody();
	}

	public FakeStoreProductDto updateProduct(String productId, FakeStoreProductDto fakeStoreProductDto) {
		ResponseEntity<FakeStoreProductDto> response = requestForEntity(HttpMethod.PATCH,
				"https://fakestoreapi.com/products/{id}", fakeStoreProductDto, FakeStoreProductDto.class, productId);
		return response.getBody();
	}

	public FakeStoreProductDto deleteProduct(Long productId) {
		ResponseEntity<FakeStoreProductDto> response = requestForEntity(HttpMethod.DELETE,
				"https://fakestoreapi.com/products/{id}", null, FakeStoreProductDto.class, productId);
		return response.getBody();
	}
	
	//Category
	
	public FakeStoreListOfCategoryDto getAllCategories() {
	 ResponseEntity<FakeStoreListOfCategoryDto> response = requestForEntity(HttpMethod.GET,
				"https://fakestoreapi.com/products/categories", null, FakeStoreListOfCategoryDto.class, null);
	 return response.getBody();
	}
	
//	public FakeStoreListOfCategoryDto getProductsInCategory(){
//		 ResponseEntity<FakeStoreListOfCategoryDto> response = requestForEntity(HttpMethod.GET,
//					"https://fakestoreapi.com/products/categories", null, FakeStoreListOfCategoryDto.class, null);
//		 return response.getBody();
//	}
}
