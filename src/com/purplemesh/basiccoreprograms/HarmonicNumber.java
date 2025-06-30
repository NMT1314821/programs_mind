package com.purplemesh.basiccoreprograms;

import com.purplemesh.utility.Utility;

class Harmonic
{
	  public float harmonic(int num) {
	        float sum = 0f;
	        System.out.print("Harmonic expression: ");
	        for (int i = 1; i <= num; i++) {
	            sum += 1f / i;
	            if (i == 1) {
	                System.out.print("1");
	            } else {
	                System.out.print(" + 1/" + i);
	            }
	        }
	        return sum;
	    }
}

public class HarmonicNumber {

    public static void main(String[] args) {
        
    	Harmonic hm=new Harmonic();
        System.out.println("Enter the Harmonic value");
        int n = Utility.number();

        if (n <= 0) {
            System.out.println("Invalid input. N must be positive number");
            return;
        }

        float result = hm.harmonic(n);
        System.out.printf("%nThe %dth Harmonic number is: %.5f%n", n, result);
    }

  
}
