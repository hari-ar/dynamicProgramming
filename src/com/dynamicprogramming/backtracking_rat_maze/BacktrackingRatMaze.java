package com.dynamicprogramming.backtracking_rat_maze;

public class BacktrackingRatMaze {

	public static void main(String[] args) {
		int maze[][] = {{1, 0, 0, 0},
			            {1, 1, 0, 1},
			            {0, 1, 0, 0},
			            {1, 1, 1, 1}
			           };

		solveMaze(maze);
	}
	
	public static void solveMaze(int[][] maze){
		
		int n = maze[0].length;
		int[][] solution = new int[n][n];
		
		solveMazeUtil(maze, 0, 0, solution);
		
		print(solution);
		
	}
	
	public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution){
		int n = maze[0].length;
		if((x==n-1) && (y==n-1)){
			solution[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x, y)){
			solution[x][y] = 1;
			if(solveMazeUtil(maze, x+1, y, solution))
				return true;
			if(solveMazeUtil(maze, x, y+1, solution))
				return true;
			
			solution[x][y] = 0;
			return false;
		}
		return false;
	}
	
	public static boolean isSafe(int[][] maze, int x, int y){
		int n = maze[0].length;
		return (x>=0 && x<n) && (y>=0 && y<n) && (maze[x][y] == 1);
	}
	
	public static void print(int[][] solution){
		int n = solution[0].length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(solution[i][j]+" ");
			}
			System.out.println();
		}
	}
}
