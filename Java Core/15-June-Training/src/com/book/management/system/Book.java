package com.book.management.system;

public class Book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookBaseClass fictionBook = new FictionBook();
		fictionBook.getDiscountedPrice("Money Heist", "Professor");
		
		System.out.println("------------------------");
		
		BookBaseClass nonFictionBook = new NonFictionBook();
		nonFictionBook.getDiscountedPrice("Family Man", "Tiwary");
		
		System.out.println("------------------------");
		
		BookBaseClass eBook = new EBook();
		eBook.getDiscountedPrice("The Walking Dead", "Daryll");
	}

}

class BookBaseClass {
	String title;
	String author;
	double price;
	
	public void getDiscountedPrice(String bookTitle, String authorName) {
		this.title = bookTitle;
		this.author = authorName;
	}
	
}

class FictionBook extends BookBaseClass {
	double price = 499;
	double amountDiscounted = 50;
	double finalPrice = price - amountDiscounted;
	public void getDiscountedPrice(String bookTitle, String authorName) {
		System.out.println("Book Title: " + bookTitle);
		System.out.println("Author Name: " + authorName);
		System.out.println("Original Price: " + this.price);
		System.out.println("Price After Discount: " + this.finalPrice);
	} 	
}

class NonFictionBook extends BookBaseClass {
	double price = 399;
	double amountDiscounted = 50;
	double finalPrice = price - amountDiscounted;
	public void getDiscountedPrice(String bookTitle, String authorName) {
		System.out.println("Book Title: " + bookTitle);
		System.out.println("Author Name: " + authorName);
		System.out.println("Original Price: " + this.price);
		System.out.println("Price After Discount: " + this.finalPrice);
	} 	
}

class EBook extends BookBaseClass {
	double price = 249;
	double amountDiscounted = 50;
	double finalPrice = price - amountDiscounted;
	public void getDiscountedPrice(String bookTitle, String authorName) {
		System.out.println("Book Title: " + bookTitle);
		System.out.println("Author Name: " + authorName);
		System.out.println("Original Price: " + this.price);
		System.out.println("Price After Discount: " + this.finalPrice);
	} 	
}
