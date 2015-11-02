package com.test.questions.arrays.linkedlists;

/**
 * Created by root on 11/1/15.
 */
public class Node
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
