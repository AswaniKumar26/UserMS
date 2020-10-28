package com.learning.microservice.users.data;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDataEntity, Long> {

}
