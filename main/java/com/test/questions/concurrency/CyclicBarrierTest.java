package com.test.questions.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by root on 11/2/15.
 */
public class CyclicBarrierTest implements Runnable
{
	private CyclicBarrier barrier;

	private int value;

	public void run()
	{
		try
		{
			Thread.currentThread().sleep(value * 1000);

			System.out.println(Thread.currentThread().getName() + ": " + value);

			barrier.await();
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}

	public CyclicBarrierTest(CyclicBarrier barrier, int value)
	{
		this.barrier = barrier;
		this.value = value;

		Thread.currentThread().setName("Thread-" + value);
	}

	public static void main(String[] args)
	{
		System.out.println("Started");

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable()
		{
			public void run()
			{
				System.out.println("Barrier action");
			}
		});

		for (int i = 0; i < 6; i++)
		{
			CyclicBarrierTest barrierTest = new CyclicBarrierTest(cyclicBarrier, i);

			Thread t = new Thread(barrierTest);

			t.start();
		}

		System.out.println("Ran all");
	}
}
