package com.learning.models;

public class Product {

	public String id;
	public String name;
	public double price;
	public String photo;
	public String category;

	public Product() {
		super();
	}

	public Product(String id, String name, double price, String photo, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.photo = photo;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
