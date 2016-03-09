package search.algo;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a ={1,2,3,4,5,6,7,8};
		System.out.println(getIndex(9,a));
		
	}
	
	private static int getIndex(int key, int[] a){
		int len = a.length;
		
		int lo = a[0], hi=a[len-1];
		while(lo<=hi){
			int mid = lo + (hi - lo)/2;
			if(a[mid]<key){
				lo=mid+1;
			}
			else if(a[mid]>key){
				hi=mid-1;
			}
			else{
				return mid;
			}
		}
		return -1;
	}

}
