package com.test.questions.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by root on 11/16/15.
 */
public class TreeMapTestSubMap
{
	public static void main(String[] args)
	{
		TreeMap<String, String> map = new TreeMap<String, String>();

		map.put("harold", "1");
		map.put("hans", "2");
		map.put("heinz", "3");

		Map<String, String> submap = map.subMap("ha", true, "hb", false);

		for (Map.Entry<String, String> entry : submap.entrySet())
		{
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
