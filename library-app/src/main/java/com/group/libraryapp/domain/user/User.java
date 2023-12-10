package com.group.libraryapp.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;
	@Column(nullable = false, length = 20, name = "name")
	private String name;
	private Integer age;
	
	@OneToMany(mappedBy = "user")
	private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

	// JPA는 기본 생성자가 꼭 필요
	protected User() {

	}

	public User(String name, Integer age) throws IllegalAccessException {
		if (name == null || name.isBlank()) {
			throw new IllegalAccessException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
		}
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Long getId() {
		return id;
	}

	public void updateName(String name) {
		this.name = name;
	}

}
