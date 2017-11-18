/*Given a sequence of elements, a subsequence of it can be obtained by removing zero or more elements from the sequence, preserving the relative order of the elements. 
Note that for a substring, the elements need to be contiguous in a given string, for a subsequence it need not be. Eg: S1="ABCDEFG" is the given string. "ACEG", "CDF" 
are subsequences, where as "AEC" is not. For a string of length n the total number of subsequences is 2n ( Each character can be taken or not taken ). Now the question 
is, what is the length of the longest subsequence that is common to the given two Strings S1 and S2. Lets denote length of S1 by N and length of S2 by M.*/



package com.dynamicprogramming.LongestCommonSubsequence;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		
		//testing for sequences  “ABCDGH” and “AEDFHR”
		char[] s1 = "ABCDGH".toCharArray();
		char[] s2 = "AEDFHR".toCharArray();
		int output = LongestCommonSubsequence.longestCommonSubsequence(s1, s2);
		System.out.println(output);
		
		//testing for sequences  “AGGTAB” and “GXTXAYB”
		s1 = "AGGTAB".toCharArray();
		s2 = "GXTXAYB".toCharArray();
		output = LongestCommonSubsequence.longestCommonSubsequence(s1, s2);
		System.out.println(output);
	}
	
	public static int longestCommonSubsequence(char[] s1, char[] s2){
		
		int[][] LCS = new int[s1.length+1][s2.length+1]; 
		
		for(int i=0; i<=s1.length; i++){
			LCS[i][0] = 0;
		}
		
		for(int j=0; j<=s1.length; j++){
			LCS[0][j] = 0;
		}
		
		for(int i=1; i<=s1.length; i++){
			for(int j=1; j<=s2.length; j++){
				if(s1[i-1] == s2[j-1])
					LCS[i][j] = LCS[i-1][j-1] + 1;
				else
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		return LCS[s1.length][s2.length];
	}
}
