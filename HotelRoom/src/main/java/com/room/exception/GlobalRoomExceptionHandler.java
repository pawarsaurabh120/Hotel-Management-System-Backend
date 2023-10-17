package com.room.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalRoomExceptionHandler {
	
	@ExceptionHandler(value = RoomNotFoundException.class)
	public ResponseEntity<Object> handleRoomNotFoundException(RoomNotFoundException exception){
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
