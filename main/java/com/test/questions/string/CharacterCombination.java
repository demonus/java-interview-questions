package com.test.questions.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dmitriy on 8/11/15.
 */
public class CharacterCombination
{

	public static void main(String[] args)
	{
		CharacterCombination characterCombination = new CharacterCombination();

		characterCombination.calculate("abcd");
	}

	public void calculate(String text)
	{
		List<String> res = new ArrayList<String>();

		while (text.length() > 0)
		{
			res.addAll(generate(text));

			text = text.substring(0, text.length() - 1);
		}

		for (String val : res)
		{
			System.out.println(val);
		}

		System.out.println(res.size());

		Set<String> values = new HashSet<String>();

		values.addAll(res);

		System.out.println(values.size());
	}

	public List<String> generate(String text)
	{
		if (text.length() == 1)
		{
			List<String> res = new ArrayList<String>(1);

			res.add(text);

			return res;
		}
		else
		{
			String firstLetter = text.substring(0, 1);

			String restOfText = text.substring(1);

			List<String> base = generate(restOfText);

			int size = base.size();

			for (int i = 0; i < size; i++)
			{
				String value = base.get(i);

				for (int j = 0; j <= value.length(); j++)
				{
					String newValue = value.substring(0, j) + firstLetter + value.substring(j);

					base.add(newValue);
				}
			}

			return base;
		}
	}
}
