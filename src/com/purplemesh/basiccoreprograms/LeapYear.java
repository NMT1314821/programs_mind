package com.purplemesh.basiccoreprograms;

import com.purplemesh.utility.Utility;

public class LeapYear
{
	
	public static String leapYear(String year)
	{
		try
		{
			int y=Integer.parseInt(year);
			if(y%4==0 && y%100!=0||y%400==0)
				{
					return "lepear";
				}
				else
				{
					return "not lepear";
				}
			
		}
		catch (Exception e) {
            return "Invalid input=> Please enter a numeric year only.";
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a year");
		String year=Utility.getNameReplace();
		String res=leapYear(year);
		System.out.println(res);
	}

}
