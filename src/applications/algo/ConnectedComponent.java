package applications.algo;

import graph.algo.Graph;

//implement cc
public class ConnectedComponent {
	
	private boolean[] markTo;
	private int[] id;
	private int[] size;
	private int count;
	
	public ConnectedComponent(Graph G){
		markTo = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		count = 0;
		for (int u = 0; u < G.V(); u++) {
			if (!markTo[u]) {
				dfs(G,u);
				count++;
			}
		}
	}
	
	public void dfs(Graph G, int v) {
		markTo[v] = true;
		id[v] = count;
		size[count]++;
		
		for (int w : G.adj(v)) {
			if (!markTo[w]) {
				dfs(G,w);
			}	
		}
	}
	
	
	public boolean connected(int u, int w) {
		validateVertex(u);
		validateVertex(w);
		return id[u] == id[w];
	}
	
	public int id(int u) {
		validateVertex(u);
		return id[u];
	}
	
	public int size(int u) {
		validateVertex(u);
		return size[id[u]];
	}
	
	// throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = markTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	

}
