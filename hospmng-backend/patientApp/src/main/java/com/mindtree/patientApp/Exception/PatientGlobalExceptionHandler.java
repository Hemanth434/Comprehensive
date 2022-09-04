package com.mindtree.patientApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseStatus
public class PatientGlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Error> patientNotFoundException(PatientNotFoundException ex,WebRequest req) {
		Error errmsg= new Error(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errmsg);
		
	}
}
