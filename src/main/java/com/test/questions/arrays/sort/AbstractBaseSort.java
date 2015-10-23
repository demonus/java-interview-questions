package com.test.questions.arrays.sort;

/**
 * Created by remote on 10/22/15.
 */
public abstract class AbstractBaseSort
{
	int[] array = {27, 3, 12, 67, 5, 90, 0, 3, 22, 6};

	int len = array.length;

	public abstract void sort(int[] array, int len);

	private void print()
	{
		for (int i : array)
		{
			System.out.println(i);
		}
	}

	public void sort()
	{
		sort(array, len);

		print();
	}

	protected void swap(int[] array, int from, int to)
	{
		int tmp = array[from];

		array[from] = array[to];

		array[to] = tmp;
	}
}
