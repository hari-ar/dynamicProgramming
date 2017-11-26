package com.dynamicprogramming.partition_set_into_k_subsets;
/*
Given two numbers n and k where n represents number of elements in a set, find number of ways to partition the set into k subsets.

Example:

Input: n = 3, k = 2
Output: 3
Explanation: Let the set be {1, 2, 3}, we can partition
             it into 2 subsets in following ways
             {{1,2}, {3}},  {{1}, {2,3}},  {{1,3}, {2}}  

Input: n = 3, k = 1
Output: 1
Explanation: There is only one way {{1, 2, 3}}
*/
             
public class PartitionSetIntoKSubsets {

	public static void main(String[] args) {
		int result = countSubsets(5,2);
		System.out.println("Number of total subsets:: "+result);
	}
	
	public static int countSubsets(int n, int k){
		int[][] DP = new int[n+1][k+1];
		
		for(int i=0; i<=n; i++)
			DP[i][0] = 0;
		for(int j=0; j<=k; j++)
			DP[0][j] = 0;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<=k; j++){
				if(j>i)
					continue;
				if(j==1 || i==j)
					DP[i][j] = 1;
				else
					DP[i][j] = j*DP[i-1][j] + DP[i-1][j-1];
			}
		}
		return DP[n][k];
	}
	
}
