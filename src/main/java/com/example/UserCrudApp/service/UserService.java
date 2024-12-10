package com.example.UserCrudApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.UserCrudApp.entity.User;
import com.example.UserCrudApp.repository.UserRepo;

@Component
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public List<User> getAll(){
		return (List<User>) userRepo.findAll();
	}

	public User getOnId(int id) {
		return  userRepo.findById(id);
	}
	
	public String addUser(User u) {
		userRepo.save(u);
		return "Success";
	}

	public String update(int id, User u) {
		User user = userRepo.findById(id);
		if(user!=null) {
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			userRepo.save(user);
			return "success";
		}
		return "failure";
	}

	public String delete(int id) {
		userRepo.delete(getOnId(id));
		return "Success";
	}
}
