package com.test.questions.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by root on 11/11/15.
 */
public class NextRightBigger
{
	public static void main(String[] args)
	{
		int[] array = {7, 5, 6, 3, 4, 1, 2, 9, 11};

		Set<Integer> indexes = new LinkedHashSet<Integer>();

		Integer min = array[0];

		indexes.add(0);

		for (int i = 1; i < array.length; i++)
		{
			if (array[i] > min)
			{
				min = null;

				Iterator<Integer> it = indexes.iterator();

				while (it.hasNext())
				{
					Integer index = it.next();

					if (array[index] < array[i])
					{
						array[index] = array[i];

						it.remove();
					}
					else
					{
						if (min == null || min < array[index])
						{
							min = array[index];
						}
					}
				}

				if (min == null)
				{
					min = array[i];
				}
			}
			else if (array[i] < min)
			{
				min = array[i];
			}

			indexes.add(i);
		}

		for (int i : array)
		{
			System.out.println(i);
		}
	}
}
