package com.test.questions.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dmitriy on 8/6/15.
 */
public class FirstNonDuplicateChar
{

	public static void main(String[] args)
	{
		String text = "repeator";

		Map<Character, Integer> chars = new LinkedHashMap<Character, Integer>();

		for (char c: text.toCharArray()) {
			Integer count = chars.get(c);

			if (count == null) {
				chars.put(c, 0);
			}
			else {
				chars.put(c, ++count);
			}
		}

		for (Map.Entry<Character, Integer> entry: chars.entrySet()) {
			if (entry.getValue() == 0) {
				System.out.println(entry.getKey());

				break;
			}
		}
	}
}
