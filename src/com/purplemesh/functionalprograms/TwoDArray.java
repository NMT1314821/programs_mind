package com.purplemesh.functionalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDArray 
{

  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[][] array = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        array[i][j] = scanner.nextInt();
      }
    }

    writer.println("The 2D array is:");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        writer.print(array[i][j] + " ");
      }
      writer.println();
    }

    scanner.close();
    writer.close();
  }
}
