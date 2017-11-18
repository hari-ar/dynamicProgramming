package com.dynamicprogramming.knapsack;

/*Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of 
this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

value[] = {60, 100, 120}
weight[] = {10,20,30}
W = 50

Result = 220 */


public class KnapSackProblem {

	
	public static void main(String[] args) {
		int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapSack(W, wt, val, n));
	}
	
	
	public static int knapSack(int W, int[] wt, int[] val, int n){
		
		int[][] result = new int[n+1][W+1];
		
		for(int i=0; i<=n; i++){
			for(int w=0; w<=W; w++){
				if(i==0 || w==0)
					result[i][w] = 0;
				else if(wt[i-1] <= w)
					result[i][w] = Math.max(val[i-1]+result[i-1][w-wt[i-1]],  result[i-1][w]);
				else
					result[i][w] = result[i-1][w];
				
			}
		}
		return result[n][W];
	}
}
