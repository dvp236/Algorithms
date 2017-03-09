package miscellaneous;

/**
 * 
 * @author dharmik
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


public class UnionFind {

	public static void main(String[] args) {
		QuickFind qf = new QuickFind(7);
		qf.union(2, 3);
		qf.union(3, 1);
		qf.union(1, 5);
		//qf.union(4, 1);
		qf.union(6, 4);
		System.out.println(qf.isConnected(0, 6));
	}

}
