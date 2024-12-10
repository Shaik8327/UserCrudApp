package com.example.UserCrudApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserCrudApp.entity.User;
import com.example.UserCrudApp.service.UserService;

@RestController
//@RequestMapping("user")
public class UserController {

	@Autowired
	UserService us;
	
	@GetMapping("/getAllUsers")
	List<User> getAll(){
		return us.getAll();
	}
	
	//userid is known as path variable
	@GetMapping("/getOne/{userid}")
	User getOneUser(@PathVariable("userid")int id) {
		return us.getOnId(id);
	}
	
	@PostMapping("/insertUser")
	String insertUser(@RequestBody User u) {
		return us.addUser(u);
	}
	
	@PutMapping("/update/{userid}")
	String updateUser(@PathVariable("userid") int id,@RequestBody User u) {
		return us.update(id,u);
	}
	
	@DeleteMapping("/delete/{userid}")
	String deleteUser(@PathVariable("userid") int id) {
		return us.delete(id);
	}
}
