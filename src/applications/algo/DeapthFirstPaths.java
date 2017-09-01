package applications.algo;



import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import graph.algo.UndirectedGraph;

/**
 * 
 * @author dharmik
 *
 */
public class DeapthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo; //edge to previous vertex;
	private final int s;
	
	/**
	 * Takes in Undirected Graph {@code G} and source vertex {@code s} and 
	 * traverses in Depth first search manner
	 * @param G the graph 
	 * @param s the source vertex
	 * @throws IllegalArgumentException if vertex not in {@code 0 <= v < V}
	 */
	public DeapthFirstPaths(UndirectedGraph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		edgeTo[s] = s;
		dfs(G,s);
	}
	
	private void dfs(UndirectedGraph G, int v) {
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}
	
	/**
	 * This method takes in vertex {@code v} and returns if there is path from source {@code s} 
	 * to vertex {@code v}
	 * @param v the vertex
	 * @return {@code true} if  there is a path, {@code false} otherwise.
	 * @throws IllegalArgumentException if vertex {@code v} not in {@code 0 <= v < V}
	 */
	public boolean hasPathTo(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	/**
	 * Takes in vertex {@code v} and Returns the full path from source {@code s} to vertex {@code v}
	 * @param v the vertex
	 * @return the sequence of vertices on the path as an Iterable
	 * @throws IllegalArgumentException if vertex not in {@code 0 <= v < V}
	 */
	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		int w = v;
		while(w != s) {
			path.push(w);
			w = edgeTo[w];
		}
		path.push(s);
		return path;
	}
	
	//check if v is valid argument 
	private void validateVertex(int v) {
		int V = marked.length;
		if ( v < 0 || v > V - 1 ) throw new IllegalArgumentException("Vertex should be between 0 and "+V);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraph G = new UndirectedGraph(6);
		G.addEdge(0, 5);
		G.addEdge(2, 4);
		G.addEdge(2, 3);
		G.addEdge(1, 2);
		G.addEdge(0, 1);
		G.addEdge(3, 4);
		G.addEdge(3, 5);
		G.addEdge(0, 2);
		int s = 0;
		DeapthFirstPaths dfs = new DeapthFirstPaths(G, 0);
		for(int v=0; v < G.V(); v++){
			if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print( "-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }		
		}

	}

}
