package com.test.questions.arrays.linkedlists;

import java.util.Stack;

/**
 * Created by dmitriy on 8/19/15.
 */
public class SortedStack extends Stack<Integer>
{
	private Stack<Integer> aux;

	private Stack<Integer> stack;

	private boolean sorted = false;

	public static void main(String[] args)
	{
		SortedStack sortedStack = new SortedStack();

		sortedStack.push(4);
		sortedStack.push(1);
		sortedStack.push(8);
		sortedStack.push(9);
		sortedStack.push(3);
		sortedStack.push(2);
		sortedStack.push(5);
		sortedStack.push(6);
		sortedStack.push(10);
		sortedStack.push(7);

		while (!sortedStack.isEmpty())
		{
			System.out.println(sortedStack.pop());
		}
	}

	private void emptyAux()
	{
		while (!aux.isEmpty())
		{
			stack.push(aux.pop());
		}
	}

	public SortedStack()
	{
		stack = new Stack<Integer>();

		aux = new Stack<Integer>();
	}

	public Integer push(Integer value)
	{
		if (sorted)
		{
			while (!aux.isEmpty())
			{
				stack.push(aux.pop());
			}
		}

		sorted = false;

		return stack.push(value);
	}

	public Integer pop()
	{
		if (!sorted)
		{
			sort();
		}

		return aux.pop();
	}

	@Override
	public Integer peek()
	{
		if (!sorted)
		{
			sort();
		}

		return aux.peek();
	}

	@Override
	public boolean empty()
	{
		return stack.empty() && aux.empty();
	}

	@Override
	public synchronized boolean isEmpty()
	{
		return stack.isEmpty() && aux.isEmpty();
	}

	@Override
	public int search(Object o)
	{
		return stack.search(o);
	}

	public void sort()
	{
		aux.removeAllElements();

		while (!stack.isEmpty())
		{
			Integer value = stack.pop();

			if (!aux.isEmpty())
			{
				Integer auxValue = aux.peek();

				if (value < auxValue)
				{
					emptyAux();
				}
			}

			aux.push(value);
		}

		sorted = true;
	}
}
