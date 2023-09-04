package com.util;

import org.springframework.http.HttpStatus;

public class Response<T> {
	private String message;
	
	private T object;
	
	private HttpStatus httpStatus;

	public Response(String message, T object, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.object = object;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
