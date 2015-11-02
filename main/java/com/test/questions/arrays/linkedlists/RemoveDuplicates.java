package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/13/15.
 */
public class RemoveDuplicates
{
	public static void main(String[] args)
	{
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();

		removeDuplicates.execute();
	}

	public void execute()
	{
		SingleLinkedList linkedList = new SingleLinkedList();

		linkedList.add("1");
		linkedList.add("4");
		linkedList.add("98");
		linkedList.add("4");
		linkedList.add("23");
		linkedList.add("4");
		linkedList.add("1");
		linkedList.add("7");
		linkedList.add("98");
		linkedList.add("0");

		System.out.println(linkedList.toString());

		Node original = linkedList.getFirst();

		while (original != null)
		{
			findDuplicates(original);

			original = original.getNext();
		}

		System.out.println(linkedList.toString());
	}

	public void findDuplicates(Node original)
	{
		Node next = original;

		while (next != null)
		{
			checkNextDuplicate(original, next);

			next = next.getNext();
		}
	}

	private void checkNextDuplicate(Node original, Node node)
	{
		if (original != null && node != null && node.getNext() != null && original.equals(node.getNext()))
		{
			if (node.getNext().getNext() != null)
			{
				node.setNext(node.getNext().getNext());
			}
		}
	}
}
