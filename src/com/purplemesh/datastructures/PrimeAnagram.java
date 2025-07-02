package com.purplemesh.datastructures;

import java.util.*;
import java.util.ArrayList;
import java.util.Set;

class PrimeAnagrams extends PrimeNumbers2DArray 
{
    public Set<Integer> findAnagramPrimes(List<Integer> primes) 
    {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int prime : primes) 
        {
            char[] chars = String.valueOf(prime).toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(prime);
        }

        Set<Integer> result = new HashSet<>();
        for (List<Integer> group : map.values()) 
        {
            if (group.size() > 1) result.addAll(group);
        }
        return result;
    }
    
    public void segregateAndPrintPrimes(int rangeSize, int totalRange) 
    {
        int[][] anagramPrimes = new int[totalRange / rangeSize][];
        int[][] nonAnagramPrimes = new int[totalRange / rangeSize][];

        List<Integer> allPrimes = new ArrayList<>();

        for (int i = 0; i < totalRange / rangeSize; i++) 
        {
            int[] primes = findPrimesInRange(i * rangeSize, (i + 1) * rangeSize);
            for (int p : primes)
            {
                allPrimes.add(p);
            }
        }

        Set<Integer> anagramSet = findAnagramPrimes(allPrimes);

        for (int i = 0; i < totalRange / rangeSize; i++) {
            int start = i * rangeSize;
            int end = (i + 1) * rangeSize;
            java.util.List<Integer> anagrams = new ArrayList<>();
            List<Integer> nonAnagrams = new ArrayList<>();
            int[] primes = findPrimesInRange(start, end);

            for (int prime : primes) {
                if (anagramSet.contains(prime)) {
                    anagrams.add(prime);
                } else {
                    nonAnagrams.add(prime);
                }
            }

            anagramPrimes[i] = anagrams.stream().mapToInt(Integer::intValue).toArray();
            nonAnagramPrimes[i] = nonAnagrams.stream().mapToInt(Integer::intValue).toArray();
        }
        
        System.out.println("Primes that are Anagrams:");
        print2DArray(anagramPrimes, rangeSize);

        System.out.println("Primes that are NOT Anagrams:");
        print2DArray(nonAnagramPrimes, rangeSize);
    }

    public void print2DArray(int[][] array, int rangeSize) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Range " + (i * rangeSize) + "-" + ((i + 1) * rangeSize) + ": ");
            for (int num : array[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
class PrimeAnagram {
    public static void main(String[] args) {
        PrimeAnagrams ans = new PrimeAnagrams();
        int rangeSize = 100;      
        int totalRange = 1000;    
        ans.segregateAndPrintPrimes(rangeSize, totalRange);
    }
}
