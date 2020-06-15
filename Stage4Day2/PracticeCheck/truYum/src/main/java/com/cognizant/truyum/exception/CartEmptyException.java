package com.cognizant.truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Cart is empty")
public class CartEmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
