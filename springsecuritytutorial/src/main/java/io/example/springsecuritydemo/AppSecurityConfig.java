package io.example.springsecuritydemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authprovider() {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		provider.setUserDetailsService(userDetailsService);
		
		return provider;
		
	}
	
	/*@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		 
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("kindson").password("root").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("jadon").password("pass").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("solace").password("pass").roles("USER").build());
		
		return new InMemoryUserDetailsManager(users);
		
	}*/
	 /*@Override
	   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	    .passwordEncoder(passwordEncoder())
	    .withUser("abdul")
	    .password(passwordEncoder().encode("gem"))
	    .roles("USER");
	   }

	   @Bean
	   public PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	   } 
*/

}
