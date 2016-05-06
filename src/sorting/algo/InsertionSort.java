package sorting.algo;

import java.util.Arrays;
/**
 * 
 * @author dharmik
 * Implement Insertion sort algorithm for sorting an array.
 * 
 */
public class InsertionSort {
	
	//Insertion sort is inplace algorithm which
	//takes O(n^2) complexity to sort an array of length n.
	
	public static int[] sort(int[] a){
		int i,j,val;
		
		for(i=1;i<a.length;i++){
			j=i;
			val = a[i];
			//for val, find the right place 
			while(j>0 && a[j-1]>val){
				//put each element higher than val to right side val
				a[j] = a[j-1];
				j--;
			}
			//set the value to its right place
			a[j] = val;
		}
		
		return a;
	}
	public static void main(String[] args) {
        int arrayList[] = { 5,3,9,7,1,8,2,4 };
        System.out.println("\nFinal result:"+Arrays.toString(sort(arrayList)));

	}
	
}
