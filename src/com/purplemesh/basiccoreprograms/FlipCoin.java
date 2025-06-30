package com.purplemesh.basiccoreprograms;

import com.purplemesh.utility.Utility;

public class FlipCoin {
    public static void main(String[] args)
    {
        System.out.println("How many times do you want to flip the coin?");
        int n = Utility.number();  

        
        while (n <= 0) 
        {
            System.out.print("Enter a positive number: ");
            n = Utility.number();
        }

        int heads = 0;
        int tails = 0;

        for (int i = 0; i < n; i++) {
            double random = Math.random();
            //System.out.println(random);
            if (random < 0.5) {
                tails++;
            } else {
                heads++;
            }
        }
        
        double headp = (heads * 100.0) / n;
        double tailp = (tails * 100.0) / n;

        System.out.printf("Heads: %d (%.2f%%)%n", heads, headp);
        System.out.printf("Tails: %d (%.2f%%)%n", tails, tailp);
    }
}

