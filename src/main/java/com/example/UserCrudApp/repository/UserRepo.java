package com.example.UserCrudApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.UserCrudApp.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{

	User findById(int id);
}
