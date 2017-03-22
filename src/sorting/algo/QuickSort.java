package sorting.algo;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implement QuickSort
 */
public class QuickSort {
	
	private static void sort(int[] a, int lo, int hi){
		if( hi <= lo) return;
		int pos = partition2(a, lo, hi);
		sort(a, lo, pos-1);
		sort(a, pos+1, hi);
	}
	
	private static int partition(int[] a, int lo, int hi){
		int i = lo+1;
		int j = hi;
		int pivot = a[lo];
		
		while(true){
			//find item on lo to swap
			
			while(a[i] < pivot){
				if( i == hi )
					break;
				i++;
			}
			
			while(a[j] > pivot){
				if(j == lo)
					break;
				j--;
			}
			
			if(i >= j)
				break;
			
			//swap values that are greater and lesser than pivot
			int swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}
		
		//moving pivot to its place.
		int swap = a[lo];
		a[lo] = a[j];
		a[j] = swap;
		return j;
	}
	
	//Just another implementation of Partition Subroutine
	//Time Complexity: O(n)
	private static int partition2(int[] a, int lo, int hi){
		int pivot = a[lo];
		int i = lo + 1;
		int j = lo + 1;
		//here i and j points to next to pivot initially
		// we will keep incrementing j every time. 
		//if item at j is less than pivot, we exchange it with i 
		//and increment i 
		//So i always stays at start of partition where values are higher than pivot
		
		//for Ex:
		//3 2 8 5 1 4 7 6
		//    i   j
		//3 2 1 5 8 4 7 6
		//      i j 
		while(j <= hi){
			if(a[j] < pivot){
				swap(a,i,j);
				i++;
			}
			j++;
		}
		//set pivot to its rightful position
		swap(a,lo,i-1);
		
		//return position of pivot
		return i-1;
	}
	
	//implementation of helper method for swapping
	private static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args){
		System.out.println("quicksort");
		int[] a = new int[] {4,9,8,7,3,5,2,6,1,1};
		//int[] a = new int[] {3,8,2,4,7,6,1,5};
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
