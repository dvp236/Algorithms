package graph.algo;

import edu.princeton.cs.algs4.Bag;

public class Digraph {
	private final int V;
	private int E;
	private int[] indegree;
	private Bag<Integer>[] adj;
	
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		indegree = new int[V];
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
		adj[v].add(u);
		indegree[u]++;
		E++;
	}
	
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
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
		
		

	}

}
