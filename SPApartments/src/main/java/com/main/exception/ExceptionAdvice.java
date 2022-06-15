package com.main.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> emptyinput(EmptyInputException emptyInputException) {

	
		return new ResponseEntity<>("Input field is Empty", HttpStatus.FORBIDDEN);

	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> nosuchelement(NoSuchElementException noSuchElementException) {
   
    return new ResponseEntity<>("No such element is found in the database", HttpStatus.BAD_REQUEST);

	}
	
	

//	@ExceptionHandler(Exception.class)
//
//	public ResponseEntity<String> gernal(Exception emptyI) {
//
//		System.out.println("inside the exption general advice ");
//		return new ResponseEntity<String>("Input field is Empty", HttpStatus.BAD_REQUEST);
//
//	}
}
