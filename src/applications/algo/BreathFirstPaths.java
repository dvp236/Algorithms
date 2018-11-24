package applications.algo;



import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import graph.algo.UndirectedGraph;

/**
 * 
 * @author dharmik
 *
 */
public class BreathFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private final int s;
	
	/**
	 * Takes in Graph {@code G} and source vertex {@code s} and traverse through graph in Breath
	 * First search manner.
	 * @param G the graph
	 * @param s the source vertex
	 */
	public BreathFirstPaths(UndirectedGraph G, int s) {
		this.s = s;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for ( int v = 0; v < G.V(); v++) {
			distTo[v] = Integer.MIN_VALUE;
		}
		bfs(G,s);
		
	}

	private void bfs(UndirectedGraph G, int s) {
		marked[s] = true;
		distTo[s] = 0;
		edgeTo[s] = s;
		Queue<Integer> q = new Queue<>();
		q.enqueue(s);
		
		while(!q.isEmpty()) {
			int w = q.dequeue();
			for( Integer u : G.adj(w)) {
				if(!marked[u]) {
					q.enqueue(u);
					marked[u] = true;
					edgeTo[u] = w;
					distTo[u] = distTo[w] + 1;
				}
			}
		}
	}
	
	/**
	 * Takes in vertex {@code v} and returns its distance from source vertex {@code s}
	 * @param v the vertex
	 * @return the shortest distance from source vertex {@code s} to vertex {@code v}
	 * @throws IllegalArgumentException if vertex not in {@code 0 <= v < V}
	 */
	public int distTo(int v) {
		validateVertex(v);
		return distTo[v];
	}
	
	/**
	 * Takes in vertex {@code v} and return {@code true} if there is path from source {@code s} to 
	 * vertex {@code v}
	 * @param v the vertex
	 * @return {@code true} if there is a path, {@code false} otherwise.
	 * @throws IllegalArgumentException if vertex not in {@code 0 <= v < V}
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
		if (!hasPathTo(v)) return null;
		
		Stack<Integer> path = new Stack<>();
		int w = v;
		while (w != s) {
			path.push(w);
			w = edgeTo[w];
		}
		path.push(s);
		return path;
	}
	
	//validate vertex v
	private void validateVertex(int v) {
		int V = marked.length;
		if( v < 0 || v > (V - 1 ) ) throw new IllegalArgumentException("Vertex should be between 0 and "+V);
	}
	
	/**
	 * for unit testing
	 * @param args
	 */
	public static void main(String[] args) {
		UndirectedGraph G = new UndirectedGraph(8);
		G.addEdge(0, 5);
		G.addEdge(2, 4);
		G.addEdge(2, 3);
		G.addEdge(1, 2);
		G.addEdge(0, 1);
		G.addEdge(3, 4);
		G.addEdge(3, 5);
		G.addEdge(0, 2);
		G.addEdge(6, 7);
		int s = 0;
		BreathFirstPaths bfs = new BreathFirstPaths(G, 0);
		for (int v = 0; v < G.V(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }

		
	}
	
		
	
}
