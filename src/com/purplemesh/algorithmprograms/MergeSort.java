package com.purplemesh.algorithmprograms;

import java.util.Arrays;

import com.purplemesh.utility.Utility;

public class MergeSort
{

    public static void mergeSort(String[] array, int lo, int hi) {
        if (hi - lo <= 1) {
            return; 
        }

        int mid = lo + (hi - lo) / 2;
  
        mergeSort(array, lo, mid);
        mergeSort(array, mid, hi);

        merge(array, lo, mid, hi);
    }

    private static void merge(String[] array, int lo, int mid, int hi) {
        int leftSize = mid - lo;
        int rightSize = hi - mid;

        String[] left = new String[leftSize];
        String[] right = new String[rightSize];

      
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[lo + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = array[mid + i];
        }

        int i = 0, j = 0, k = lo;

        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = left[i++];
        }
        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
    	
    	String str=Utility.getString();
        String[] input =str.split(" ");
        
        System.out.println("Before sorting: " + Arrays.toString(input));
        
        mergeSort(input, 0, input.length);
        
        System.out.println("After sorting: " + Arrays.toString(input));
    }
}
