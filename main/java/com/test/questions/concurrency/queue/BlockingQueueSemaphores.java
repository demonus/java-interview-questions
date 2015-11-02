package com.test.questions.concurrency.queue;

import com.test.questions.arrays.linkedlists.Node;
import com.test.questions.arrays.linkedlists.SingleLinkedList;

import java.util.concurrent.Semaphore;

/**
 * Created by root on 11/1/15.
 */
public class BlockingQueueSemaphores
{
	private Semaphore semaphoreFull = new Semaphore(1);
	private Semaphore semaphoreEmpty = new Semaphore(1);

	private SingleLinkedList queue = new SingleLinkedList();

	private int capacity;

	private int size = 0;

	private volatile boolean firstPull = true;

	private volatile boolean firstPut = true;

	public static void main(String[] args) throws InterruptedException
	{
		BlockingQueueSemaphores blockingQueueSemaphores = new BlockingQueueSemaphores(2);

		class InnerThread implements Runnable
		{
			private boolean pullFirst = false;
			private volatile BlockingQueueSemaphores queue;
			private String value;

			public InnerThread(boolean pullFirst, BlockingQueueSemaphores queue, String value)
			{
				this.pullFirst = pullFirst;

				this.queue = queue;

				this.value = value;

				Thread.currentThread().setName("Thread-" + value);
			}

			public void run()
			{
				try
				{
					if (pullFirst)
					{
						System.out.println(Thread.currentThread().getName() + ": value pulled: " + queue.pull());

						Thread.currentThread().sleep(2000);

						queue.put(value);

						System.out.println(Thread.currentThread().getName() + ": value added: " + value);
					}
					else
					{
						queue.put(value);

						System.out.println(Thread.currentThread().getName() + ": value added: " + value);

						Thread.currentThread().sleep(3000);

						System.out.println(Thread.currentThread().getName() + ": value pulled: " + queue.pull());
					}
				}
				catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
			}
		}

		boolean pullFirst = false;

		for (int i = 0; i < 10; i++)
		{
			Thread t = new Thread(new InnerThread(pullFirst, blockingQueueSemaphores, String.valueOf(i)));

			t.start();

			pullFirst = !pullFirst;
		}
	}

	public BlockingQueueSemaphores(int capacity) throws InterruptedException
	{
		this.capacity = capacity;

		semaphoreEmpty.acquire();

		semaphoreFull.acquire();
	}

	public int getCapacity()
	{
		return capacity;
	}

	public void put(String text) throws InterruptedException
	{
		if (size < capacity && firstPut)
		{
			firstPut = false;
			semaphoreFull.release();
		}

		semaphoreFull.acquire();

		queue.add(text);

		size++;

		semaphoreEmpty.release();

		if (size < capacity)
		{
			semaphoreFull.release();
		}

	}

	public String pull() throws InterruptedException
	{
		if (size > 0 && firstPull)
		{
			firstPull = false;

			semaphoreEmpty.release();
		}

		semaphoreEmpty.acquire();

		Node node = queue.getFirst();

		queue.removeFirst();

		size--;

		semaphoreFull.release();

		if (size > 0)
		{
			semaphoreEmpty.release();
		}

		return node.getData();
	}

	public int getSize()
	{
		return size;
	}
}
