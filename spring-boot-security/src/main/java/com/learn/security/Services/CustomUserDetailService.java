package com.learn.security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.security.Repositories.UserRepository;
import com.learn.security.models.CustomUserDetail;
import com.learn.security.models.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepository.findByUserName(username);
		if(user==null) {
			throw new UsernameNotFoundException("No User");
		}
		return new CustomUserDetail(user);
	}

}
