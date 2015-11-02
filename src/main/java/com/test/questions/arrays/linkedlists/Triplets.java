package com.test.questions.arrays.linkedlists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 10/12/15.
 */
public class Triplets
{
	public static void main(String[] args)
	{
		int[] arr =
				{-1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0,
						43,
						-43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0,
						43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43,
						-1, 2,
						0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43,
						-1,
						2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43,
						-1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3,
						43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3,
						43, 2,
						3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43, 2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3,
						43,
						2, 3, 43, -1, 2, 0, 43, -43, 32, 2, 21, 2, 3, 43};

		Triplets triplets = new Triplets();

		List<List<Integer>> res = triplets.getTriplets(arr);

		for (List<Integer> ls : res)
		{
			for (Integer i : ls)
			{
				System.out.print(i + " ");
			}

			System.out.println();
		}
	}

	public List<List<Integer>> getTriplets(int[] nums)
	{
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		int len = nums.length;

		for (int i = 0; i < len - 2; i++)
		{
			int num = nums[i];

			int idxF = i + 1;
			int idxL = len - 1;

			while (idxF < idxL)
			{
				int numF = nums[idxF];
				int numL = nums[idxL];

				int sum = num + numF + numL;

				if (sum == 0)
				{
					List<Integer> ls = new ArrayList<Integer>();

					ls.add(num);
					ls.add(numF);
					ls.add(numL);

					res.add(ls);

					while (idxF < (idxL - 1) && nums[idxF + 1] == nums[idxF])
					{
						idxF++;
					}
					while (idxF < (idxL - 1) && nums[idxL - 1] == nums[idxL])
					{
						idxL--;
					}

					idxF++;
				}
				else if (sum < 0)
				{
					idxF++;
				}
				else
				{
					idxL--;
				}
			}

			while (i < len - 2 && nums[i] == nums[i + 1])
			{
				i++;
			}
		}


		return res;
	}
}
