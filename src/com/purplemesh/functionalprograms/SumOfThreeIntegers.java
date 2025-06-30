package com.purplemesh.functionalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.purplemesh.utility.Utility;

public class SumOfThreeIntegers 
{
  public static void main(String[] args) 
  {
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
    System.out.println("Enter the range");
    int n = Utility.number();
    int[] array = new int[n];

    for (int i = 0; i < n; i++)
    {
      array[i] = Utility.number();
    }

    int tripletCount = 0;

    writer.println("Distinct triplets summing to zero:");

    for (int i = 0; i < n - 2; i++) 
    {
      for (int j = i + 1; j < n - 1; j++) 
      {
        for (int k = j + 1; k < n; k++) 
        {
          if (array[i] + array[j] + array[k] == 0) 
          {
            writer.println(array[i] + " " + array[j] + " " + array[k]);
            tripletCount++;
          }
        }
      }
    }
    writer.println("Number of distinct triplets: " + tripletCount);
    writer.close();
  }
}
