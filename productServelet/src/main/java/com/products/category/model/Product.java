package com.products.category.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product extends BaseModel {
	private String title;
	private double price;
	private String description;
	private Category category;
	private String imageUrl;
}
