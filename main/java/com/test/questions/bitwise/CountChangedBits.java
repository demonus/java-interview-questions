package com.test.questions.bitwise;

/**
 * Created by dmitriy on 9/2/15.
 */
public class CountChangedBits
{
	public static void main(String[] args)
	{
		int a = 31;

		System.out.println("a = " + Integer.toBinaryString(a));

		int b = 14;

		System.out.println("B = " + Integer.toBinaryString(b));

		int xor = a ^ b;

		System.out.println("xor = " + Integer.toBinaryString(xor));

		int count = 0;

		for (int i = xor; i > 0; i = i >> 1)
		{

			if ((i & 1) > 0)
			{
				count++;
			}
		}

		System.out.println(count);
	}

}
