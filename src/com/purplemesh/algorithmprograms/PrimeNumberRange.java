package com.purplemesh.algorithmprograms;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberRange {

    public static List<Integer> getPrimeList(int start, int end) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    private static boolean isPrime(int num)
    {
        if (num < 2) 
        	return false;
        for (int i = 2; i <= Math.sqrt(num); i++) 
        {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> primes = getPrimeList(0, 1000);
        System.out.println("Prime numbers between 0 and 1000:");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}




