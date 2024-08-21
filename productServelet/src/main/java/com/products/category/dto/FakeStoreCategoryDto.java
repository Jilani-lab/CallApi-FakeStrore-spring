package com.products.category.dto;

import jakarta.annotation.Nullable;

public class FakeStoreCategoryDto {
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
