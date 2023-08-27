package com.learn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.security.Repositories.UserRepository;
import com.learn.security.models.User;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user =new User();
		user.setUserName("shruti");
		user.setPassword(this.bCryptPasswordEncoder.encode("om"));
		user.setEmail("shruti@gmail.com");
		user.setRole("ROLE_NORMAL");
		
		this.userRepository.save(user);
		
		User user1 =new User();
		user1.setUserName("om");
		user1.setPassword(this.bCryptPasswordEncoder.encode("shruti"));
		user1.setEmail("om@gmail.com");
		user1.setRole("ROLE_ADMIN");
		
		this.userRepository.save(user1);
	}

}
