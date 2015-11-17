package com.test.questions.arrays.sort;

/**
 * Created by remote on 10/22/15.
 */
public class QuickSort extends AbstractBaseSort
{
	@Override
	public void sort(int[] array, int len)
	{
		sort(array, 0, len - 1);
	}

	private void sort(int[] array, int start, int end)
	{
		int mid = partition(array, start, end);

		if (start < mid - 1)
		{
			sort(array, start, mid-1);
		}

		if (mid < end)
		{
			sort(array, mid, end);
		}
	}

	private int partition(int[] array, int start, int end)
	{
		int mid = array[(start + end) / 2];

		while (start <= end)
		{
			while (array[start] < mid)
			{
				start++;
			}

			while (array[end] > mid)
			{
				end--;
			}

			if (start <= end)
			{
				swap(array, start, end);

				start++;
				end--;
			}
		}

		return start;
	}

	public static void main(String[] args)
	{
		QuickSort quickSort = new QuickSort();

		quickSort.sort();
	}
}
