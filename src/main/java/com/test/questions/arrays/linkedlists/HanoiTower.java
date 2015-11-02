package com.test.questions.arrays.linkedlists;

import java.util.Stack;

/**
 * Created by dmitriy on 8/19/15.
 */
public class HanoiTower
{
	public static void main(String[] args)
	{
		HanoiTower hanoiTower = new HanoiTower();

		NamedStack<String> tower = new NamedStack<String>("Source Tower");

		/*tower.push("10");
		tower.push("9");
		tower.push("8");
		tower.push("7");
		tower.push("6");*/
		tower.push("5");
		tower.push("4");
		tower.push("3");
		tower.push("2");
		tower.push("1");

		NamedStack<String> midTower = new NamedStack<String>("Center Tower");
		NamedStack<String> destinationTower = new NamedStack<String>("Destination Tower");

		hanoiTower.moveBlock(5, tower, midTower, destinationTower);

		while (!destinationTower.empty())
		{
			System.out.println(destinationTower.pop());
		}
	}

	public void moveBlock(int count, NamedStack<String> start, NamedStack<String> mid, NamedStack<String> end)
	{
		if (count == 1)
		{
			String value = start.pop();

			end.push(value);

			System.out.println("# " + start.getName() + " :" + value + ": --> " + end.getName());
		}
		else
		{
			System.out.println("== 1 ==");
			moveBlock(count - 1, start, end, mid);

			System.out.println("== 2 ==");
			moveBlock(1, start, mid, end);

			System.out.println("== 3 ==");
			moveBlock(count - 1, mid, start, end);
		}
	}
}

class NamedStack<E> extends Stack<E>
{
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public NamedStack(String name)
	{
		this.name = name;
	}
}
