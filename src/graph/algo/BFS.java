package graph.algo;

import edu.princeton.cs.algs4.Queue;

/**
 * 
 * @author dharmik
 * Implement BFS for Undirected Graph.
 * 
 *
 */

public class BFS {
	private boolean[] markTo;
	private int[] distTo;
	
	public BFS(UndirectedGraph G, int s) {
		markTo = new boolean[G.V()];
		distTo = new int[G.V()];
		bfs(G, s);
	}
	
	public void bfs(UndirectedGraph G, int s) {
		Queue<Integer> q = new Queue<Integer>();
		markTo[s] = true;
		for( int v = 0; v < G.V(); v++) {
			distTo[v] = Integer.MAX_VALUE;
		}
		distTo[s] = 0;
		q.enqueue(s);
		
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for (Integer w: G.adj(v)) {
				if(!markTo[w]) {
					q.enqueue(w);
					markTo[w] = true;
					distTo[w] = distTo[v] + 1;
				}
			}
		}
	}
	
	
	public int distTo(int v) {
		return distTo[v];
	}

	
	public static void main(String[] args) {
		UndirectedGraph ug = new UndirectedGraph(5);
		ug.addEdge(0, 1);
		ug.addEdge(0, 2);
		ug.addEdge(1, 3);
		ug.addEdge(2, 3);
		ug.addEdge(2, 4);
		ug.addEdge(3, 4);
		
		int source = 0;
		BFS b = new BFS(ug, source);
		
		for(int v = 0; v < ug.V() ; v++) {
			System.out.println("0 - "+v+" : "+b.distTo(v));
		}

	}

}
