package com.test.questions.string;

/**
 * Created by dmitriy on 8/11/15.
 */
public class ReplaceSpaceHtml
{
	public static void main(String[] args)
	{
		String text = "Let me check this            ";

		System.out.println("[" + text + "]");

		System.out.println(text.length());

		int length = 17;

		char[] array = text.toCharArray();

		int i = 0;

		while (i < length)
		{
			if (array[i] == ' ')
			{
				array = shiftChars(array, i, 2);

				array[i] = '%';
				array[++i] = '2';
				array[++i] = '0';

				length += 2;
			}

			i++;
		}

		String res = new String(array);

		System.out.println(res.length());

		System.out.println("[" + res + "]");
	}

	public static char[] shiftChars(char[] array, int start, int positions)
	{
		int index = array.length - positions - 1;

		for (int i = index; i > start; i--)
		{
			array[i + positions] = array[i];
		}

		return array;
	}
}
