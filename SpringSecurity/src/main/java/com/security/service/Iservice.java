package com.security.service;

import java.util.Optional;

import com.security.dto.DTO;
import com.security.model.User;
import com.security.util.Response;

public interface Iservice {

	
	Response registration(DTO dto);

	String login(String username, String password);
}
