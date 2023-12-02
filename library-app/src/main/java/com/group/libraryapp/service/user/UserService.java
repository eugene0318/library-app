package com.group.libraryapp.service.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;

public class UserService {

	private final UserRepository userRepository;

	public UserService(JdbcTemplate jdbcTemplate) {
		userRepository = new UserRepository(jdbcTemplate);
	}

	public void updateUser(UserUpdateRequest request) {
		boolean isUserNotExist = userRepository.isUserNotExist(request.getId());

		if (isUserNotExist) {
			throw new IllegalArgumentException();
		}
		userRepository.updateUserName(request.getName(), request.getId());
	}

	public void deleteUser(String name) {
		String sql = "DELETE FROM user WHERE name = ?";
		if (userRepository.isUserNotExist(name)) {
			throw new IllegalArgumentException();
		}

		userRepository.deleteUser(name);
	}

	public void saveUser(UserCreateRequest request) {
		userRepository.saveUser(request.getName(), request.getAge());
		;
	}

	public List<UserResponse> getUsers() {
		return userRepository.getUsers();
	}
}