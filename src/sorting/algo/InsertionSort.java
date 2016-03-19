package sorting.algo;

import java.util.Arrays;

public class InsertionSort {
	public static int[] sort(int[] a){
		int i,j,val;
		for(i=2;i<a.length;i++){
			j=i;
			val = a[i];
			
			while(j>0 && a[j-1]>val){
				a[j] = a[j-1];
				j--;
			}
			a[j] = val;
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int arrayList[] = { 5,3,9,7,1,8,2,4 };
        System.out.println("\nFinal result:"+Arrays.toString(sort(arrayList)));

	}
	
}
