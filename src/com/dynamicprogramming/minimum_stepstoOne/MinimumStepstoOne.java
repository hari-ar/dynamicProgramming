/*Problem Statement: On a positive integer, you can perform any one of the following 3 steps. 
1.) Subtract 1 from it ( n = n - 1 )
2.) If its divisible by 2, divide by 2 ( if n % 2 == 0 , then n = n / 2  )
3.) If its divisible by 3, divide by 3 ( if n % 3 == 0 , then n = n / 3  )

Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
eg: 1.)For n = 1 , output: 0       2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    3.)  For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )*/



package com.dynamicprogramming.minimum_stepstoOne;

public class MinimumStepstoOne {
	
	public static void main(String[] args) {
		
		System.out.println(MinimumStepstoOne.minimumStepstoOne(1));
		
		System.out.println(MinimumStepstoOne.minimumStepstoOne(4));
		
		System.out.println(MinimumStepstoOne.minimumStepstoOne(7));
		
		System.out.println(MinimumStepstoOne.minimumStepstoOne(10));
	}
	
	public static int minimumStepstoOne(int n){
		if(n <= 1)
			return 0;
		int[] table = new int[n+1];
		table[1] = 0;
		for(int i=2; i<=n; i++){
			table[i] = 1 + table[i-1];
			if(i%2 == 0)
				table[i] = Math.min(table[i], 1+table[i/2]);
			if(i%3 == 0)
				table[i] = Math.min(table[i], 1+table[i/3]);
		}
		return table[n];
	}

}
