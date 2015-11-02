package com.test.questions.string;

/**
 * Created by dmitriy on 8/11/15.
 */
public class CompressString
{
	public static void main(String[] args)
	{
		String text = "abyzenmn";

		if (text == null || text.length() <= 1)
		{
			System.out.println(text);
		}
		else
		{
			String out = "";

			char[] array = text.toCharArray();

			int count = 1;

			char compareChar = array[0];

			for (int i = 1; i < array.length; i++)
			{
				char base = array[i];

				if (compareChar == base)
				{
					count++;
				}
				else
				{
					out += String.valueOf(compareChar) + count;

					compareChar = base;

					count = 1;
				}
			}

			out += String.valueOf(compareChar) + count;

			if (out.length() < text.length())
			{
				System.out.println(out);
			}
			else
			{
				System.out.println(text);
			}
		}

	}
}
