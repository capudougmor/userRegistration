package com.home.UserRegistration.resources.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.home.UserRegistration.services.exceptions.BadRequestExceptions;
import com.home.UserRegistration.services.exceptions.PropertyValueException;
import com.home.UserRegistration.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ErrorList> errors = getErrors(ex);
		String error = "Property value is null or empty";
		StandardError err = new StandardError(Instant.now(), status.value(), error, errors);
		return ResponseEntity.status(status).body(err);
	}
	
	private List<ErrorList> getErrors(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult().getFieldErrors().stream()
	            .map(error -> new ErrorList(error.getDefaultMessage(), error.getField()))
	            .collect(Collectors.toList());
	}

	@ExceptionHandler(PropertyValueException.class)
	public ResponseEntity<StandardError> propertyValueException(PropertyValueException e, HttpServletRequest request) {
		String error = "Registred user";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(BadRequestExceptions.class)
	public ResponseEntity<StandardError> badRequestExceptions(BadRequestExceptions e, HttpServletRequest request) {
		String error = "Bad request exception";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	public ResourceExceptionHandler() {
	}

}
