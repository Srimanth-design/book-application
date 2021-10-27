package com.bookapp.main;

import java.util.Scanner;

import com.bookapp.bean.Book;
import com.bookapp.exception.AuthorNotFoundException;
import com.bookapp.exception.CategoryNotFoundException;
import com.bookapp.service.BookImpl;
import com.bookapp.service.BookInter;

public class Client {

	public static void main(String[] args) throws AuthorNotFoundException, CategoryNotFoundException {
		// TODO Auto-generated method stub

		BookInter bookInter = new BookImpl();

		Scanner input = new Scanner(System.in);

		// Books I already have in my DB

		Book book1 = new Book("Angel in Shine", "Rutherford", "Suspense", 22, 230);
		Book book2 = new Book("Angel in Rain", "Rutherford Jr", "Thriller", 23, 250);
		Book book3 = new Book("Death in vain", "Kingson", "Drama", 22, 260);

		bookInter.addBook(book3);
		bookInter.addBook(book2);
		bookInter.addBook(book1);

		System.out.print("Add book count to insert : ");
		try {
			int noOfBooks = input.nextInt();

			for (int i = 0; i < noOfBooks; i++) {
				input.nextLine();
				System.out.print("Enter title: ");
				String title = input.nextLine();
				System.out.print("Enter category: ");
				String category = input.nextLine();
				System.out.print("Enter price: ");
				int price = input.nextInt();
				System.out.print("Enter book Id: ");
				int bookId = input.nextInt();
				input.nextLine();
				System.out.print("Enter author: ");
				String author = input.nextLine();
				Book book = new Book(title, author, category, bookId, price);

				bookInter.addBook(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Input--error");
			System.exit(0);
		}

		System.out.println();
		System.out.println("The Book list: ");
		System.out.println();

		for (Book string : bookInter.getAllBooks()) {
			System.out.println(string);
		}
		System.out.println();
		System.out.print("Enter author you want to search: ");

		String findAuthor = input.next();
		try {

			for (Book string : bookInter.getBookByAuthor(findAuthor)) {
				System.out.println();
				System.out.println(string);
			}
		} catch (AuthorNotFoundException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.print("Enter category you want to search: ");
		input.nextLine();
		String findCategory = input.nextLine();
		try {
			for (Book string : bookInter.getBookByCategory(findCategory)) {
				System.out.println();
				System.out.println(string);
			}
		} catch (CategoryNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		input.close();
	}

}
