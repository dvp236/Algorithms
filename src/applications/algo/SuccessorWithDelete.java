package applications.algo;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * **Union-find with specific canonical element. Add a method find() to the union-find data type 
 * so that find(i) returns the largest element in the connected component containing i. 
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 
 * for each of the four elements in the connected components.
 * 
 * 
 *
 */

//This implements Weighted QU with FindLargest
class WQUWithFindLargest{
	int[] points;
	int[] sz;
	int[] large;
	
	public WQUWithFindLargest(int N){
		points = new int[N];
		sz = new int[N];
		large = new int[N];
		for(int i=0; i<N; i++){
			points[i] = i;
			sz[i] = 1;
			large[i] = i;
		}
	}
	
	//Complexity:  log(N)
	private int root(int a){
		while(a != points[a]){
			points[a] = points[points[a]]; // path compression
			a = points[a];
		}
		return a;
	}
	
	//Complexity: log(N)
	public void union(int a, int b){
		int aroot = root(a);
		int broot = root(b);
		int largestOfa = large[aroot];
		int largestOfb = large[broot];
		if(sz[aroot] <= sz[broot]){
			points[aroot] = broot;
			if(largestOfa > largestOfb) large[broot] = largestOfa;
		}else{
			points[broot] = aroot;
			if(largestOfb > largestOfa) large[aroot] = largestOfb;
		}
	}
	
	//find largest node in connected component of a 
	//Complexity: log(N)
	public int find(int a){
		return large[root(a)];
	}
	
	//Complexity: log(N)
	public boolean connected(int a, int b){
		return root(a) == root(b);
	}
	
	
}

class SuccessorFinder{

	boolean[] isRemoved;
	WQUWithFindLargest wqu;
	int N;
	public SuccessorFinder(int N){
		//initially all values false
		this.N = N;
		isRemoved = new boolean[N];
		wqu = new WQUWithFindLargest(N);
	}
	
	public void remove(int a){
		if(isRemoved[a]) return;
		isRemoved[a] = true;
		//if lesser value is removed union them together
		if(a > 0 && isRemoved[a-1]) wqu.union(a, a-1);
		
		//if greater value is removed union them together
		if(a < N-1 && isRemoved[a+1]) wqu.union(a, a+1);
			
	}
	
	public int successor(int a){
		if(a >= N){
			return -1;
		}
		
		if(isRemoved[a]){
			//0 1 2 3 4 5 6
			//T F F F T F T
			//here we find the largest of removed values, and adding 1 more gives bigger non removed. thats successor
			int successor = wqu.find(a) + 1;
			return successor;
		}
		return a;
	}
	
	
}

public class SuccessorWithDelete {

	public static void main(String[] args) {
		
//		WQUWithFindLargest qu = new WQUWithFindLargest(12);
//		qu.union(0, 4);
//		qu.union(2, 3);
//		qu.union(1, 4);
//		qu.union(2, 4);
//		
//		qu.union(7, 5);
//		qu.union(5, 11);
//		qu.union(7, 10);
//		qu.union(6, 10);
//		
//		
//		
//		System.out.println(qu.find(2));
//		System.out.println(qu.find(1));
//		System.out.println(qu.find(0));
//		System.out.println(qu.find(4));
//		System.out.println("----");
//		
//		System.out.println(qu.find(5));
//		System.out.println(qu.find(6));
//		System.out.println(qu.find(11));
//		System.out.println(qu.find(10));
//		System.out.println(qu.find(7));
//		
//		System.out.println(qu.connected(0,3));
//		System.out.println(qu.connected(6,5));
//		System.out.println(qu.connected(6,4));
	
		
		SuccessorFinder s = new SuccessorFinder(7);
		//System.out.println(s.successor(5));
		
		s.remove(2);
		s.remove(3);
		s.remove(1);
		s.remove(5);
		System.out.println(s.successor(2));

	}

}
