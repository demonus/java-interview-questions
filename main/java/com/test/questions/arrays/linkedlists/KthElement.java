package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/14/15.
 */
public class KthElement
{
	public static void main(String[] args)
	{
		SingleLinkedList linkedList = new SingleLinkedList();

		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add("6");
		linkedList.add("7");
		linkedList.add("8");
		linkedList.add("9");
		linkedList.add("10");

		Node first = linkedList.getFirst();

		Node second = linkedList.getFirst();

		int count = 4;

		int index = 0;

		while (first.getNext() != null)
		{
			first = first.getNext();

			if (index == count - 1)
			{
				second = second.getNext();
			}
			else
			{
				index++;
			}
		}

		System.out.println(second.getData());
	}
}
