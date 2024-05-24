package com.realProject.salesManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
//defining product  table atttributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "price")
	private float price;
	@Column(name = "available_quantity")
	private int available_quantity;
	@Column(name = "name")
	private String name;
	@Column(name = "descr")
	private String descr;
	@Column(name = "category")
	private String category;
	@Column(name = "creation_date")
	private String creation_date;

//genetrating constructors
	public Product() {

	}

	public Product(float price, int available_quantity, String name, String descr, String category,
			String creation_date) {
		super();
		this.price = price;
		this.available_quantity = available_quantity;
		this.name = name;
		this.descr = descr;
		this.category = category;
		this.creation_date = creation_date;
	}

//generating getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

}
