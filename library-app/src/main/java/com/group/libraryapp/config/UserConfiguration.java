package com.group.libraryapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.service.user.UserServiceV1;

@Configuration
public class UserConfiguration {

	@Bean
	public UserRepository userRepository(JdbcTemplate jdbcTemplate) {
		return new UserRepository(jdbcTemplate);
	}

	@Bean
	public UserServiceV1 userService(UserRepository userRepository) {
		return new UserServiceV1(userRepository);
	}

}
