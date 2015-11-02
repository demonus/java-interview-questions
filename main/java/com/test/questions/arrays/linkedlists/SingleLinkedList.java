package com.test.questions.arrays.linkedlists;

/**
 * Created by dmitriy on 8/13/15.
 */
public class SingleLinkedList
{
	private Node last = null;

	private Node first = null;

	public void add(String data)
	{
		add(new Node(data));
	}

	public void add(Node node)
	{
		if (last != null)
		{
			last.setNext(node);
		}
		else
		{
			first = node;
		}

		last = node;
	}

	public void addReverse(Node node)
	{
		first = node;
	}

	public Node getFirst()
	{
		return first;
	}

	public void setFirst(Node first)
	{
		Node transit = this.first;

		this.first = first;
	}

	public void removeFirst()
	{
		if (first != null)
		{
			this.first = first.getNext();

			if (first == null)
			{
				last = null;
			}
		}
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		if (first == null)
		{
			sb.append("[empty]");
		}
		else
		{
			sb.append(first.getData());

			Node node = first;

			while (node.getNext() != null)
			{
				node = node.getNext();

				sb.append(", ").append(node.getData());
			}
		}

		return sb.toString();
	}
}
