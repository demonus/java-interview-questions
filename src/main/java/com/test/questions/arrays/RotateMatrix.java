package com.test.questions.arrays;

/**
 * Created by dmitriy on 8/11/15.
 */
public class RotateMatrix
{
	public static void main(String[] args)
	{
		int[][] matrix =
				{{100, 101, 110, 111, 120, 121}, {200, 201, 210, 211, 220, 221}, {300, 301, 310, 311, 320, 321}};

		int countOfBytes = 2;

		int angle = 90;

		if (matrix.length > 0 && matrix[0].length > 0 && matrix.length * countOfBytes == matrix[0].length)
		{
			int len = matrix[0].length / countOfBytes;

			int[][] res = new int[matrix.length][matrix[0].length];

			for (int y = 0; y < len; y++)
			{
				for (int x = 0; x < matrix[0].length; x += countOfBytes)
				{
					if (angle == -90)
					{
						for (int count = 0; count < countOfBytes; count++)
						{
							int posX = y * countOfBytes + count;
							int posY = len - x - 1;

							res[posY][posX] = matrix[y][x * countOfBytes + count];
						}
					}
					else
					{
						for (int count = 0; count < countOfBytes; count++)
						{
							int posY = x / countOfBytes;

							int posX = (len - y - 1) * countOfBytes + count;

							int oldX = x + count;

							res[posY][posX] = matrix[y][oldX];

							System.out.println(y + ":" + oldX + " -> " + posY + ":" + posX);
							System.out.println("matrix[" + posY + ":" + posX + "] = " + matrix[y][oldX]);
						}
					}
				}
			}

			for (int i = 0; i < matrix.length; i++)
			{
				for (int j = 0; j < matrix[0].length; j++)
				{
					System.out.print(res[i][j] + " ");
				}

				System.out.println();
			}
		}
	}
}
