package com.group.libraryapp.controller.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.h2.expression.Rownum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import com.group.libraryapp.service.user.UserServiceV2;

@RestController
public class UserController {

	private final UserServiceV2 userService;

	// private final List<User> users = new ArrayList<>();
	// private final JdbcTemplate jdbcTemplate;

	public UserController(UserServiceV2 userService) {
		this.userService = userService;
	}

	@PostMapping("/user")
	public void saveUser(@RequestBody UserCreateRequest request) throws IllegalAccessException {
		userService.saveUser(request);
	}

	// UserController.java 안에 들어간다.
	@GetMapping("/user")
	public List<UserResponse> getUsers() {

//		List<UserResponse> responses = new ArrayList<>();
//		for (int i = 0; i < users.size(); i++) {
//			responses.add(new UserResponse(i + 1, users.get(i)));
//		}
//		return responses;
		return userService.getUsers();
	}

	@PutMapping("/user")
	public void updateUser(@RequestBody UserUpdateRequest request) {
		userService.updateUser(request);
	}

	@DeleteMapping("/user")
	public void deleteUser(@RequestParam String name) {
		userService.deleteUser(name);
	}

	@GetMapping("/user/error-test")
	public void errorTest() throws IllegalAccessException {
		throw new IllegalAccessException();
	}
}
