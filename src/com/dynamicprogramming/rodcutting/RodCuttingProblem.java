package com.dynamicprogramming.rodcutting;

/*Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * For example, if length of the rod is 8 and the values of different pieces are given as following, 
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

public class RodCuttingProblem {

	public static void main(String[] args) {
		int price[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = price.length;
        System.out.println("Maximum Obtainable Value is " + cutRod(price, size));
	}
	
	public static int cutRod(int[] price, int n){
		int result[] = new int[n+1];
		result[0] = 0;
		
		for(int i=1; i<=n; i++){
			int max_value = Integer.MIN_VALUE;
			for(int j=0; j<i; j++){
				max_value = Math.max(max_value, price[j] + result[i-j-1]);
			}
			result[i] = max_value;
		}
		return result[n];
	}
}
