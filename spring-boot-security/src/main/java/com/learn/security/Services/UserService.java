package com.learn.security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.security.models.User;

@Service
public class UserService {
	List<User> list=new ArrayList<>();
	
	public UserService() {
		this.list.add(new User("Shruti", "shruti123", "shruti@gmail,com"));
		this.list.add(new User("Chir", "chir123", "chir@gmail,com"));
	}
	
	public List<User> getAllUsers(){
		return this.list;
	}
	
	public User getUser(String userName){
		return this.list.stream().filter((user) -> user.getUserName().equals(userName)).findAny().orElse(null);
	}
	
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
