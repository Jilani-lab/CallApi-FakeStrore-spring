package com.products.category.dto;

import com.products.category.model.Product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetSingleProductResponseDto {
    private Product product;
}