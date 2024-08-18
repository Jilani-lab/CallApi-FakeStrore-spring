package com.products.category.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseModel {
	private Long id;
	private Date createdAt;
	private Date lastUpdatedAt;
	private boolean isDeleted;
}
