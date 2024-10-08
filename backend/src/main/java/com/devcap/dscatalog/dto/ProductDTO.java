package com.devcap.dscatalog.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devcap.dscatalog.entities.Category;
import com.devcap.dscatalog.entities.Product;

public class ProductDTO implements Serializable{
	private static final long serialVersionUID =1L;
	
	private Long id;
	private String name;
	private String description;
	private Double prince;
	private String imgUrl;
	private Instant date;
	
	private List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String name, String description, Double prince, String imgUrl, Instant date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.prince = prince;
		this.imgUrl = imgUrl;
		this.date = date;
	}
	
	public ProductDTO(Product entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.prince = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		this.date = entity.getDate();
	}
	
	public ProductDTO(Product entity, Set<Category> categories) {
		this(entity); //'chama' o construtor que recebe apenas a entidade do tipo product;
		categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrince() {
		return prince;
	}

	public void setPrince(Double prince) {
		this.prince = prince;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	
	
	
	
}
