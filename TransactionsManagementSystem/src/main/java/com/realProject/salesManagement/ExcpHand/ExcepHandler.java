package com.realProject.salesManagement.ExcpHand;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepHandler {
//handling not found id
	@ExceptionHandler
	ResponseEntity<ResponseBody> IDnotfound(IdNotFoundException idex) {
		ResponseBody resb = new ResponseBody(idex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				System.currentTimeMillis());

		return new ResponseEntity<ResponseBody>(resb, HttpStatus.BAD_REQUEST);
	}

//handling if the entered value is not number
	@ExceptionHandler
	ResponseEntity<ResponseBody> NotAcceptedValue(NumberFormatException ex) {
		ResponseBody resb = new ResponseBody(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE.value(),
				System.currentTimeMillis());

		return new ResponseEntity<ResponseBody>(resb, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler
	ResponseEntity<ResponseBody> NotAcceptedValue(Exception ex) {
		ResponseBody resb = new ResponseBody(ex.getMessage(), HttpStatus.BAD_REQUEST.value(),
				System.currentTimeMillis());

		return new ResponseEntity<ResponseBody>(resb, HttpStatus.BAD_REQUEST);
	}
}
