package miscellaneous;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Analysis:
 * M union find operation on N objects:
 * quick-find = M
 * quick-union = M.N (Better in somecases)
 * Weighted quick-union = N + MlogN
 * quick-union + Pathcompression = N+MlogN
 * Weighted quick-union + pathcompression = N+Mlg*N
 * 
 *
 */

//The find operation is fast and union is slow.
class QuickFind{
	//Have an array of points.
	//Each point is represented by index and have id as its value
	//whenever union operation is conducted-> make the id of both points same
	//So in that case you will have to make the id of all connected points same.
	int[] points;
	
	public QuickFind(int N){
		this.points = new int[N];
		for(int i=0; i<N; i++){
			points[i] = i;
		}
	}
	
	//complexity O(N)
	public void union(int a, int b){
		int newid = points[b];
		int oldid = points[a];
		//replace all oldid in the points array with newid..
		for(int i=0; i<points.length; i++){
			if(points[i] == oldid){
				points[i] = newid;
			}
		}
	}
	
	public boolean isConnected(int a, int b){
		//if id of both the points same or not
		return points[a] == points[b];
	}
	
}

class QuickUnion{
	//Here we have different kind of organization.
	//Each index is point and the value it holds is its root
	//Initially each value is root of self

	int[] points;
	int[] sz;
		
	public QuickUnion(int N){
		this.points = new int[N];
		for(int i=0; i<N; i++){
			points[i] = i;
			sz[i] = 1;
		}
	}
	
	//complexity O(N)
	public void union(int a, int b){
		//get the root of both points
		//connect the first to second
		int aroot = root(a);
		int broot = root(b);
		points[aroot] = broot;
	}
	
	public void weightedUnion(int a, int b){
		int aroot = root(a);
		int broot = root(b);
		// points[aroot] = broot;
		
		//this makes sure that smaller tree has link to bigger
		//so aroot will point to broot if broot has bigger tree
		//then we will have to increase size of broot by sz[aroot] (since whole tree is under broot now)
		if(sz[aroot] < sz[broot]){
			points[aroot] = broot;
			sz[b] += sz[a];
		}else{
			points[broot] = aroot;
			sz[aroot] += sz[broot];
		}
		
	}
	
	private int root(int a){
		while(a != points[a]) a = points[a];
		return a;
	}
	
	//this halves path length... by compressing path everytime this method is used.
	private int rootWithPathCompression(int a){
		while(a != points[a]){
			points[a] = points[points[a]];
			a = points[a];
		}
		
		return a;
		
	}
	
	//Complexity O(N)
	public boolean isConnected(int a, int b){
		//if id of both the points same or not
		return root(a) == root(b);
	}
	
	//using weightedunion with pathcomression can give efficient perfomance.
	
}

public class UnionFind {

	public static void main(String[] args) {
		QuickFind qf = new QuickFind(7);
		qf.union(2, 3);
		qf.union(3, 1);
		qf.union(1, 5);
		//qf.union(4, 1);
		qf.union(6, 4);
//		System.out.println(qf.isConnected(0, 6));
//		System.out.println(Arrays.toString(qf.points));
		
		QuickUnion qu = new QuickUnion(10);
		qu.union(2, 9);
		qu.union(3, 4);
		qu.union(4, 9);
		qu.union(5, 6);
		qu.union(9, 6);
		qu.union(2, 8);
		qu.union(3, 8);
		
		System.out.println(Arrays.toString(qu.points));
		System.out.println(qu.isConnected(5, 8));
		
	}

}
