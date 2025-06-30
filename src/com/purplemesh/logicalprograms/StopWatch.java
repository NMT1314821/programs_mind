package com.purplemesh.logicalprograms;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StopWatch
{

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter how many stopwatch trials you want to run: ");
	        int trials = scanner.nextInt();
	        scanner.nextLine(); 

	        IntStream.rangeClosed(1, trials).forEach(i -> {
	            System.out.printf("%nTrial %d - Press ENTER to start...", i);
	            scanner.nextLine();

	            long start = System.currentTimeMillis();

	            System.out.println("Stopwatch started. Press ENTER to stop...");
	            scanner.nextLine();

	            long end = System.currentTimeMillis();

	            double elapsed = (end - start) / 1000.0;
	            System.out.printf("Trial %d Elapsed Time: %.3f seconds%n", i, elapsed);
	        });

	        scanner.close();
	    }
	}
