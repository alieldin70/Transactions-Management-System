package com.realProject.salesManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "client_id")
	private int clientId;
	@Column(name = "amount")
	private float amount;
	@Column(name = "quantity")
	private int quantity;

// generating  constructors
	public Transactions() {
	}

	public Transactions(int productId, int clientId, float amount, int quantity) {
		super();
		this.productId = productId;
		this.clientId = clientId;
		this.amount = amount;
		this.quantity = quantity;
	}

// define setters and getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
