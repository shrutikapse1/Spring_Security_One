package com.learn.security.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.security.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findByUserName(String username);

}
