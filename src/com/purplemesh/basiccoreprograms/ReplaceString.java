package com.purplemesh.basiccoreprograms;

import com.purplemesh.utility.Utility;

public class ReplaceString
{
	public static void main(String[] args) 
	{
		String str= "Hello <<UserName>>, How are you?";
		System.out.println("Enter the Username");
		String name=Utility.getNameReplace();
		if(name.length()>3)
		{
			str=str.replace("<<UserName>>",name);
			System.out.println(str);
		}
		else
		{
			System.out.println("The name should be at least 3 characters");
		}
	}
}
