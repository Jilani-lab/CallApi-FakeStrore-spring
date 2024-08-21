package com.products.category.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
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
