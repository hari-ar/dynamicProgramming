package com.dynamicprogramming.longest_repeated_subsequence;

/*
Given a string, print the longest repeating subseequence such that the two subsequence don’t have same string 
character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index 
in the original string.

Examples:

Input: str = "aabb"
Output: "ab"

Input: str = "aab"
Output: "a"
The two subssequence are 'a'(first) and 'a' 
(second). Note that 'b' cannot be considered 
as part of subsequence as it would be at same
index in both.

Notes
===========
This problem is just the modification of Longest Common Subsequence problem. The idea is to find the LCS(str, str) where 
str is the input string with the restriction that when both the characters are same, they shouldn’t be on the same index 
in the two strings
*/



public class LongestRepeatedSubsequence {

	public static void main(String[] args) {
		String str = "AABEBCDD";
		int[][] result = findLengthOfLongestRepeatedSubSequence(str);
		System.out.println("Length of longest repeated subsequence: "+result[str.length()][str.length()]);
		//now printing subsequence
		int i = str.length();
		int j = str.length();
		StringBuffer subsequence = new StringBuffer();
		while(i>0 && j>0){
			if(result[i][j] == result[i-1][j-1]+1){
				subsequence.append(str.charAt(i-1));
				i--; j--;
			}else if(result[i][j] == result[i-1][j]){
				i--;
			}else{
				j--;
			}
		}
		//Since we traverse dp[][] from bottom we get result in reverse order
		System.out.println("Longest repeated subsequence is: "+subsequence.reverse().toString());
		
	}
	
	public static int[][] findLengthOfLongestRepeatedSubSequence(String str){
		int length = str.length();
		char[] arr = str.toCharArray();
		int[][] DP = new int[length+1][length+1];
		
		//initialiaze DP table
		for(int i=0; i<=length; i++){
			for(int j=0; j<=length; j++){
				DP[i][j] = 0;
			}
		}
		
		for(int i=1; i<=length; i++){
			for(int j=1; j<=length; j++){
				if((arr[i-1] == arr[j-1]) && (i != j))
					DP[i][j] = DP[i-1][j-1] + 1;
				else
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
			}
		}
		return DP;
	}
}
