package com.user.service.exceptions;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ResourceNotFoundException extends RuntimeException {
	public  ResourceNotFoundException() {
		super("Resource Not Found on Server");
	}
	public  ResourceNotFoundException(String message) {
		super(message);
	}
}
