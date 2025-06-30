package com.purplemesh.functionalprograms;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import com.purplemesh.utility.Utility;

public class TwoDArray 
{

		public static int[][] readInt2DArray(int row,int column)
		{
			System.out.println("Enter "+ (row*column)+ "numbers:");
			int[][] array = new int[row][column];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					array[i][j]= Utility.number();
				}
			}
			return array;
		}
		public static void printInt2DArray(int[][] intArray,int row,int column)
		{
			System.out.println("2D Array");
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					System.out.print(intArray[i][j]+ " ");
				}
				System.out.println();
			}
			
		}
				
		public static double[][] readDouble2DArray(int row,int column)
		{
			System.out.println("Enter "+ (row*column)+ "numbers:");
			double[][] array = new double[row][column];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					array[i][j]= Utility.getDouble();
				}
			}
			return array;
		}
		public static void printDouble2DArray(double[][] doubleArray,int row,int column)
		{
			System.out.println("2D Array");
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					System.out.print(doubleArray[i][j]+ " ");
				}
				System.out.println();
			}
			
		}
		public static boolean[][] readBoolean2DArray(int row,int column)
		{
			System.out.println("Enter "+ (row*column)+ "numbers:");
			boolean[][] array = new boolean[row][column];
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					array[i][j]= Utility.getBoolean();
				}
			}
			return array;
		}
		public static void printBoolean2DArray(boolean[][] booleanArray,int row,int column)
		{
			System.out.println("2D Array");
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					System.out.println(booleanArray[i][j]+ " ");
				}
				System.out.println();
			}
			
		}

		public static void main(String[] args) {
			System.out.println("Enter Number of rows: ");
			int row= Utility.number();
			
			System.out.println("Enter Number of columns : ");
			int column = Utility.number();
			
			System.out.println("Chose array type:int/double/boolean ");
			String type = Utility.getNameReplace().toLowerCase();
			
			switch (type)
			{
			case "int":
				System.out.println("Enter Int Values: ");
				int[][] intArray=readInt2DArray(row,column);
				printInt2DArray(intArray, row, column);
				break;
			case "double":
				System.out.println("Enter Int Values: ");
				double[][] doubleArray=readDouble2DArray(row,column);
				printDouble2DArray(doubleArray, row, column);
				break;
			case "boolean":
				System.out.println("Enter Int Values: ");
				boolean[][] booleanArray=readBoolean2DArray(row,column);
				printBoolean2DArray(booleanArray, row, column);
				break;
				
			}		
			
		}
		
}

