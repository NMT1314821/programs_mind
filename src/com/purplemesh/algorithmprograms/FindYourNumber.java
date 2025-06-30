package com.purplemesh.algorithmprograms;

import com.purplemesh.utility.Utility;

public class FindYourNumber 
{
	    public static void main(String[] args) {
	        // Check if the user provided N as a command-line argument
	        if (args.length != 1) {
	            System.out.println("Usage: java GuessYourNumber <N>");
	            return;
	        }

	        int N = Integer.parseInt(args[0]);

	        System.out.println("Think of a number between 0 and " + (N - 1));
	        System.out.println("I will guess it in log2(N) steps or fewer.\n");

	        int guessedNumber = guess(0, N - 1);
	        System.out.println("\nYour number is: " + guessedNumber);
	    }

	    // Recursive binary search function
	    public static int guess(int low, int high)
	    {
	        if (low == high) {
	            return low;
	        }

	        int mid = (low + high) / 2;
	        System.out.println("Is your number between " + low + " and " + mid + "? (true/false)");

	        boolean isInLowerHalf = Utility.getBoolean();

	        if (isInLowerHalf) {
	            return guess(low, mid);
	        } 
	        else 
	        {
	            return guess(mid + 1, high);
	        }
	   }
}

	

