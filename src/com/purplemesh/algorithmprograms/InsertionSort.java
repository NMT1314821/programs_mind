package com.purplemesh.algorithmprograms;

import com.purplemesh.utility.Utility;

public class InsertionSort
{
	public static void main(String[] args)
	{
		String str=Utility.getString();
		String arr[]=str.split(" ");
		int len=arr.length;
		for(int i=1;i<len;i++)
		{
			String key=arr[i];
			int j=i-1;
			while(j>=0 && arr[j].compareTo(key)>0)
			{
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		
		for(int i=0;i<len;i++) 
		{
			System.out.print(arr[i]+" ");
		}
    }
}
