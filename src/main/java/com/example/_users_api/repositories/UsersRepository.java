package com.example._users_api.repositories;

import com.example._users_api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {

}
