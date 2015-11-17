package com.test.questions.tree.binary;

/**
 * Created by root on 11/16/15.
 */
public class DefaultBinaryTree
{
	private TreeNode root;

	public TreeNode getRoot()
	{
		return root;
	}

	public void setRoot(TreeNode root)
	{
		this.root = root;
	}

	public DefaultBinaryTree(int data)
	{
		root = new TreeNode(data);
	}

	public void addNode(int data)
	{
		TreeNode node = root;

		boolean added = false;

		while (!added)
		{
			if (data == node.getData())
			{
				added = true; //duplicate node, ignored
			}
			else if (data > node.getData())
			{
				TreeNode right = node.getRightChild();

				if (right == null)
				{
					node.setRightChild(new TreeNode(data));

					added = true;
				}
				else
				{
					node = right;
				}
			}
			else
			{
				TreeNode left = node.getLeftChild();

				if (left == null)
				{
					node.setLeftChild(new TreeNode(data));

					added = true;
				}
				else
				{
					node = left;
				}
			}
		}
	}

	public void fillSampleData()
	{
		addNode(8);
		addNode(5);
		addNode(17);
		addNode(10);
		addNode(2);
		addNode(6);
		addNode(7);
		addNode(4);
		addNode(1);
		addNode(14);
	}
}

class TreeNode
{
	private int data;

	private TreeNode leftChild;

	private TreeNode rightChild;

	public int getData()
	{
		return data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public TreeNode getLeftChild()
	{
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild)
	{
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild()
	{
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild)
	{
		this.rightChild = rightChild;
	}

	public TreeNode(int data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return String.valueOf(data);
	}
}
