package com.test.questions.arrays.linkedlists;

/**
 * Created by root on 10/12/15.
 */
public class QueueStack
{
	public static void main(String[] args)
	{
		QueueStack queueStack = new QueueStack();

		queueStack.push(1);
		queueStack.push(2);
		queueStack.push(3);
		queueStack.push(4);
		queueStack.push(5);
		queueStack.push(6);

		System.out.println(queueStack.empty());

		while (!queueStack.empty()) {
			System.out.println(queueStack.peek());

			queueStack.pop();
		}
	}

	java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

	java.util.Stack<Integer> reversedStack = new java.util.Stack<Integer>();

	boolean reversed = false;

	// Push element x to the back of queue.
	public void push(int x) {
		if (reversed) {
			while (!reversedStack.isEmpty())
			{
				stack.push(reversedStack.pop());
			}

			reversed = false;
		}

		stack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!reversed) {
			while (!stack.isEmpty())
			{
				reversedStack.push(stack.pop());
			}

			reversed = true;
		}

		reversedStack.pop();
	}

	// Get the front element.
	public int peek() {
		if (!reversed) {
			while (!stack.isEmpty())
			{
				reversedStack.push(stack.pop());
			}

			reversed = true;
		}

		return reversedStack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return reversedStack.empty() && stack.empty();
	}
}
