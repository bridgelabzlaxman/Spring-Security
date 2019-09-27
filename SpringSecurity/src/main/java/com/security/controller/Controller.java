package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.DTO;
import com.security.service.Iservice;
import com.security.util.Response;

@RequestMapping("/user")
@RestController
@PropertySource("classpath:message.properties")
public class Controller {

	@Autowired
	Iservice service;

	@PostMapping("/register")
	public ResponseEntity<Response> register(DTO dto) {

		Response response = service.registration(dto);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
