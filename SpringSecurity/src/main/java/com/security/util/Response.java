package com.security.util;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response {

	private int code;
	private String message;
	
	
}
