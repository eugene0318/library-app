package com.group.libraryapp.repository.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository {

	// private final List<Book> books = new ArrayList<Book>();
	@Override
	public void saveBook() {
		System.out.println("BookMemoryRepository============");
	}
}
