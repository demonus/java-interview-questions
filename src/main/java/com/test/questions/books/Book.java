package com.test.questions.books;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dmitriy on 8/6/15.
 */
public class Book
{
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-M-D");

	private String author;

	private Date date;

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Book(String author, Date date)
	{
		this.author = author;
		this.date = date;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("Book{");
		sb.append("author='").append(author).append('\'');
		sb.append(", date=").append(simpleDateFormat.format(date));
		sb.append('}');
		return sb.toString();
	}
}
