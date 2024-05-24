package com.realProject.salesManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//creating our view that represents or joins
@Entity
@Table(name = "transactions_details")

public class ClinetTransactionDetails {
	@Id
	@Column(name = "tansaction_id")
	private int tansaction_id;
	@Column(name = "amount")
	private float amount;
	@Column(name = "quantity")
	private float quantity;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "name")
	private String name;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	
	public ClinetTransactionDetails() {
	}
	public ClinetTransactionDetails(float amount, float quantity, String productName, String name, String lastName,
			String email) {
		this.amount = amount;
		this.quantity = quantity;
		this.productName = productName;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	public int getTansaction_id() {
		return tansaction_id;
	}
	public void setTansaction_id(int tansaction_id) {
		this.tansaction_id = tansaction_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
