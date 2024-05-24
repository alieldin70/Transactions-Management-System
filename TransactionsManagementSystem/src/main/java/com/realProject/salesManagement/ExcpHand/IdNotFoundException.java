package com.realProject.salesManagement.ExcpHand;
//custom type of exception 
public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(String message) {
		super(message);
	}

}
