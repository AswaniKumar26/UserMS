package com.learning.microservice.users.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.microservice.users.data.UserDataEntity;
import com.learning.microservice.users.data.UserRepository;
import com.learning.microservice.users.service.UserService;
import com.learning.microservice.users.shared.UserDataTransferObject;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepo;
	BCryptPasswordEncoder bcEncode;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo,BCryptPasswordEncoder bcEncode) {
		this.userRepo = userRepo;
		this.bcEncode = bcEncode;
	}
	
	@Override
	public UserDataTransferObject createUser(UserDataTransferObject user) {
		ModelMapper modelmap = new ModelMapper();
		user.setEncryptedPassword(bcEncode.encode(user.getPassword()));
		modelmap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDataEntity usEnt = modelmap.map(user,UserDataEntity.class);
		userRepo.save(usEnt);
		UserDataTransferObject resp = modelmap.map(usEnt,UserDataTransferObject.class);
		return resp;
		
	}
	
}
