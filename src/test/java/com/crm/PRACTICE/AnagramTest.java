package com.crm.PRACTICE;

import org.testng.annotations.Test;

import java.util.Arrays;

public class AnagramTest
{
    @Test
    public void anagramTest()
    {
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

