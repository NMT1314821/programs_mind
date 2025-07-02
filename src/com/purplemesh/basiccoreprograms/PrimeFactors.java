package com.purplemesh.basiccoreprograms;

import com.purplemesh.utility.Utility;

class Factor
{
	public static void primorial(int num)
	{
		for(int i=2;i<=num;i++)
		{
			if(num%i==0 && isPrime(i))
			{
				System.out.println(i);
			}	
		}
	}
	
	public static boolean isPrime(int n)
	{
		if(n<0)
		{
			return false;
		}
		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0)
			{
				return false;
			}
		}
		return true;	
	}
}

public class PrimeFactors 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the prime factors sum");
		int num=Utility.number();
		Factor.primorial(num);	
	}
}
