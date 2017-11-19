package com.dynamicprogramming.all_pair_shortest_path;

/*The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.

Example:

Input:
       graph[][] = { {0,   5,  INF, 10},
                    {INF,  0,  3,  INF},
                    {INF, INF, 0,   1},
                    {INF, INF, INF, 0} }
which represents the following graph
             10
       (0)------->(3)
        |         /|\
      5 |          |
        |          | 1
       \|/         |
       (1)------->(2)
            3       
Note that the distalue of graph[i][j] is 0 if i is equal to j 
And graph[i][j] is INF (infinite) if there is no edge from distertex i to j.

Output:
Shortest distance matrix
      0      5      8      9
    INF      0      3      4
    INF    INF      0      1
    INF    INF    INF      0
*/

public class AllPairShortestPath {
	
	static final int INF = 99999;

	public static void main(String[] args) {
		/* Let us create the following weighted graph
        10
     (0)------->(3)
     |         /|\
     5 |          |
     |          | 1
     \|/         |
     (1)------->(2)
        3           */
     int graph[][] = { {0,   5,  INF, 10},
                       {INF, 0,   3, INF},
                       {INF, INF, 0,   1},
                       {INF, INF, INF, 0}
                     };

     int n = 4;
     
     // Print the solution
     floydWarshall(graph, n);
	}
	
	public static void floydWarshall(int[][] graph, int n){
		
		int[][] dist = new int[n][n];
		
		// Initialize the solution matrix same as input graph matrix.
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				dist[i][j] = graph[i][j];
			}
		}
		
		// Pick all vertices as intermediate vertex one by one
		for(int k=0; k<n; k++){
			// Pick all vertices as source one by one
			for(int i=0; i<n; i++){
				// Pick all vertices as destination for the above picked source
				for(int j=0; j<n;j++){
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
				}
			}
		}
		
		//printing solution
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
