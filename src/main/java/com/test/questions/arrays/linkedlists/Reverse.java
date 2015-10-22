package com.test.questions.arrays.linkedlists;

/**
 * Created by root on 10/12/15.
 */
public class Reverse
{
	public static void main(String[] args)
	{
		Reverse rv = new Reverse();

		/*ListNode ln = rv.new ListNode(5);

		ln.next = rv.new ListNode(3);

		ln = rv.reverseBetween(ln, 1, 2);

		do
		{
			System.out.println(ln.val);

			ln = ln.next;
		}
		while (ln != null);
*/

		int[] arr = {0, 1, 0, 3, 12};


		rv.moveZeroes(arr);

		for (int i: arr) {
			System.out.println(i);
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		if (m == n || head == null || head.next == null)
		{
			return head;
		}

		java.util.Stack<ListNode> stack = new java.util.Stack<ListNode>();

		int counter = 1;

		ListNode node = head;

		boolean foundLast = false;

		boolean foundFirst = false;

		ListNode beforeFirst = null;

		ListNode afterLast = null;

		while (!foundLast)
		{
			if (m == counter)
			{
				foundFirst = true;
			}

			if (foundFirst)
			{
				stack.push(node);
			}

			if (n == counter)
			{
				foundLast = true;

				if (node != null)
				{
					afterLast = node.next;
				}
			}
			else
			{
				counter++;

				if (!foundFirst)
				{
					beforeFirst = node;
				}

				node = node.next;
			}

		}

		while (!stack.isEmpty())
		{
			ListNode nd = stack.pop();

			if (beforeFirst != null)
			{
				beforeFirst.next = nd;
			}
			else
			{
				head = nd;
			}

			beforeFirst = nd;
		}

		beforeFirst.next = afterLast;

		return head;
	}

	public int myAtoi(String str) {
		if (str == null || "".equals(str)) {
			return 0;
		}

		byte[] digits = str.getBytes();

		long value = 0;

		long tens = 1;

		byte sign = 1;

		byte ascii0 = (byte)('0');
		byte ascii9 = (byte)('9');
		byte asciiPlus = (byte)('+');
		byte asciiMinus = (byte)('-');
		byte asciiSpace = (byte)(' ');

		boolean foundDigit = false;
		boolean foundSign = false;

		for (int i = 0; i< digits.length; i++) {
			if (digits[i] >=ascii0 && digits[i] <= ascii9) {
				value = (value*tens)+(digits[i]-ascii0);

				if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
					break;
				}

				tens*=10;

				foundDigit = true;
			}
			else {
				if (foundDigit) {
					break;
				}
				else if (foundSign) {
					return 0;
				}
				else if (digits[i] == asciiPlus) {
					foundSign = true;
				}
				else if (digits[i] == asciiMinus) {
					sign = -1;

					foundSign = true;
				}
				else if (digits[i] != asciiSpace) {
					return 0;
				}
			}
		}

		if (sign == -1) {
			value = -value;
		}

		if (value > Integer.MAX_VALUE) {
			value = Integer.MAX_VALUE;
		}

		if (value < Integer.MIN_VALUE) {
			value = Integer.MIN_VALUE;
		}

		return (int)value;
	}

	public void moveZeroes(int[] nums) {
			int len = nums.length;

		for (int i = 0; i<len; i++) {
			if (nums[i] == 0) {
				shiftArray(nums, i, len);
			}
			else {
				i++;
			}
		}
	}

	public void shiftArray(int[] arr, int pos, int len) {
		int tmp = arr[pos];

		for (int i = pos; i<len-1; i++) {
			arr[i] = arr[i+1];
		}

		arr[len-1] = tmp;
	}

	final class ListNode
	{
		int val;

		public ListNode next;

		public ListNode(int val)
		{
			this.val = val;
		}
	}
}
