package com.products.category.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Category extends BaseModel {
	private String name;
	private String description;
	private List<Product> products;
}
