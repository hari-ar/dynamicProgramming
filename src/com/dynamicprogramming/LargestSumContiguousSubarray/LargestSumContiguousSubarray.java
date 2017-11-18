package com.dynamicprogramming.LargestSumContiguousSubarray;

import java.util.Arrays;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {
		int[] array = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(largestSumContiguousSubarray(array));
	}
	
	public static int largestSumContiguousSubarray(int[] array){
		int[] LSC = new int[array.length];
		Arrays.fill(LSC, Integer.MIN_VALUE);
		int start_index=0, end_index=0;
		LSC[0] = array[0];
		int max_value=Integer.MIN_VALUE;
		for(int i=1; i<array.length; i++){
			LSC[i] = Math.max(LSC[i-1]+array[i], array[i]);
			if(LSC[i] == array[i]){
				start_index = i;
				end_index = i;
			}
			else{
				end_index = i;
			}
			if(max_value < LSC[i]){
				max_value = LSC[i];
			}
		}
		System.out.println("START INDEX = "+start_index);
		System.out.println("END_INDEX = "+end_index);
		return max_value;
	}
}
