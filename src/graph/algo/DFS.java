package graph.algo;
/**
 * 
 * @author dharmik
 *
 */

public class DFS {
	private boolean[] marked;
	private int count;
	
	/**
	 * Takes in Graph {@code G} and source vertex {@code s} and traverses 
	 * all vertices in deapth first search manner.
	 * @param G the graph
	 * @param s the source vertex
	 * @throws IllegalArgumentException if vertex not in {@code 0 <= v < V}
	 */
	public DFS(UndirectedGraph G, int s) {
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	//dfs of graph G with source v
	private void dfs(UndirectedGraph G, int v) {
		marked[v] = true;
		count++;
		for(int u: G.adj(v)) {
			if(!marked[u])
				dfs(G,u);
		}
	}

	/**
	 * Returns true if the vertex {@code v} is connected to source vertex {@code s}, false otherwise.
	 * 
	 * @param v the vertex
	 * @return true if the vertex {@code v} is connected to source vertex {@code s}, false otherwise.
	 * @throws IllegalArgumentException if the vertex not in {@code 0 <= v < V}
	 */
	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	/**
	 * Returns the total vertices in connected to source vertex {@code s}.
	 * 
	 * @return number of vertices in connected to source vertex {@code s}
	 */
	public int count() {
		return count;
	}
	
	//validate vertex
	private void validateVertex(int v) {
		int V = marked.length;
		if ( v < 0 || v >= V) throw new IllegalArgumentException("Vertex must be between 0 and "+V);
	}
	
	public static void main(String[] args) {
		
	}

}
