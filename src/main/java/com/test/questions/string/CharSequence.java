package com.test.questions.string;

/**
 * Created by dmitriy on 9/25/15.
 */
public class CharSequence
{
	public static void main(String[] args)
	{
		String text = "sabahaabaabab";

		char[] chars = text.toCharArray();

		int pos = 0;

		int leftCount = 0;

		int prevCount = 0;

		do
		{
			char c = chars[pos];

			if (c == 'a')
			{
				leftCount++;

				pos++;
			}
			else if (c == 'b')
			{
				int rightCount = 0;

				for (int i = 0; i < (leftCount + prevCount); i++)
				{
					if ((chars.length > (pos + i + 1)) && chars[pos + i + 1] == 'a')
					{
						rightCount++;
					}
					else
					{
						break;
					}

				}

				if (rightCount > 0)
				{
					prevCount = rightCount;

					leftCount = 0;

					pos = pos + rightCount + 1;

					String out = "b";

					for (int x = 0; x < rightCount; x++)
					{
						out = "a" + out + "a";
					}

					System.out.println(out);
				}
				else
				{
					leftCount = 0;
					prevCount = 0;
					pos++;
				}
			}
			else
			{
				leftCount = 0;

				prevCount = 0;

				pos++;
			}
		}
		while (pos < chars.length);
	}
}
