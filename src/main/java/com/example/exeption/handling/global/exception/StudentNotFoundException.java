package com.example.exeption.handling.global.exception;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(String message) {
		super(message);
	}

}
