package sorting.algo;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implement BubbleSort
 */
public class BubbleSort {
	
	//Time Complexity: O(n^2)
	public static int[] sort(int[] arr){
		//Bubble sort put the largest value to end of list
        for(int i=0; i < arr.length-1 ; i++){
        	
            for(int j=1; j < arr.length-i; j++){
            	//compare each element compare it with previous element
                if(arr[j-1] > arr[j]){
                	
                	//swap values
                	int temp;
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
        System.out.println("Final result:"+Arrays.toString(sort(arrayList)));
	}

}
