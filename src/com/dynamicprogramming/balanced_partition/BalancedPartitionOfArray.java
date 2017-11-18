package com.dynamicprogramming.balanced_partition;

/*Given a set of integers, the task is to divide it into two sets S1 and S2 such that the 
absolute difference between their sums is minimum.

If there is a set S with n elements, then if we assume Subset1 has m elements, 
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11
*/

public class BalancedPartitionOfArray {

	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 2, 2, 1};
	    int n = arr.length;
	    System.out.println(findMin(arr, n));
	}
	
	public static int findMin(int[] arr, int n){
		int sum = 0;
		for(int i=0; i<n; i++)
			sum = sum + arr[i];
			
		int[][] DP = new int[n+1][sum+1];
		//Initialize first column as true. 0 sum is possible with all elements.
		for(int i=0; i<=n;i++)
			DP[i][0] = 1;
		// Initialize top row, except dp[0][0], as false. With 0 elements, no other sum except 0 is possible
		for(int i=0; i<=sum; i++)
			DP[0][i] = 0;
		
		for(int i=1; i<=n; i++){
			for(int j=1; j<= sum; j++){
				DP[i][j] = DP[i-1][j];
				if(arr[i-1] <= j)
					DP[i][j] = DP[i-1][j-arr[i-1]];
			}
		}
		
		int diff = 0;
		// Find the largest j such that dp[n][j] is true where j loops from sum/2 t0 0
		for(int i=sum/2; i>=0; i--){
			if(DP[n][i] == 1){
				diff = sum - 2*i;
				break;
			}
		}
		return diff;
	}
	
	
}
