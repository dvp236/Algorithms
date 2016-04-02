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
		int pos = partition(a, lo, hi);
		sort(a, lo, pos-1);
		sort(a, pos+1, hi);
	}
	
	private static int partition(int[] a, int lo, int hi){
		int i = lo+1;
		int j = hi;
		int v = a[lo];
		
		while(true){
			//find item on lo to swap
			
			while(a[i] < v){
				if( i == hi )
					break;
				i++;
			}
			
			while(a[j] > v){
				if(j == lo)
					break;
				j--;
			}
			
			if(i >= j)
				break;
			
			int swap = a[i];
			a[i] = a[j];
			a[j] = swap;
		}
		
		int swap = a[lo];
		a[lo] = a[j];
		a[j] = swap;
		return j;
	}
	
	public static void main(String[] args){
		System.out.println("quicksort");
		int[] a = new int[] {4,9,8,7,3,5,2,6,1};
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
