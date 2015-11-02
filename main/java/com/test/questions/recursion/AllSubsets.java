package com.test.questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dmitriy on 8/11/15.
 */
public class AllSubsets
{

	public static void main(String[] args)
	{
		AllSubsets characterCombination = new AllSubsets();

		List<String> a = new ArrayList<String>(5);

		a.add("1");
		a.add("2");
		a.add("3");
		a.add("4");
		a.add("5");

		characterCombination.calculate(a);
	}

	public void calculate(List<String> list)
	{
		List<List<String>> res = new ArrayList<List<String>>();

		while (list.size() > 0)
		{
			res.addAll(generate(list, res));

			list.remove(list.size() - 1);
		}

		for (List<String> val : res)
		{
			for (String value : val)
			{
				System.out.print(value + " ");
			}

			System.out.println();
		}

		System.out.println("\n\n\n" + res.size());
	}

	public List<List<String>> generate(List<String> list, List<List<String>> res)
	{
		if (list.size() == 1)
		{
			res = new ArrayList<List<String>>();

			List<String> set = new ArrayList<String>(list);

			res.add(set);

			return res;
		}
		else
		{
			String firstLetter = list.get(0);

			List<String> restOfText = list.subList(1, list.size());

			List<List<String>> base = generate(restOfText, res);

			int size = base.size();

			for (int i = 0; i < size; i++)
			{
				List<String> element = base.get(i);

				List<String> newElement = new ArrayList<String>(element);

				newElement.add(firstLetter);

				base.add(newElement);
			}

			return base;
		}
	}
}
