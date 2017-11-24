package com.dynamicprogramming.number_of_islands;

public class NumberOfIslands {

	public static void main(String[] args) {
		int M[][]=  new int[][] {	{1, 1, 0, 0, 0},
						            {0, 1, 0, 0, 1},
						            {1, 0, 0, 1, 1},
						            {0, 0, 0, 0, 0},
						            {1, 0, 1, 0, 1}
						           };
			NumberOfIslands I = new NumberOfIslands();		           
           	System.out.println("Number of islands is: "+ I.countIslands(M));
	}
	
	public int countIslands(int[][] M){
		int ROW = 0, COL = 0;
		ROW = M[0].length;
		COL = M[0].length;
		boolean[][] visited = new boolean[ROW][COL];
		
		int count = 0;
		
		for(int i=0; i<ROW; i++){
			for(int j=0; j< COL; j++){
				if((M[i][j] == 1) && (!visited[i][j])){
					DFS(M, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}
	
	public void DFS(int[][] M, int row, int col, boolean[][] visited){
		visited[row][col] = true;
		// These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        for(int i=0; i<8; i++){
        	if(isSafe(M, row+rowNbr[i], col+colNbr[i], visited));
        	DFS(M, row+rowNbr[i], col+colNbr[i], visited);
        }
	}
	
	public boolean isSafe(int[][] M, int row, int col, boolean[][] visited){
		int ROW = M[0].length;
		int COL = M[0].length;
		return row >=0 && row < ROW && col >=0 && col<COL && (M[row][col] == 1) && (!visited[row][col]);
	}
}
