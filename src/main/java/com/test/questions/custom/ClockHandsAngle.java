package com.test.questions.custom;

/**
 * Created by dmitriy on 8/11/15.
 */
public class ClockHandsAngle
{

	public static void main(String[] args)
	{
		int hour = 3;

		int minute = 35;

		double minuteAngle = (minute * 360)/60;

		double oneHourAngle = 360/12;

		double hourAngle = oneHourAngle * (hour % 12) + (minute * oneHourAngle / 60);

		double angle = minuteAngle - hourAngle;

		System.out.println(angle);
	}
}
