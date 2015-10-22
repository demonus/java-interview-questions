package com.test.questions.arrays;

/**
 * Created by dmitriy on 8/11/15.
 */
public class RotatedArray
{
	int[] array = {4, 5, 6, 7, 8, 2, 3};

	public static void main(String[] args) throws Exception
	{
		RotatedArray rotatedArray = new RotatedArray();

		rotatedArray.calculate();
	}

	public void calculate() throws Exception
	{
		System.out.println(get(0, array.length - 1));
	}

	public int get(int start, int stop) throws Exception
	{
		if (stop - start <= 1)
		{
			if (array[stop] < array[start])
			{
				return array[stop];
			}
			else
			{
				throw new Exception("Invalid array");
			}
		}
		else
		{
			int mid = start + (int) ((stop - start) / 2);

			if (array[mid] > array[stop])
			{
				return get(mid, stop);
			}
			else
			{
				return get(start, mid);
			}
		}
	}

}
