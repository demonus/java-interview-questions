package com.test.questions.arrays;

/**
 * Created by dmitriy on 8/11/15.
 */
public class SortNumericArray
{
	public static void main(String[] args)
	{
		int count = 1000;

		int[] array = new int[count];

		for (int i = 0; i < count; i++)
		{
			array[i] = (int) Math.round(Math.random() * 130);
		}

		int[] ages = new int[131];

		for (int value : array)
		{
			if (value >= 0 && value <= 130)
			{
				ages[value] = ++ages[value];
			}
		}

		for (int i = 0; i <= 130; i++)
		{
			for (int j = 0; j < ages[i]; j++)
			{
				System.out.println(i);
			}
		}
	}
}
