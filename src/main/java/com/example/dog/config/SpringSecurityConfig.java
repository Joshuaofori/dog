package com.example.dog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  {
	    @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.withUsername("joshua")
	            .password(encoder().encode("anhydrous"))
	            .roles("USER")
	            .build();
	        return new InMemoryUserDetailsManager(user);
	    }
	    
	    @Bean
	    public PasswordEncoder encoder() {
	        return new BCryptPasswordEncoder();
	    }
}
