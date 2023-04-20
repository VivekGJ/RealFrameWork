package com.crm.PRACTICE;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class DemoTest 
{
	@Test(priority = 1)
	public void test1()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("Name","Vivek");
		map.put("Age","27");
//		Set<Map.Entry<String, String>> set = map.entrySet();
//		System.out.println(set);

		System.out.println(map.keySet());


		//System.out.println("this is test 1");
	}
	@Test
	public void test2()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("vivek");
		list.add("sagar");
		list.set(1,"amit");
		list.remove(0);
		System.out.println(list);



		System.out.println("this is test 2");
	}
	@Test(priority = 3)
	public void test3()
	{
		System.out.println("this is test 3");
	}

	@Test
	public void test5() {

		String str1 = "Race";
		String str2 = "Care";

		if (str1.length() == str2.length())
		{
			char[] ch1 = str1.toLowerCase().toCharArray();
			char[] ch2 = str2.toLowerCase().toCharArray();

			Arrays.sort(ch1);
			Arrays.sort(ch2);

			boolean result= Arrays.equals(ch1,ch2);

			if(result)
			{
				System.out.println(str1+" and "+str2+" anagram");

			}
			else
			{
				System.out.println(str1+""+str2+"not an anagram");
			}


		}
		else
		{
			System.out.println(str1+""+str2+"anagram");
		}


	}

}

