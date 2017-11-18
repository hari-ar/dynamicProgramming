package com.dynamicprogramming.longest_palindromic_subsequence;

/*Given a sequence, find the length of the longest palindromic subsequence in it. For example, 
if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
“BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.

Input String = "GEEKSFORGEEKS"
Output: Length of Longest Palindromic Subsequence = 7
*/

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String input = "GEEKSFORGEEKS";
        System.out.println("The length of LPS is "+ findLongestPalindromicSubsequenceLength(input));
	}
	
	public static int findLongestPalindromicSubsequenceLength(String input){
		int length = input.length();
		int LPS[][] = new int[length][length];
		
		// Strings of length 1 are palindrome of lentgh 1
		for (int i = 0; i < length; i++)
           LPS[i][i] = 1;
		
		int k = 0;
		
		for(int i=2; i<=input.length(); i++){
			
			for(int j=0; j<input.length()-i+1; j++ ){
				 k = i+j-1;
				
				if((j+1 == k) && (input.charAt(j) == input.charAt(k)) )
					LPS[j][k] = 2;
				else if((j+1 == k) && (input.charAt(j) != input.charAt(k)) )
					LPS[j][k] = 1; 
				else if(input.charAt(j) == input.charAt(k))
					LPS[j][k] = LPS[j+1][k-1] + 2;
				else
					LPS[j][k] = Math.max(LPS[j][k-1], LPS[j+1][k]);
			}
		}
		return LPS[0][length-1];
	}
}
