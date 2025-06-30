package com.purplemesh.functionalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.purplemesh.utility.Utility;

public class Quadratic {

  public static void main(String[] args)
  {
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    double a = Utility.getDouble();
    double b = Utility.getDouble();
    double c = Utility.getDouble();

    double delta = Math.pow(b, 2) - 4 * a * c;

    if (delta < 0) {
      writer.println("No real roots");
    } else {
      double root1 = (-b + Math.sqrt(delta)) / (2 * a);
      double root2 = (-b - Math.sqrt(delta)) / (2 * a);

      writer.println("Root 1: " + root1);
      writer.println("Root 2: " + root2);
    }
    writer.close();
  }
}
