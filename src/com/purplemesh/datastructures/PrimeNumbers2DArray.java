package com.purplemesh.datastructures;

public class PrimeNumbers2DArray
{
    public static void main(String[] args) 
    {
        int[][] primeRanges = new int[10][]; 
        int rangeSize = 100;

        for (int i = 0; i < 10; i++) 
        {
            int start = i * rangeSize;
            int end = start + rangeSize;
            primeRanges[i] = findPrimesInRange(start, end);
        }
    
        for (int i = 0; i < primeRanges.length; i++)
        {
            System.out.print("Range " + (i * rangeSize) + "-" + ((i + 1) * rangeSize) + ": ");
            for (int prime : primeRanges[i]) 
            {
                System.out.print(prime + " ");
            }
            System.out.println();
        }
    }

    public static int[] findPrimesInRange(int start, int end) 
    {
        java.util.List<Integer> primes = new java.util.ArrayList<>();
        for (int num = Math.max(start, 2); num < end; num++) 
        {
            if (isPrime(num)) 
            {
                primes.add(num);
            }
        }
       
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPrime(int number)
    {
    	if(number<2)
    	{
    		return false;
    	}
    	for(int i=2;i<Math.sqrt(number);i++)
    	{
    		if(number%i==0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
}