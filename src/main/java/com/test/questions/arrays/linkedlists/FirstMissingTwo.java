package com.test.questions.arrays.linkedlists;

import java.util.Stack;

/**
 * Created by root on 10/12/15.
 */
public class FirstMissingTwo
{
	public static void main(String[] args)
	{
		int[] A = {8, 30, -1, 1, 3, 2, 4, 6, 5, 7, 10, 0};

		int n = A.length;

		System.out.println(min(A, n));
	}

	public static int min(int[] A, int n) {
		for (int i = 0; i < n; ++i)
		{
			int num = A[i];
			while (num <= n && num > 0 && A[num - 1] != num)
			{
				int tmp = A[i];

				A[i] = A[num-1];

				A[num-1] = tmp;

				num = A[i];
			}
		}
		for (int i = 0; i < n; ++i)
		{
			if (A[i] != i + 1)
			{
				return i + 1;
			}
		}
		return n + 1;
	}
}
