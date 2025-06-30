package com.purplemesh.algorithmprograms;

import com.purplemesh.utility.Utility;

public class BubbleSort 
{
	public static void main(String[] args) {
		
		//int arr[]= {3,7,4,2,9};
		System.out.println("Enter the array range");
		int n=Utility.number();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=Utility.number();
		}
		int len=arr.length;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<=arr.length-1;i++)
		{
			System.out.println(arr[i]+" ");
		}
	}
	
}
