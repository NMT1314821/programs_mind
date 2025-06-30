package com.purplemesh.algorithmprograms;

import java.util.Arrays;

import com.purplemesh.utility.Utility;

public class AnagramDetection 
{
	public static void main(String[] args) {
		
		System.out.println("Enter the String: ");
		String s1=Utility.getString();
		System.out.println("Enter the String: ");
		String s2=Utility.getString();
		
		if(s1.length()!=s2.length())
		{
			System.out.println("The given two Strings are: NOT ANAGRAMS");
			
			char a[]=s1.toCharArray();
			char b[]=s2.toCharArray();
			Arrays.sort(a);
			Arrays.sort(b);
			
			if(Arrays.equals(a,b)) 
			{
				System.out.println("The given two strings are: ANAGRAMS");
			}
			else
			{
				System.out.println("The given two String are: NOT ANAGRAMS");
			}
			
		}
		
		
	}

}
