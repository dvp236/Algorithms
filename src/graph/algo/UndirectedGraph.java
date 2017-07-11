package graph.algo;

import edu.princeton.cs.algs4.Bag;

public class UndirectedGraph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public UndirectedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}
	
	public int V() {
		return this.V;
	}
	
	public int E() {
		return this.E;
	}
	
	public void addEdge(int v, int u) {
		validateVertex(v);
		validateVertex(u);
		if(v == u) return;
		adj[v].add(u);
		adj[u].add(v);
		E++;
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public void validateVertex(int v) {
		if (v < 0 || v >= V) throw new IllegalArgumentException("Vertex should be between 0 and "+(V-1));
	}

	public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
	
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(V+" vertexs and, "+E+" edges \n");
		for(int v = 0; v < V; v++) {
			sb.append(v+" : ");
			for( Integer e : adj[v]) 
				sb.append(e+" "); 
			sb.append("\n");
		}
		
		return sb.toString();
		
	}
	public static void main(String[] args) {
		
		UndirectedGraph ug = new UndirectedGraph(10);
		ug.addEdge(1, 2);
		ug.addEdge(2, 5);
		ug.addEdge(2, 4);
		ug.addEdge(8, 2);
		ug.addEdge(3, 6);
		ug.addEdge(6, 6);
		ug.addEdge(6, 5);
		System.out.println(ug.toString());
		
		System.out.println("degree 2 -"+ug.degree(2));
		System.out.println("degree 6 -"+ug.degree(6));

	}

}
