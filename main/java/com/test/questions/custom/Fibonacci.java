package com.test.questions.custom;

/**
 * Created by root on 10/30/15.
 */
public class Fibonacci
{

	public static void main(String[] args)
	{
		System.out.println(fibo(20));
	}

	public static int fibo(int n)
	{
		return (n ==1 || n==2)?1:(fibo(n-2)+fibo(n-1));
	}
}
