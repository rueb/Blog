package com.api.blog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class RequestException extends RuntimeException{
	
	private String code;

    public RequestException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    

}
