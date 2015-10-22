package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/17/15.
 */
public class CyclicRelation
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

		Node node = new Node("7");

		linkedList.add(node);

		linkedList.add("8");
		linkedList.add("9");
		linkedList.add("10");

		Node node2 = new Node("11");

		node2.setNext(node);

		linkedList.add(node2);

		Node first = linkedList.getFirst();

		Node second = linkedList.getFirst();

		int count = 0;

		boolean found = false;

		while (!found && first != null && second != null && count <30)
		{
			first = first.getNext();

			System.out.println("# " + first.getData());

			count++;

			if (count % 2 == 0)
			{
				second = second.getNext();

				System.out.println("## " + second.getData());

				if (second.equals(first))
				{
					//found = true;

					System.out.println(second.getData());
				}
			}
		}
	}
}
