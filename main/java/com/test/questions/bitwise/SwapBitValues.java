package com.test.questions.bitwise;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by dmitriy on 9/2/15.
 */
public class SwapBitValues
{
	public static void main(String[] args)
	{
		int value = 97;

		System.out.println("value = " + Integer.toBinaryString(value));

		int out = 0;

		int count = 0;

		for (int i = value; i != 0; i = i >> 1)
		{
			int first = (value >> count) & 1;

			int second = 0;

			if (i > 1)
			{
				second = (value >> (count + 1)) & 1;
			}

			System.out.println("first = " + first + "; second = " + second);

			if (first != second)
			{
				int mask = (second << count) | (first << (count + 1));

				System.out.println("mask " + i + " = " + Integer.toBinaryString(mask));

				out = out | mask;

				System.out.println("out " + i + " = " + Integer.toBinaryString(out));
			}
			else
			{
				out = out | (first << count) | (second << (count + 1));
			}

			count += 2;

			i = i >> 1;
		}

		System.out.println("\n\n\nout = " + Integer.toBinaryString(out));
	}
}
