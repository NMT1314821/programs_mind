package com.purplemesh.algorithmprograms;

import java.util.*;

public class PrimeAnagramPalindrome extends PrimeNumberRange {

    public static boolean isPalindrome(int num)
    {
        String s = Integer.toString(num);
        int left = 0, right = s.length() - 1;
        while (left < right) 
        {
            if (s.charAt(left) != s.charAt(right))
            	return false;
            	left++;
            	right--;
        }
        return true;
    }

    public static boolean areAnagrams(int num1, int num2)
    {
        char[] arr1 = Integer.toString(num1).toCharArray();
        char[] arr2 = Integer.toString(num2).toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) 
    {
        List<Integer> primes = getPrimeList(0, 1000);   
        System.out.println("\nPalindrome primes between 0 and 1000:");
        for (int prime : primes)
        {
            if (isPalindrome(prime)) 
            {
                System.out.print(prime + " ");
            }
        }


        System.out.println("\n\nPrime anagram pairs between 0 and 1000:");
        Set<String> printedPairs = new HashSet<>();
        for (int i = 0; i < primes.size(); i++) 
        {
            for (int j = i + 1; j < primes.size(); j++) 
            {
                int num1 = primes.get(i);
                int num2 = primes.get(j);
                if (areAnagrams(num1, num2)) 
                {
                    String pair = num1 + "," + num2;
                    if (!printedPairs.contains(pair)) {
                        System.out.println(num1 + " and " + num2);
                        printedPairs.add(pair);
                    }
                }
            }
        }
    }
}
