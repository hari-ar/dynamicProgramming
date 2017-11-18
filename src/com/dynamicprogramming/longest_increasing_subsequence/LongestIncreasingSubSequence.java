/*The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of 
a given sequence such that all elements of the subsequence are sorted in increasing order. 
For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 
and LIS is {10, 22, 33, 50, 60, 80}.*/

package com.dynamicprogramming.longest_increasing_subsequence;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println("Length of longest increasing subseqence is " + findLongestIncreasingSubSequence(arr));

	}
	
	public static int findLongestIncreasingSubSequence(int[] arr){
		if(arr.length ==1)
			return 1;
		int[] list = new int[arr.length];
		for(int i=0; i<arr.length; i++)
			list[i] = 1;
		for(int i=1; i<arr.length;i++){
			for(int j=0; j<i; j++){
				if((arr[i] > arr[j]) && list[i] < list[j]+1)
					list[i] = list[j]+1;
			}
		}
		
		int max = 0;
		for(int i=0; i<arr.length;i++){
			if(max < list[i])
				max = list[i];
		}
		
		return max;
		
	}

}
