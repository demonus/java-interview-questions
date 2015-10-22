package com.test.questions.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitriy on 9/30/15.
 */
public class LruCache
{
	private CacheNode first = null;

	private CacheNode last = null;

	private Map<String, CacheNode> cacheIndex = new HashMap<String, CacheNode>();

	private int capacity;


	public static void main(String[] args) throws Exception
	{
		LruCache cache = new LruCache();

		cache.setCapacity(5);

		cache.addToCache("1", "tetst 1");
		cache.addToCache("2", "tetst 2");
		cache.addToCache("3", "tetst 3");
		cache.addToCache("4", "tetst 4");
		cache.addToCache("5", "tetst 5");

		cache.addToCache("3", "correct 3");

		System.out.println("getting cache key 1: " + cache.getFromCache("1"));

		cache.addToCache("6", "tetst 6");
		cache.addToCache("7", "tetst 7");

		cache.printCache();
	}


	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	public void addToCache(String key, Object value) throws Exception
	{
		if (!cacheIndex.containsKey(key))
		{
			if (cacheIndex.size() == capacity)
			{
				System.out.println("cache is full");

				if (last != null)
				{
					cacheIndex.remove(last.getKey());

					deleteNode(last);
				}
				else
				{
					throw new Exception("Cache problem " + capacity);
				}
			}

			CacheNode node = new CacheNode(key, value);

			addNode(node);

			cacheIndex.put(key, node);

			System.out.println("added " + key + " <=> " + value);
		}
		else
		{
			CacheNode node = cacheIndex.get(key);

			if (node != null)
			{
				pop(node);

				node.setValue(value);

				System.out.println("updated " + key + " <=> " + value);
			}
		}
	}

	public Object getFromCache(String key)
	{
		if (cacheIndex.containsKey(key))
		{
			CacheNode node = cacheIndex.get(key);

			if (node != null)
			{
				pop(node);

				System.out.println("found and moved to the top " + key);

				return node.getValue();
			}
			else
			{
				System.out.println("node is null " + key);

				return null;
			}
		}
		else
		{
			System.out.println("not found " + key);

			return null;
		}
	}

	public void deleteFromCache(String key)
	{
		if (cacheIndex.containsKey(key))
		{
			System.out.println("deleting " + key);

			CacheNode node = cacheIndex.get(key);

			if (node != null)
			{
				System.out.println("delete cache node " + key);

				deleteNode(node);

				cacheIndex.remove(key);
			}
		}
	}

	private void addNode(CacheNode node)
	{
		if (node != null)
		{
			if (first != null)
			{
				System.out.println("add - cache is NOT empty " + node.getValue());

				node.setNext(first);

				node.setPrev(null);

				first.setPrev(node);

				first = node;
			}
			else
			{
				System.out.println("add - cache is empty " + node.getValue());

				first = node;

				last = node;

				node.setNext(null);
				node.setPrev(null);
			}
		}
	}

	private void deleteNode(CacheNode node)
	{
		if (node != null)
		{
			if (node.prev != null)
			{
				System.out.println("delete - node is not first: " + node.getValue());

				node.prev.setNext(node.next);
			}
			else
			{
				System.out.println("delete - node is first: " + node.getValue());

				first = node.next;
			}

			if (node.next != null)
			{
				System.out.println("delete - node is not last: " + node.getValue());

				node.next.setPrev(node.prev);
			}
			else
			{
				System.out.println("delete - node is last: " + node.getValue());

				last = node.prev;
			}
		}
	}

	private void pop(CacheNode node)
	{
		if (node != null)
		{
			deleteNode(node);

			addNode(node);
		}
	}

	public void printCache()
	{
		System.out.println("\n**** PRINTING CACHE *****");
		CacheNode node = first;

		while (node != null)
		{
			System.out.println(node.getKey() + " : " + node.getValue());

			node = node.getNext();
		}
	}

	final class CacheNode
	{
		String key;

		Object value;

		CacheNode prev;

		CacheNode next;

		public CacheNode(String key, Object value, CacheNode prev, CacheNode next)
		{
			this.key = key;
			this.value = value;
			this.prev = prev;
			this.next = next;
		}

		public CacheNode(String key, Object value)
		{
			this(key, value, null, null);
		}

		public Object getValue()
		{
			return value;
		}

		public String getKey()
		{
			return key;
		}

		public void setKey(String key)
		{
			this.key = key;
		}

		public void setValue(Object value)
		{
			this.value = value;
		}

		public CacheNode getPrev()
		{
			return prev;
		}

		public void setPrev(CacheNode prev)
		{
			this.prev = prev;
		}

		public CacheNode getNext()
		{
			return next;
		}

		public void setNext(CacheNode next)
		{
			this.next = next;
		}
	}
}
