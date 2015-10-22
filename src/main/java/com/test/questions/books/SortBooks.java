package com.test.questions.books;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by dmitriy on 8/6/15.
 */
public class SortBooks
{
	public static void main(String[] args)
	{
		List<Book> books = new ArrayList<Book>();

		Calendar c = Calendar.getInstance();

		c.set(1936, 10, 19);
		books.add(new Book("Jack London", c.getTime()));

		c.set(1978, 01, 15);
		books.add(new Book("Somerset Moem", c.getTime()));

		c.set(1940, 4, 20);
		books.add(new Book("Jack London", c.getTime()));


		c.set(1980, 05, 30);
		books.add(new Book("Somerset Moem", c.getTime()));


		c.set(1936, 8, 2);
		books.add(new Book("Jack London", c.getTime()));


		books.sort(new BookComparator());

		for (Book book : books)
		{
			System.out.println(book.toString());
		}
	}
}

class BookComparator implements Comparator<Book>
{

	public int compare(Book o1, Book o2)
	{
		int compareAuthors = o1.getAuthor().compareTo(o2.getAuthor());

		if (compareAuthors == 0)
		{
			return o1.getDate().compareTo(o2.getDate());
		}
		else
		{
			return compareAuthors;
		}
	}
}
