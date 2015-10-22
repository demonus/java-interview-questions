package com.test.questions.bitwise;

/**
 * Created by dmitriy on 8/31/15.
 */
public class DecimalPart
{
	public static void main(String[] args)
	{
		double num = 0.72;

		StringBuilder binary = new StringBuilder();

		boolean error = false;

		while (!error && num > 0)
		{
			double r = num * 2;

			if (r >= 1)
			{
				binary.append("1");

				num = r-1;
			}
			else
			{
				binary.append("0");

				num = r;
			}

			if (binary.length() >= 32)
			{
				error = true;
			}
		}

		if (error)
		{
			System.out.println("ERROR");
		}
		else
		{
			System.out.println(binary.toString());
		}
	}
}
