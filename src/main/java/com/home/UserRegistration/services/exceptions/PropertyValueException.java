package com.home.UserRegistration.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PropertyValueException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PropertyValueException() {
		super("User already exits,  please check the fields ");
	}
}
