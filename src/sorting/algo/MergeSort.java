package sorting.algo;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] a, int[] aux, int start, int end){
		
		if (end <= start){
			return;
		}
		
		int mid = (start+end)/2 ;
		
		sort(a, aux, start, mid);
		sort(a, aux, mid+1, end);
		merge(a, aux, start, mid, end);
		
	}
	
	private static void merge(int[] a, int aux[], int start, int mid, int end){
		
		for(int k = start; k <= end ; k++){
			aux[k] = a[k];
		}
		
		int i = start , j = mid+1;
		for (int k = start; k <= end; k++){
			if(i>mid){
				a[k] = aux[j++];
			}
			else if(j>end){
				a[k] = aux[i++];
			}
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
