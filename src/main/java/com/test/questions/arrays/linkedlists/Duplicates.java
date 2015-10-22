package com.test.questions.arrays.linkedlists;

/**
 * Created by root on 10/13/15.
 */
public class Duplicates
{
	public static void main(String[] args)
	{
		Duplicates duplicates = new Duplicates();

		ListNode head = duplicates.new ListNode(1);

		ListNode next = duplicates.new ListNode(2);
		ListNode tmp = next;

		head.next = next;

		next = duplicates.new ListNode(2);
		tmp.next = next;
		tmp = next;

		next = duplicates.new ListNode(4);
		tmp.next = next;
		tmp = next;

		next = duplicates.new ListNode(5);
		tmp.next = next;
		tmp = next;

		ListNode node = duplicates.deleteDuplicates(head);

		do
		{
			System.out.println(node.val);

			node = node.next;
		}
		while (node != null);
	}

	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return head;
		}

		ListNode prevNode = null;
		ListNode node = head;

		int val = head.val;

		while (node.next != null)
		{
			if (val == node.next.val)
			{
				while (node.next != null && val == node.next.val)
				{
					node = node.next;
				}

				if (prevNode != null)
				{
					prevNode.next = node.next;
				}
				else
				{
					head = node.next;
				}

				node = node.next;

				if (node != null)
				{
					val = node.val;
				}
			}
			else
			{
				prevNode = node;

				node = node.next;

				val = node.val;
			}
		}

		return head;
	}

	final class ListNode
	{
		public int val;

		public ListNode next;

		public ListNode(int val)
		{
			this.val = val;
		}
	}
}
