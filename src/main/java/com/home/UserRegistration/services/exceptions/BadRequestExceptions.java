package com.home.UserRegistration.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestExceptions() {
		super("User dont registred");
	}
}
