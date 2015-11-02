package com.test.questions.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitriy on 9/14/15.
 */
public class StringPermutations
{
	public static void main(String[] args)
	{
		List<String> res = StringPermutations.getPerms("abcd");

		for (String s : res)
		{
			System.out.println(s);
		}
	}

	public static ArrayList<String> getPerms(String str)
	{
		if (str == null)
		{
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0)
		{ // base case
			permutations.add("");
			return permutations;
		}


		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the 1st character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words)
		{
			for (int j = 0; j <= word.length(); j++)
			{
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}


	public static String insertCharAt(String word, char c, int i)
	{
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
}
