package com.bookapp.service;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;

public class BookImpl implements BookInter {

	List<Book> bookList = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookList.add(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		Collections.sort(bookList, (book1, book2) -> {
			return book1.getTitle().compareTo(book2.getTitle());
		});
		return bookList;
	}

	@Override
	public List<Book> getBookByAuthor(String author) throws AuthorNotFoundException {
		// TODO Auto-generated method stub
		List<Book> newList = new ArrayList<>();
		
			for (Book book : bookList) {
				if (book.getAuthor().equalsIgnoreCase(author)) {
					newList.add(book);
					Collections.sort(newList, (author1, author2) -> {
						return author1.getAuthor().compareTo(author2.getAuthor());
					});
				}
			}
			if(newList.isEmpty()) {
			
				throw new AuthorNotFoundException("Author NOT Found");
			}
			
			return newList;
		 
		

	}

	/*
	 * Optional<Book> filteredData =
	 * bookData.filter((x)->x.equals(author)).sorted().findAny();
	 * filteredData.ifPresent(System.out::println); newList.add(filteredData.get());
	 * return newList;
	 */

	@Override
	public List<Book> getBookByCategory(String category) throws CategoryNotFoundException {
		List<Book> secondNewList = new ArrayList<>();
		
			for (Book book : bookList) {
				if (book.getCategory().equalsIgnoreCase(category)) {
					secondNewList.add(book);
					Collections.sort(secondNewList, (category1, category2) -> {
						return category1.getCategory().compareTo(category2.getCategory());
					});
				}

			}
			if(secondNewList.isEmpty()) {
				throw new CategoryNotFoundException("Category NOT found");
			}

			return secondNewList;
		

		

	}

}
