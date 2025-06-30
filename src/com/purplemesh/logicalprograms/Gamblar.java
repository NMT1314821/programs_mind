package com.purplemesh.logicalprograms;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import com.purplemesh.utility.Utility;

public class Gamblar
{
	    public static void main(String[] args) {
	        
	        System.out.println("Enter initial stake amount: ");
	        int stake = Utility.number();

	        System.out.println("Enter goal amount: ");
	        int goal = Utility.number();
	        System.out.println("Enter number of times to simulate (trials): ");
	        int trials = Utility.number();

	        AtomicInteger wins = new AtomicInteger();
	        AtomicInteger totalBets = new AtomicInteger();

	        
	        IntStream.range(0, trials).forEach(t -> {
	            int cash = stake;

	            while (cash > 0 && cash < goal) {
	                totalBets.incrementAndGet();

	                if (Math.random() < 0.5) cash++;
	                else cash--;
	            }

	            if (cash == goal) wins.incrementAndGet();
	        });

	        double winPercentage = 100.0 * wins.get() / trials;
	        double lossPercentage = 100.0 - winPercentage;

	       
	        System.out.println("\n--- Simulation Results ---");
	        System.out.println("Total Wins       : " + wins.get());
	        System.out.println("Total Bets       : " + totalBets.get());
	        System.out.printf("Win Percentage   : %.2f%%\n", winPercentage);
	        System.out.printf("Loss Percentage  : %.2f%%\n", lossPercentage);
	    }
}



