package com.products.category.dto;


import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDto {

	@Nullable
	private Long id;
	private String title;
	private String description;
	private double price;
	private String image;
	private String category;
	@Nullable
    private RatingDto rating;
}
