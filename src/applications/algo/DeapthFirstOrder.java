package applications.algo;

import edu.princeton.cs.algs4.Stack;
import graph.algo.Digraph;

public class DeapthFirstOrder {

	private boolean[] marked;
	private Stack<Integer> reversePost;
	
	public DeapthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		reversePost = new Stack<>();
		for (int i = 0; i < G.V(); i++) {
			if (!marked[i])
				dfs(G, i);
		}
	}
	
	private void dfs(Digraph G,int u) {
		marked[u] = true;
		for (int w: G.adj(u)) {
			if (!marked[w]) {
				dfs(G,w);
			}
		}
		reversePost.push(u);
	}
	
	public Iterable<Integer> reversePost() {
		return reversePost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
