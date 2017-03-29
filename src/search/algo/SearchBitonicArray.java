package search.algo;
/**
 * 
 * @author dharmik
 * 
 *
 */

/*
 * 
Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array.

Standard version: Use ∼3lgn compares in the worst case.
Signing bonus: Use ∼2lgn compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ∼2lgn compares in the worst case).
 */
public class SearchBitonicArray {
	// a 3lg n approach involves finding a mid element where the switch takes place.
	// that is find where a[mid] > a[mid+1] 
	// then apply increasing binary search on 0 to mid and decreasing binary search for mid+1 to hi
	
	
	//here we will implement 2lgn approach.
	public static boolean binarySearch_incr(int key, int[] a, int lo, int hi) {
		System.out.println("ping");
		while( lo <= hi) {
			int mid = ( lo + hi )/2;
			
			if( a[mid] == key ) return true;
			else if (a[mid] < key ) lo = mid + 1;
			else hi = mid - 1 ;
		}
	
		return false;
	}
	
	public static boolean binarySearch_decr(int key, int[] a, int lo, int hi) {
		System.out.println("ping d");
		while( lo <= hi) {
			int mid = ( lo + hi ) / 2;
			
			if( a[mid] == key ) return true;
			else if( a[mid] > key ) lo = mid + 1;
			else hi = mid - 1 ;
		}
	
		return false;
	}
	
	public static boolean searchBitonic(int key, int[] a, int lo, int hi) {
		while( lo <= hi ) {
			int mid = (lo + hi) / 2;
			
			if( a[mid] == key ) return true;
			
			else if( a[mid] > a[mid-1] ){
				//sure - asc sequence
				if( key < a[mid] && key > a[lo]){
					boolean found = binarySearch_incr(key,a,lo,mid-1);
					if( found ) return true;
				}
				lo = mid + 1;
						
			}
			
			else if( a[mid] < a[mid-1] ) {
				//sure - dsc seq
				if( key < a[mid] && key > a[hi]){
					boolean found = binarySearch_decr(key,a,mid+1,hi);
					if( found ) return true;
				}
				hi = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		int a[] = new int[]{1,2,3,4,5,6,7};
		int b[] = new int[]{7,6,5,4,3,2,1};
		int c[] = new int[]{1,3,5,8,12,16,17,18,9,2,0};
		System.out.println(searchBitonic(2, c, 0, c.length-1));
	}

}
