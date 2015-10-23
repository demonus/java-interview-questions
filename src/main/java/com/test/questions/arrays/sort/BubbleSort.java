package com.test.questions.arrays.sort;

/**
 * Created by remote on 10/22/15.
 */
public class BubbleSort extends AbstractBaseSort
{
	@Override
	public void sort(int[] array, int len)
	{
		for (int i = len; i > 1; i--)
		{
			for (int j = 0; j < i - 1; j++)
			{
				if (array[j] > array[j + 1])
				{
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		BubbleSort bubbleSort = new BubbleSort();

		bubbleSort.sort();
	}
}
