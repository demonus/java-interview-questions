package com.test.questions.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitriy on 9/16/15.
 */
public class Parentheses
{

	public List<String> generate(int count)
	{
		List<String> combinations = new ArrayList<String>();

		if (count <= 0)
		{
			return combinations;
		}

		if (count == 1)
		{
			combinations.add("()");

			return combinations;
		}

		if (count == 2)
		{
			combinations.add("()()");
			combinations.add("(())");

			return combinations;
		}

		List<String> results = generate(count - 1);

		for (String result : results)
		{
			String first = "()" + result;

			combinations.add(first);

			String second = result + "()";

			if (!second.equals(first))
			{
				combinations.add(second);
			}

			combinations.add("(" + result + ")");
		}

		return combinations;
	}

	public static void main(String[] args)
	{
		Parentheses parentheses = new Parentheses();

		List<String> results = parentheses.generate(5);

		for (String result : results)
		{
			System.out.println(result);
		}
	}
}
