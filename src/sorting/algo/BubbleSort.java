package sorting.algo;

import java.util.Arrays;

public class BubbleSort {
	
	public static int[] sort(int[] arr){
		int temp;
		
        for(int i=0; i < arr.length-1 ; i++){
        	
            for(int j=1; j < arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    temp=arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                   
                }
            }

        }
        return arr;
	}
	
	public static void main(String[] args) {
		 
        int arrayList[] = { 5,3,9,7,1,8,2 };
        System.out.println("\nFinal result:"+Arrays.toString(sort(arrayList)));
	}

}
