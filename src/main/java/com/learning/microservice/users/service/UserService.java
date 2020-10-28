package com.learning.microservice.users.service;

import com.learning.microservice.users.shared.UserDataTransferObject;

public interface UserService {
   public UserDataTransferObject createUser(UserDataTransferObject user);
}
