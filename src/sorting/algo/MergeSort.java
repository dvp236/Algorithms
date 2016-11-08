package sorting.algo;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implementation of MergeSort
 *
 */
public class MergeSort {
	
	/*
	 * @param -array to be sorted
	 * @param -Helper array of same size
	 * @param -Starting index
	 * @param -last index
	 */
	public static void sort(int[] a, int[] aux, int start, int end){
		//Condition to end recursion 
		if (end <= start){
			return;
		}
		
		//find mid index
		int mid = (start+end)/2 ;
		
		//Sort the first and second half
		sort(a, aux, start, mid);
		sort(a, aux, mid+1, end);
		
		//merge the results
		merge(a, aux, start, mid, end);
		
	}
	
	//Merge function
	private static void merge(int[] a, int aux[], int start, int mid, int end){
		
		//take all the elements of the array into helper array
		for(int k = start; k <= end ; k++){
			aux[k] = a[k];
		}
		
		int i = start , j = mid+1;
		
		//Start from starting index to end index. i.e both the half 
		//whichever is smaller from both the half gets to go in first into main array
		for (int k = start; k <= end; k++){
			
			//if we have visited all the elements of first half
			//all remaining elements of second half will be filled in
			if(i>mid){
				a[k] = aux[j++];
			}
			
			//if we have filled in all the elements from the first half
			//then will fill in all the remaining elements of the first half
			else if(j>end){
				a[k] = aux[i++];
			}
			
			//check for smaller element and fill in accordingly 
			else if(aux[j] < aux[i]){
				a[k] = aux[j++];
			}
			else{
				a[k] = aux[i++];
			}
			
			
		}
		
	}
	
	public static void main(String[] args){
		int[] a=new int[]{6,5,4,3,2,1,0};
		int[] aux = new int[a.length];
		System.out.println(Arrays.toString(a));
		sort(a, aux, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		
	}
}
