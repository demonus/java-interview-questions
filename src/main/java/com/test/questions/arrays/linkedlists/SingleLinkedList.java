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

		first.setNext(transit);
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

class Node
{
	private String data;

	private Node next = null;

	public Node(String data)
	{
		this.data = data;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	public Node getNext()
	{
		return next;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		Node node = (Node) o;

		return !(data != null ? !data.equals(node.data) : node.data != null);

	}

	@Override
	public int hashCode()
	{
		return data != null ? data.hashCode() : 0;
	}
}
