package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/18/15.
 */
public class PalindromeList
{
	public static void main(String[] args)
	{
		SingleLinkedList linkedList = new SingleLinkedList();

		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add("4");
		linkedList.add("3");
		linkedList.add("2");
		linkedList.add("1");


		SingleLinkedList reverseList = new SingleLinkedList();

		Node node = linkedList.getFirst();

		if (node != null)
		{

			Node reverseNode = new Node(node.getData());

			reverseNode.setNext(null);

			reverseList.add(reverseNode);

			Node reversePrev = reverseNode;

			node = node.getNext();

			while (node != null)
			{
				reverseNode = new Node(node.getData());

				reverseNode.setNext(reversePrev);

				reverseList.addReverse(reverseNode);

				reversePrev = reverseNode;

				node = node.getNext();
			}
		}

		System.out.println(reverseList.toString());

		Node original = linkedList.getFirst();

		Node reverse = reverseList.getFirst();

		boolean notPalindrome = false;

		do
		{
			if (original.equals(reverse))
			{
				original = original.getNext();

				reverse = reverse.getNext();
			}
			else
			{
				System.out.println("Not palindrome!");

				notPalindrome = true;

				break;
			}
		}
		while (original != null);

		if (!notPalindrome) {
			System.out.println("Palidrome");
		}
	}
}
