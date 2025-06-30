package com.purplemesh.basiccoreprograms;

public class PowerOfTwo {

    public static void main(String[] args) {
        try {
            
            if (args.length == 0) {
                throw new IllegalArgumentException("Invalid number, Enter 0 to 30 number");
            }

            int N = Integer.parseInt(args[0]);
           
            if (N < 0 || N >= 31) {
                throw new IllegalArgumentException("N must be 0 to 30");
            }

           
            for (int i = 0; i <= N; i++) {
                int power = (int) Math.pow(2, i);
                System.out.println("2^" + i + " = " + power);
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

