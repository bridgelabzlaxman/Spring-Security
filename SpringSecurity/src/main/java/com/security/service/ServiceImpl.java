package com.security.service;

import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dto.DTO;
import com.security.model.User;
import com.security.repository.JPARepository;
import com.security.util.Response;
import com.security.util.StatusHelper;
@Service
public class ServiceImpl implements Iservice {

	@Autowired
	Iservice userService;

	@Autowired
	ModelMapper mapper;

	@Autowired
	JPARepository repository;

	@Override
	public Response registration(DTO dto) {

		User user = mapper.map(dto, User.class);
		repository.save(user);

		Response response = StatusHelper.statusResponse(200, "Registered Successfully");

		return response;
	}
	
	  @Override
	    public String login(String username, String password) {
	        Optional<User> customer = repository.login(username,password);
	        if(customer.isPresent()){
	            String token = UUID.randomUUID().toString();
	            User custom= customer.get();
	            custom.setToken(token);
	            repository.save(custom);
	            return token;
	        }

	        return StringUtils.EMPTY;
	    }
	

}
