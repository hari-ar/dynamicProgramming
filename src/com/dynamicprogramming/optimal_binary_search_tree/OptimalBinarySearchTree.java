package com.dynamicprogramming.optimal_binary_search_tree;

/*Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, 
where freq[i] is the number of searches to keys[i]. Construct a binary search tree of all keys such that 
the total cost of all the searches is as small as possible.

Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.

Example 1
Input:  keys[] = {10, 12}, freq[] = {34, 50}
There can be following two possible BSTs 
        10                       12
          \                     / 
           12                 10
          I                     II
Frequency of searches of 10 and 12 are 34 and 50 respectively.
The cost of tree I is 34*1 + 50*2 = 134
The cost of tree II is 50*1 + 34*2 = 118 

Example 2
Input:  keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
There can be following possible BSTs
    10                12                 20         10              20
      \             /    \              /             \            /
      12          10     20           12               20         10  
        \                            /                 /           \
         20                        10                12             12  
     I               II             III             IV             V
Among all possible BSTs, cost of the fifth BST is minimum.  
Cost of the fifth BST is 1*50 + 2*34 + 3*8 = 142
*/

public class OptimalBinarySearchTree {

	
	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " + optimalSearchTree(keys, freq, n));
	}
	
	public static int optimalSearchTree(int[] keys, int[] freq, int n){
		int[][] OBST = new int[n+1][n+1];
		
		// For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++)
        	OBST[i][i] = freq[i];
        
        int k = 0;
        //this loop will run for starting length from 2 to n; Example 2-elements, 3-elements, 4-elements etc.
        for(int i=2; i<= n; i++){
        	//this loop will run till index it will find the elements of i length; Example 1,2,3,4,5,6 length=3 then i.e loop will run till element 4
        	for(int j=0; j<n-i+1; j++){
        		//end index
        		k= i+j-1;
        		OBST[j][k] = Integer.MAX_VALUE;
        		// Try making all keys in interval keys[i..j] as root
        		for(int r=j; r<=k; r++){
        			int cost = ((r>j)?OBST[j][r-1]:0) + ((r<k)?OBST[r+1][k]:0) + sum(freq, j, k); 
        			if(OBST[j][k] > cost)
        				OBST[j][k] = cost;
        		}
        	}
        }
        return OBST[0][n-1];
		
	}
	
	public static int sum(int[] freq, int j, int k){
		int sum = 0;
		for(int i=j; i<=k; i++){
			if(i>freq.length)
				continue;
			sum = sum + freq[i];
		}
		return sum;
	}
	
	
}
