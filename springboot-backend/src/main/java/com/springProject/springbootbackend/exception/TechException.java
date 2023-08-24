package com.springProject.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TechException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private String status;
	private HttpStatus status1;

	public TechException(String message) {
		super(message);

	}

	public TechException(String message, HttpStatus status1) {
		super();
		this.message = message;
		this.status1 = status1;
	}

}
