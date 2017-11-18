package com.dynamicprogramming.max_sub_sequence;

import java.util.Arrays;

/*The max­i­mum sub­ar­ray prob­lem is the task of find­ing the con­tigu­ous sub­ar­ray 
within a one-dimensional array of num­bers which has the largest sum

int [] A = {−2, 1, −3, 4, −1, 2, 1, −5, 4};

Output: contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

*/

public class MaximumSubSequence {

	public static void main(String[] args) {
		int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray is  " + findMaxSubSequence(arr));
	}
	
	public static int findMaxSubSequence(int[] arr){
		int[] MSS = new int[arr.length+1];
		
		MSS[0] = 0;
		
		for(int i=1; i<=arr.length; i++){
			MSS[i] = Math.max(arr[i-1], MSS[i-1]+arr[i-1]);
		}
		Arrays.sort(MSS, 0, MSS.length);
		return MSS[MSS.length-1];
	}
}
