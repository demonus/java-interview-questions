package com.test.questions.string;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * Created by root on 10/13/15.
 */
public class WordBreakTest
{
	WordBreak wordBreak;

	Set<String> dictionary;

	@Test
	public void testWordBreakNormal() throws Exception
	{
		List<String> res = wordBreak.wordBreak("catsanddog", dictionary);

		List<String> result = generateList("cat sand dog", "cats and dog");

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakEmpty() throws Exception
	{
		List<String> res = wordBreak.wordBreak("", dictionary);

		List<String> result = generateList();

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakSpaces() throws Exception
	{
		List<String> res = wordBreak.wordBreak(" cat ", dictionary);

		List<String> result = generateList();

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakEmptyDict() throws Exception
	{
		List<String> res = wordBreak.wordBreak("catsanddog", new HashSet<String>());

		List<String> result = generateList();

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakNullDict() throws Exception
	{
		List<String> res = wordBreak.wordBreak("catsanddog", null);

		List<String> result = generateList();

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakNullString() throws Exception
	{
		List<String> res = wordBreak.wordBreak(null, dictionary);

		List<String> result = generateList();

		assertEquals(res, result);
	}

	@Test
	public void testWordBreakDuplicates() throws Exception
	{
		Set<String> dict = new HashSet<String>();

		dict.add("cat");
		dict.add("cat");
		dict.add("cats");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("sand");
		dict.add("dog");
		dict.add("dog");

		List<String> res = wordBreak.wordBreak("catsanddog", dict);

		List<String> result = generateList("cats and dog", "cat sand dog");

		print(res);

		assertEquals(res, result);
	}

	@BeforeSuite
	public void init()
	{
		wordBreak = new WordBreak();

		dictionary = new HashSet<String>();

		dictionary.add("cat");
		dictionary.add("cats");
		dictionary.add("and");
		dictionary.add("sand");
		dictionary.add("dogs");
		dictionary.add("dog");
	}

	private void print(List<String> values)
	{
		for (String value : values)
		{
			System.out.println(value);
		}
	}

	private List<String> generateList(String... values)
	{
		List<String> list = new ArrayList<String>();

		for (String value : values)
		{
			list.add(value);
		}

		return list;
	}
}