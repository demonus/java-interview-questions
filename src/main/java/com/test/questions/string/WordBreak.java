package com.test.questions.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by root on 10/13/15.
 */
public class WordBreak
{

	public static void main(String[] args)
	{
		WordBreak wordBreak = new WordBreak();

		String text = "";

		Set<String> wordDict = new HashSet<String>();

		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dogs");
		wordDict.add("dog");

		List<String> phrases = wordBreak.wordBreak(text, wordDict);

		for (String s : phrases)
		{
			System.out.println(s);
		}
	}

	public List<String> wordBreak(String s, Set<String> wordDict)
	{
		List<String> results = new ArrayList<String>();

		if (s == null)
		{
			return results;
		}

		if (wordDict == null || wordDict.size() == 0)
		{
			return results;
		}

		List<String> dictionary = new ArrayList<String>(wordDict);

		Collections.sort(dictionary);

		Map<Character, Integer> index = new HashMap<Character, Integer>();

		Character firstLetter = null;

		for (int i = 0; i < dictionary.size(); i++)
		{
			char c = dictionary.get(i).charAt(0);

			if (firstLetter == null || firstLetter != c)
			{
				index.put(c, i);

				firstLetter = c;
			}
		}


		getPhrases(results, new StringBuilder(), s, dictionary, index);

		return results;
	}

	public void getPhrases(List<String> results, StringBuilder phrase, String text, List<String> dictionary,
						   Map<Character, Integer> index)
	{
		if (text != null && text.length() > 0)
		{
			char c = text.charAt(0);

			Integer idx = index.get(c);

			int dictLen = dictionary.size();

			if (idx != null)
			{
				int currentIdx = idx.intValue();

				char currChar = c;

				while (currentIdx < dictLen && currChar == c)
				{
					String word = dictionary.get(currentIdx);
					currChar = word.charAt(0);

					if (currChar == c)
					{
						int len = word.length();
						int textLen = text.length();

						if (textLen >= len && text.substring(0, len).equalsIgnoreCase(word))
						{
							StringBuilder nextPhrase = new StringBuilder(phrase);

							addWord(nextPhrase, word);

							if (textLen == len)
							{
								results.add(nextPhrase.toString());
							}
							else
							{
								String textCopy = text.substring(len, textLen);

								getPhrases(results, nextPhrase, textCopy, dictionary, index);
							}
						}
					}

					currentIdx++;
				}
			}
		}
	}

	public void addWord(StringBuilder text, String word)
	{
		if (text.length() > 0)
		{
			text.append(" ");
		}
		text.append(word);
	}

}

