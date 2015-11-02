package com.test.questions.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmitriy on 8/6/15.
 */
public class LinkedListMedianElement
{

	public static void main(String[] args)
	{
		List<Element> list = new LinkedList<Element>();

		list.add(new Element("1"));
		list.add(new Element("2"));
		Element e3 = new Element("3");
		list.add(e3);
		list.add(new Element("4"));
		list.add(new Element("5"));
		list.add(new Element("6"));
		list.add(new Element("7"));

		Iterator<Element> iterator = list.iterator();

		Iterator<Element> iteratorSecondary = list.iterator();

		Element median = null;

		while (iterator.hasNext())
		{
			iterator.next();

			median = iteratorSecondary.next();

			if (iterator.hasNext())
			{
				iterator.next();
			}
			else
			{
				break;
			}
		}

		if (median == null && list.size() > 0)
		{
			median = list.get(0);
		}

		System.out.println(median);

		Iterator<Element> iLoop = list.iterator();

		Iterator<Element> iLoopSecondary = list.iterator();

		while (iLoop.hasNext())
		{
			iLoop.next();

			if (iLoop.hasNext())
			{
				if (iLoop.next().equals(iLoopSecondary.next()))
				{
					System.out.println("Has cyclic link");
					break;
				}
			}
			else
			{
				break;
			}
		}

	}
}

class Element
{
	private String value;

	public Element(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("Element{");
		sb.append("value='").append(value).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
