package com.test.questions.tree.binary;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by root on 11/16/15.
 */
public class BinarySearchTreeTraverse
{
	public static void main(String[] args)
	{
		DefaultBinaryTree binaryTree = new DefaultBinaryTree(9);

		binaryTree.fillSampleData();

		TreeNode node = binaryTree.getRoot();

		BinarySearchTreeTraverse traverse = new BinarySearchTreeTraverse();

		traverse.traverseInline(node);

		System.out.println("\n\n\n");

		traverse.traverseInNonRecursive(node);
	}

	public void traversePostNonRecursive(TreeNode node)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(node);

		while (!stack.isEmpty())
		{
			TreeNode nd = stack.peek();

			if ((nd.getLeftChild() == null && nd.getRightChild() == null) || node.equals(nd.getLeftChild()) ||
					node.equals(
							nd.getRightChild()))
			{
				System.out.println(nd.getData());

				stack.pop();

				node = nd;
			}
			else
			{
				if (nd.getRightChild() != null)
				{
					stack.push(nd.getRightChild());
				}

				if (nd.getLeftChild() != null)
				{
					stack.push(nd.getLeftChild());
				}
			}
		}
	}

	public void traversePreNonRecursive(TreeNode node)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();

		stack.push(node);

		while (!stack.isEmpty())
		{
			TreeNode nd = stack.pop();

			System.out.println(nd.getData());

			if (nd.getRightChild() != null)
			{
				stack.push(nd.getRightChild());
			}

			if (nd.getLeftChild() != null)
			{
				stack.push(nd.getLeftChild());
			}
		}
	}


	public void traverseInNonRecursive(TreeNode node)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (!stack.empty() || node != null)
		{
			if (node != null)
			{
				stack.push(node);

				node = node.getLeftChild();
			}
			else
			{
				node = stack.pop();

				System.out.println(node);

				node = node.getRightChild();
			}
		}
	}

	public void traversePost(TreeNode node)
	{
		if (node != null)
		{
			if (node.getLeftChild() != null)
			{
				traversePost(node.getLeftChild());
			}
			if (node.getRightChild() != null)
			{
				traversePost(node.getRightChild());
			}

			System.out.println(node.getData());
		}
	}

	public void traversePre(TreeNode node)
	{
		if (node != null)
		{
			System.out.println(node.getData());

			if (node.getLeftChild() != null)
			{
				traversePre(node.getLeftChild());
			}
			if (node.getRightChild() != null)
			{
				traversePre(node.getRightChild());
			}
		}
	}

	public void traverseInline(TreeNode node)
	{
		if (node != null)
		{
			if (node.getLeftChild() != null)
			{
				traverseInline(node.getLeftChild());
			}

			System.out.println(node.getData());

			if (node.getRightChild() != null)
			{
				traverseInline(node.getRightChild());
			}
		}
	}
}
