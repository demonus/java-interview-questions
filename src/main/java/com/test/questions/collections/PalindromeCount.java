package com.test.questions.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by dmitriy on 9/30/15.
 */
public class PalindromeCount
{
	TreeSet<Palindrome> sortedPalindromesSet = new TreeSet<Palindrome>();

	Map<String, Integer> foundPalindromesMap = new HashMap<String, Integer>();

	public static void main(String[] args)
	{
		String[] words = {"tabat", "lobol", "tat", "tabat", "tat", "tat", "kora"};

		PalindromeCount palindromeCount = new PalindromeCount();

		palindromeCount.checkPalindromes(words);
	}

	public void checkPalindromes(String[] words)
	{
		for (String word : words)
		{
			if (isPalindrome(word))
			{
				if (!foundPalindromesMap.containsKey(word))
				{
					foundPalindromesMap.put(word, 1);
				}
				else
				{
					foundPalindromesMap.put(word, foundPalindromesMap.get(word) + 1);
				}
			}
		}

		for (Map.Entry<String, Integer> entry : foundPalindromesMap.entrySet())
		{
			sortedPalindromesSet.add(new Palindrome(entry.getKey(), entry.getValue()));
		}

		for (Palindrome palindrome : sortedPalindromesSet)
		{
			System.out.println(palindrome.getWord() + " : " + palindrome.getCount());
		}
	}

	public boolean isPalindrome(String text)
	{
		Stack<Character> stack = new Stack<Character>();

		char[] textChars = text.toCharArray();

		for (char c : textChars)
		{
			stack.push(c);
		}

		for (char c : textChars)
		{
			if (c != stack.pop())
			{
				return false;
			}
		}

		return true;
	}

	final class Palindrome implements Comparable
	{
		String word;

		int count;

		public Palindrome(String word, int count)
		{
			this.word = word;

			this.count = count;
		}

		public String getWord()
		{
			return word;
		}

		public int getCount()
		{
			return count;
		}


		public int compareTo(Object o)
		{
			if (o instanceof Palindrome)
			{
				Palindrome op = (Palindrome) o;

				if (op.getCount() > this.getCount())
				{
					return 1;
				}
				else if (op.getCount() < this.getCount())
				{
					return -1;
				}
				else
				{
					return this.getWord().compareToIgnoreCase(op.getWord());
				}
			}
			else
			{
				return -1;
			}
		}
	}
}
