package com.app.spring.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionhandler {
	@ExceptionHandler(Resourcenotfound.class)
	public ResponseEntity<?> Resourcenotfound(Resourcenotfound ex, WebRequest web){
		Errordetails e = new Errordetails(new Date(),ex.getMessage(),web.getDescription(false));
				return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globelexceptionhandler(Exception ex, WebRequest web){
		Errordetails e = new Errordetails(new Date(), ex.getMessage(), web.getDescription(false));
		return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
