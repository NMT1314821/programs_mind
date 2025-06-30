package com.purplemesh.logicalprograms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.purplemesh.utility.Utility;

public class CuponNumbers
{

		//Set<Integer> coupons = new HashSet<Integer>();
	
		private static int randomNumber(int n)
		{
			Random rand=new Random();
			return rand.nextInt(n);
		}
		
		private static int collectCoupons(int n)
		{
			Set<Integer> hs=new HashSet<Integer>();
			int totalRandoms=0;
			while(hs.size()<n)
			{
				int cupon=randomNumber(n);
				totalRandoms++;
				hs.add(cupon);
			}
			return totalRandoms;
		}
		public static void main(String[] args)
		{
			System.out.println("Enter Number of  Coupons :");
			int n=Utility.number();
			int result=collectCoupons(n);
	        System.out.println("Total random numbers generated to collect all " + n + " coupons: " + result);

		}

}


