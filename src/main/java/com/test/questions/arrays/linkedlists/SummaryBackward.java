package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/16/15.
 */
public class SummaryBackward
{
	public static void main(String[] args)
	{
		SingleLinkedList number1 = new SingleLinkedList();

		number1.add("7");
		number1.add("1");
		number1.add("6");


		SingleLinkedList number2 = new SingleLinkedList();

		number2.add("5");
		number2.add("9");
		number2.add("2");

		Node node1 = number1.getFirst();

		Node node2 = number2.getFirst();

		SingleLinkedList result = new SingleLinkedList();

		int nextGrade = 0;

		while (!(node1 == null && node2 == null))
		{
			if (node1 == null)
			{
				result.add(node2.getData());

				node2 = node2.getNext();
			}
			else if (node2 == null)
			{
				result.add(node1.getData());

				node1 = node1.getNext();
			}
			else
			{
				int sum = Integer.parseInt(node1.getData()) + Integer.parseInt(node2.getData()) + nextGrade;

				nextGrade = sum / 10;

				result.add(String.valueOf(sum % 10));

				node1 = node1.getNext();

				node2 = node2.getNext();
			}

		}

		if (nextGrade > 0)
		{
			result.add(String.valueOf(nextGrade));
		}

		System.out.println(result.toString());
	}
}
