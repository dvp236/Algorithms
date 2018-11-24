package applications.algo;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import graph.algo.UndirectedGraph;

public class BFSConnectedComponent {
	private boolean[] marked;
	private int[] id; //id of connected component containing v
	private int[] size; //size[id] is number of connected components for that id
	private int count; //number of connected components
	
	/**
	 * Computes the connected components of a given undirected graph {@code G} using BreathFirstSearch
	 * 
	 * @param G the undirected graph
	 */
	public BFSConnectedComponent(UndirectedGraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		count = 0;
		for(int v = 0; v < G.V(); v++) {
			if(!marked[v]){
				bfs(G, v);
				count++;
			}
		}
	}
	
	//Breath First Search of graph G with source vertex v 
	private void bfs(UndirectedGraph G, int s) {
		marked[s] = true;
		id[s] = count; 
		size[count]++;
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		while(!q.isEmpty()) {
			int v = q.dequeue();
			for(int w : G.adj(v)) {
					if(!marked[w]) {
					size[count]++;
					marked[w] = true;
					id[w] = count;
					q.enqueue(w);
				}
			}
		}
	}
	
	/**
	 * Returns the number of vertices in connected component containing vertex {@code v}.
	 * 
	 * @param v given vertex
	 * @return the number of vertices in the connected component containing vertex {@code v}
	 * @throws IllegalArgumentException unless given vertex {@code 0 <= v < V }
	 */
	public int size(int v) {
		validateVertex(v);
		return size[id[v]];
	}
	
	/**
	 * Returns the id of connected component containing vertex {@code v}.
	 * 
	 * @param v the vertex
	 * @return the id of connected component containing vertex {@code v}
	 * @throws IllegalArgumentException unless given vertex {@code 0 <= v < V }
	 */
	public int id(int v) {
		validateVertex(v);
		return id[v];
	}
	/**
	 * Returns the number of connected components in the given graph {@code G}.
	 * 
	 * @return the number of connected components in given graph {@code G}
	 */
	public int count() {
		return this.count;
	}
	
	
	
	/**
	 * Returns {@code true} if given vertices {@code v} and {@code u} in same connected component
	 * {@code false} otherwise
	 * @param v the vertex
	 * @param u other vertex
	 * @return {@code true} if given vertices {@code v} and {@code u} are in same connected component,
	 * 			{@code false} otherwise
	 * @throws IllegalArgumentException unless {@code 0 <= v <= V)
	 * @throws IllegalArgumentException unless {@code 0 <= u <= V)
	 *
	 */
	public boolean connected(int v, int u) {
		validateVertex(v);
		validateVertex(u);
		return id[u] == id[v];
	}
	
	//throw illegal argument exception if {@code v} not in range
	private void validateVertex(int v) {
		int V = marked.length;
		if(v < 0 || v >= V) throw new IllegalArgumentException("Vertex should be between 0 and V - 1");
	}
	
	public static void main(String[] args) {
		UndirectedGraph ug = new UndirectedGraph(15);
		ug.addEdge(0, 1);
		ug.addEdge(0, 2);
		ug.addEdge(1, 3);
		ug.addEdge(2, 3);
		ug.addEdge(2, 4);
		ug.addEdge(3, 4);
		
		ug.addEdge(5, 6);
		ug.addEdge(5, 7);
		
		ug.addEdge(8, 9);
		ug.addEdge(9, 14);
		ug.addEdge(8, 13);
		ug.addEdge(14, 10);
		ug.addEdge(11,12);
		ug.addEdge(10, 11);
		
		
		BFSConnectedComponent cc = new BFSConnectedComponent(ug); 
		
		//total connected components
		int m = cc.count();
		System.out.println("total components: "+m);
		System.out.println("number of vertices in connected component containing vertex 3: "+cc.size(3));
		System.out.println("Are connected ? 10 - 13 : "+cc.connected(10, 13));
		
		System.out.println("*===================================================*");
		Queue<Integer>[] components =(Queue<Integer>[]) new Queue[m];
		for(int i = 0; i < m; i++) {
			components[i] = new Queue<Integer>();
		}
		for(int v = 0; v < ug.V(); v++){
			components[cc.id(v)].enqueue(v);
		}
		
		for(int i = 0; i < m; i++) {
			System.out.print("component - "+i+" : " );
			for(int vertex : components[i]) {
				System.out.print(vertex+" ");
			}
			System.out.println();
		}
		
		
	}

}
