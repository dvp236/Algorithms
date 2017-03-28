package applications.algo;

import java.util.Arrays;


/**
 * 
 * @author dharmik
 *
 */

/*
 * 3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n2 in the worst case. 
 * You may assume that you can sort the n integers in time proportional to n2 or better.
 */

public class ThreeSum {
//	an O(n^2logn) approach -
//	sort an array first
//	Have 2 for loop i from 0 to n, j from i+1 to n
//	and then check for -(a[i]+a[j]) element using binarySearch on remaining values.
//	if present then we have pair.
	
	
	//This Approach is O(n^2). More efficient.
	public static void get3SumPairs( int[] a ) {
		
		//sort array
		Arrays.sort(a);
		
		for(int i = 0; i < a.length; i++ ) {
			int j = i+1;
			int k = a.length -1;
			
			while(j < k){
				
				int sum = a[i] + a[j] + a[k];
				//if 0 then we have a pair
				if( sum == 0){
					System.out.println(a[i] + ", "+a[j]+", "+a[k]);
				}
				
				//else if < 0 then move j ahead for larger value
				if(sum < 0){
					j++;
				}else{
					//if positive then decrement k towards smaller value so we can come near 0
					k--;
				}
				
			}
				
		}
		
	}
	


	public static void main(String[] args) {
		
		int[] a = new int[] { 30, 40, 20, -10, 10, -50, -60, -70 };
		get3SumPairs(a);
	}

}
