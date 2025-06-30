package com.purplemesh.algorithmprograms;

import java.util.*;

public class StringPermutations {

    // Recursive method to generate permutations
    public static List<String> permutationsRecursive(String str) {
        List<String> result = new ArrayList<>();
        permuteHelper(str.toCharArray(), 0, result);
        return result;
    }

    private static void permuteHelper(char[] arr, int index, List<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permuteHelper(arr, index + 1, result);
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Iterative method to generate permutations using Heap's algorithm
    public static List<String> permutationsIterative(String str) {
        List<String> result = new ArrayList<>();
        char[] arr = str.toCharArray();
        int n = arr.length;
        int[] c = new int[n];
        result.add(new String(arr));

        int i = 0;
        while (i < n) {
            if (c[i] < i) {
                if (i % 2 == 0) {
                    swap(arr, 0, i);
                } else {
                    swap(arr, c[i], i);
                }
                result.add(new String(arr));
                c[i]++;
                i = 0;
            } else {
                c[i] = 0;
                i++;
            }
        }
        return result;
    }

    // Method to check if two Lists contain the same elements (order-independent)
    public static boolean arePermutationListsEqual(List<String> list1, List<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        // Sort both lists and compare
        List<String> sorted1 = new ArrayList<>(list1);
        List<String> sorted2 = new ArrayList<>(list2);
        Collections.sort(sorted1);
        Collections.sort(sorted2);
        return sorted1.equals(sorted2);
    }

    public static void main(String[] args) {
        String input = "ABC";

        List<String> recursivePerms = permutationsRecursive(input);
        System.out.println("Recursive Permutations: " + recursivePerms);

        List<String> iterativePerms = permutationsIterative(input);
        System.out.println("Iterative Permutations: " + iterativePerms);

        boolean equal = arePermutationListsEqual(recursivePerms, iterativePerms);
        System.out.println("Are both permutation lists equal? " + equal);
    }
}
