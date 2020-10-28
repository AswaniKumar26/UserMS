package com.learning.microservice.users.ui.user.controller;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservice.users.service.UserService;
import com.learning.microservice.users.shared.UserDataTransferObject;
import com.learning.microservice.users.ui.model.UserObject;
import com.learning.microservice.users.ui.model.UserResponseObject;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private Environment env;
	
	@Autowired
    UserService us;
	@GetMapping("/status/check")
	public String getStatus( ) {
		return "User Micro Service is Up and Running on port:"+ env.getProperty("local.server.port"); 
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(consumes= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML},
	             produces= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ResponseEntity createUser(@Valid @RequestBody UserObject user) {
		System.out.println(user.getFirstName());
		ModelMapper modelmap = new ModelMapper();
		modelmap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDataTransferObject uto = modelmap.map(user,UserDataTransferObject.class);	
		UserDataTransferObject resp = us.createUser(uto);
		UserResponseObject obj = modelmap.map(resp,UserResponseObject.class);	
		return  ResponseEntity.status(HttpStatus.CREATED).body(obj);
	}
}