package com.test.questions.arrays.sort;

/**
 * Created by remote on 10/22/15.
 */
public class SelectionSort extends AbstractBaseSort
{
	@Override
	public void sort(int[] array, int len)
	{
		for (int i = len - 1; i > 1; i--)
		{
			int max = 0;

			for (int j = 1; j < i; j++)
			{
				if (array[j] > array[max])
				{
					max = j;
				}
			}

			swap(array, max, i);
		}
	}

	public static void main(String[] args)
	{
		SelectionSort selectionSort = new SelectionSort();

		selectionSort.sort();
	}
}
