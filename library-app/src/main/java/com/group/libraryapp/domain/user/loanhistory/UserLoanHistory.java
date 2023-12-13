package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLoanHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = null;

	@ManyToOne
	private User user;

	private String bookName;

	private boolean isReturn;

	protected UserLoanHistory() {

	}

	public UserLoanHistory(User user, String bookName) {
		super();
		this.user = user;
		this.bookName = bookName;
		this.isReturn = false;
	}

	public void doReturn() {
		this.isReturn = true;
	}

	public String getBookName() {
		return this.bookName;
	}
}
