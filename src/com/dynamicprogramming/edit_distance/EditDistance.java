package com.dynamicprogramming.edit_distance;

/*Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a
*/

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
	}
	
	public static int  editDistDP(String str1 , String str2 , int m, int n){
		//if str1 is empty then we need to insert all the characters of str2
		if(str1 == null || str1.isEmpty())
			return n;
		//if str2 is empty then we need to remove all the characters of str1
		if(str2 == null || str2.isEmpty())
			return m;
		
		int[][] DP = new int[m+1][n+1];
		
		for(int i=0; i<=m ;i++){
			for(int j=0; j<=n; j++){
				if(i==0)
					DP[i][j] = j;
				else if(j==0)
					DP[i][j] = i;
				else{
					if(str1.charAt(i-1) == str2.charAt(j-1))
						DP[i][j] = DP[i-1][j-1];
					else
						DP[i][j] = 1 + findMin(DP[i-1][j], DP[i][j-1], DP[i-1][j-1]);
				}
			}
		}
		return DP[m][n];
	}
	
	public static int findMin(final int a, final int b, final int c){
		return (a>b)?(b>c?c:b):(a>c?c:a);
	}
}
