package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/16/15.
 */
public class PartitionLinkedList
{
	public static void main(String[] args)
	{
		SingleLinkedList linkedList = new SingleLinkedList();

		linkedList.add("5");
		linkedList.add("9");
		linkedList.add("1");
		linkedList.add("7");
		linkedList.add("3");
		linkedList.add("2");
		linkedList.add("6");
		linkedList.add("4");
		linkedList.add("10");
		linkedList.add("8");

		int x = 5;

		Node node = linkedList.getFirst();

		do
		{
			int value = Integer.parseInt(node.getData());

			if (value < x)
			{
				linkedList.setFirst(new Node(node.getData()));

				if (node.getNext() != null)
				{
					node.setData(node.getNext().getData());

					node.setNext(node.getNext().getNext());
				}
			}
			else
			{
				node = node.getNext();
			}
		}
		while (node != null);

		System.out.println(linkedList.toString());
	}
}
