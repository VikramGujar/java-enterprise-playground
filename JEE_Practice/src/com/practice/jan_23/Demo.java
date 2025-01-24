package com.practice.jan_23;

public class Demo 
{

	public static void main(String[] args) 
	{
		int[][] arr = new int [3][];
		arr[0] = new int[2];
		arr[1] = new int[5];
		arr[2] = new int[7];
		
		int arrLegth = 0;
		for(int[]a : arr)
		{
			for(int an : a)
			{
				arrLegth++;
			}
		}
		
		System.out.println(arrLegth);

	}

}
