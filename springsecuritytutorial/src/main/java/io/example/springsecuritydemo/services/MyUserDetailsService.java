package io.example.springsecuritydemo.services;


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.example.springsecuritydemo.models.User;
import io.example.springsecuritydemo.models.UserPrincipal;
import io.example.springsecuritydemo.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRpository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRpository.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("user not exist");
		}
		
		return new UserPrincipal(user);
	}
}
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.example.springsecuritydemo.models.User;
import io.example.springsecuritydemo.models.UserMonitor;
import io.example.springsecuritydemo.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			User user = userRepository.findByUsername(username);
			
			if(user == null) {
				throw new UsernameNotFoundException("User not found!");
			}
			
			return new UserMonitor(user);

	}

}