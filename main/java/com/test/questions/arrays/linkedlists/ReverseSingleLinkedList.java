package com.test.questions.arrays.linkedlists;

/**
 * Created by root on 10/30/15.
 */
public class ReverseSingleLinkedList
{
	public static void main(String[] args)
	{
		SingleLinkedList list = new SingleLinkedList();

		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		Node first = list.getFirst();

		Node ndCurrent = first;

		Node node = first;

		while (first.getNext() != null)
		{
			Node nd = first.getNext().getNext();

			node = first.getNext();

			node.setNext(ndCurrent);

			ndCurrent = node;

			list.setFirst(ndCurrent);

			first.setNext(nd);
		}

		System.out.println(list);
	}
}

