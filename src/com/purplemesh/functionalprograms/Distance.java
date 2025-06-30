package com.purplemesh.functionalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Distance {

  public static void main(String[] args) {
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    if (args.length != 2) {
      writer.println("Please provide exactly two integer arguments.");
      writer.close();
      return;
    }

    int x = Integer.parseInt(args[0]);
    int y = Integer.parseInt(args[1]);

    double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

    writer.println("Euclidean distance from (" + x + ", " + y + ") to the origin is: " + distance);

    writer.close();
  }
}