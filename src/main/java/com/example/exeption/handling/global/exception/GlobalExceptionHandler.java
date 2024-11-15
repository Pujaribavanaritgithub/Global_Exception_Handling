package com.example.exeption.handling.global.exception;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class GlobalExceptionHandler  {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleException(StudentNotFoundException snfe){
		Map<String, Object> response = new HashMap<>();
		response.put("status", HttpStatus.NOT_FOUND.value() );
		response.put("code", "NOT_FOUND");
		response.put("error", snfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
