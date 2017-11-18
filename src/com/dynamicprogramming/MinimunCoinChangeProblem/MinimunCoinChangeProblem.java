package com.dynamicprogramming.MinimunCoinChangeProblem;


/*A Dynamic Programming to find minimum of coins
to make a given change V*/
public class MinimunCoinChangeProblem {

	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int amount = 9;
		System.out.println(MinimunCoinChangeProblem.minimumCoinChange(coins, amount));
	}
	
	public static int minimumCoinChange(int[] coins, int amount){
		int[] MCP = new int[amount+1];
		//initializing MCP array
		for(int i=0; i<MCP.length;i++){
			MCP[i] = Integer.MAX_VALUE;
		}
		MCP[0] = 0;
		
		for(int j=1; j<=amount;j++){
			for(int k=0; k<coins.length; k++){
				if(j >= coins[k]){
					MCP[j] = Math.min(MCP[j-coins[k]]+1, MCP[j]);
				}
			}
		}
		
		return MCP[amount];
	}
}


