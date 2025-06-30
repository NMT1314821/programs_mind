package com.purplemesh.utility;

import java.util.Random;
import java.util.Scanner;

public class Utility 
{
	
	public static Scanner sc = new Scanner(System.in);
	public static Random random = new Random();
		
		public static String getNameReplace()
		{
			 String str=sc.next();
			 return str;
		}
		public static int number()
		{
			int num=sc.nextInt();
			return num;
		}
		public static String getString()
		{
			String str=sc.nextLine();
			return str;
		}
		
		public static double getDouble()
		{
			double d=sc.nextDouble();
			return d;
		}
		public static boolean getBoolean()
		{
			boolean b=sc.nextBoolean();
			return b;
		}
		
		public static float flipCoin()
		{
			float flip=(float)(Math.random()*2);
			float rounded = (float) (Math.round(flip * 10) / 10.0);
			if (rounded < 0.1) 
			{
	            rounded = (float) 1.0;
	        }
			return rounded;
		}
}
