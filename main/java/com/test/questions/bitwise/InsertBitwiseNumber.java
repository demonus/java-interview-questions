package com.test.questions.bitwise;

/**
 * Created by dmitriy on 8/31/15.
 */
public class InsertBitwiseNumber
{
	public static void main(String[] args)
	{
		String target = "1000011001000100";

		String source = "11010";

		int startPos = 2;

		int endPos = 6;


		int targetDec = Integer.parseInt(target, 2);

		int sourceDec = Integer.parseInt(source, 2);

		int length = (endPos - startPos + 1);

		int resetMask = ~(((1 << length) - 1) << startPos);

		System.out.println("Reset mask: " + Integer.toBinaryString(resetMask));

		targetDec = targetDec & resetMask;

		System.out.println("After reset: " + Integer.toBinaryString(targetDec));

		sourceDec = (sourceDec << startPos);

		System.out.println("shift source: " + Integer.toBinaryString(sourceDec));

		targetDec = targetDec | sourceDec;

		System.out.println("After insert: " + Integer.toBinaryString(targetDec));
	}
}
