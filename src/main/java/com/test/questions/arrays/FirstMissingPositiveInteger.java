package com.test.questions.arrays;

/**
 * Created by root on 10/12/15.
 */
public class FirstMissingPositiveInteger
{
	public static void main(String[] args)
	{
		FirstMissingPositiveInteger first = new FirstMissingPositiveInteger();

		int[] x = {3, 4, -1, 1};

		System.out.println(first.firstMissingPositive(x));
	}

	public int firstMissingPositive(int[] nums) {

		if (nums != null)
		{
			int len = nums.length;

			if (len == 0)
			{
				return 1;
			}

			if (len == 1)
			{
				if ((nums[0] <= 0) || nums[0] > 1)
				{
					return 1;
				}
				return 2;
			}

			boolean[] allInts = new boolean[Integer.MAX_VALUE];

			int num = nums[0];

			if (num < 0)
			{
				num = 0;
			}

			allInts[num] = true;

			java.util.List<Integer> mins = new java.util.ArrayList<Integer>();

			if (num == 1) {
				mins.add(2);
			}
			else {
				mins.add(1);
			}

			for (int i = 1; i < len; i++) {
				num = nums[i];

				if (num < 0) {
					num = 0;
				}

			}
		}

		return 0;
	}
}