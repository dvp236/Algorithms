package sorting.algo;

import java.util.Arrays;

public class SelectionSort {
	
	public static int[] sort(int[] a){
		int i,j,min;
		for(i=0;i<a.length-1;i++){
			min=i;
			for(j=i+1;j<a.length;j++){
				if(a[j]< a[min]){
					min = j;
				}
			}
			int temp = a[i];
			a[i]=a[min];
			a[min]=temp;
			
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int arrayList[] = { 5,3,9,7,1,8,2,4 };
        System.out.println("\nFinal result:"+Arrays.toString(sort(arrayList)));

	}

}
