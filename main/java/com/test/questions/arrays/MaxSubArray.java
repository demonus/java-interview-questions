package com.test.questions.arrays;

/**
 * Created by root on 10/15/15.
 */
public class MaxSubArray
{
	public static void main(String[] args)
	{
		MaxSubArray maxSubArray = new MaxSubArray();

		int[] array = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(maxSubArray.maxSubArray(array));
	}

	public int maxSubArray(int[] A) {
		int dp[] = new int[A.length]; int max = A[0]; dp[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(dp[i-1] + A[i] ,A[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
