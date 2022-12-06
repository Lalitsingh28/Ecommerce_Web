package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(LoginException.class)
		public ResponseEntity<MyErrorDetails> loginHandler(LoginException e, WebRequest wr) {
				
			MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));	
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
	
	
		@ExceptionHandler(AdminException.class)
		public ResponseEntity<MyErrorDetails> adminrHandler(AdminException e, WebRequest wr) {
			
			MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
		
	
		@ExceptionHandler(UserException.class)
		public ResponseEntity<MyErrorDetails> customerHandler(UserException e, WebRequest wr) {
			
            MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));
			return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		}
		
		 @ExceptionHandler(ProductException.class)
		 public ResponseEntity<MyErrorDetails> productHandler(ProductException e, WebRequest wr) {
		 			
		 	MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));
		 	return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		 }
		 		

		 @ExceptionHandler(AddressException.class)
		 public ResponseEntity<MyErrorDetails> productHandler(AddressException e, WebRequest wr) {
		 			
		     MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),wr.getDescription(false));		
		     return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
		 }
		 		
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> logicalHandler(Exception e, WebRequest wr){
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
    }

	
	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetails> methodHandler(MethodArgumentNotValidException ie,WebRequest req) {
			
			MyErrorDetails err=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
			
	    }
	   	
	
}
