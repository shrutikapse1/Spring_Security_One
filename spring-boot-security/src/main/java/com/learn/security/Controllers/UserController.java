package com.learn.security.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.security.Services.UserService;
import com.learn.security.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{UserId}")
	public User getAllUsers(@PathVariable("UserId") String userName){
		return service.getUser(userName);
	}
	
	@PostMapping("/")
	public User add(@RequestBody User user) {
		return service.addUser(user);
	}
}
