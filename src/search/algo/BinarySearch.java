package search.algo;

/**
 * 
 * @author dharmik
 * Implement Binary Search in Java
 *
 */

public class BinarySearch {

	//Time Complexity O(log(n))
	//Get index of particular element from sorted array a.
	public int getIndex(int key, int[] a){
		
		int len = a.length;
		int start = 0, end=len-1;
		//until we look out in whole array
		while(start<=end){
			//set mid index
			int mid = (start+end)/2;
			
			//if a[mid] matches key then return mid
			if(a[mid]==key){
				return mid;
			}
			
			//if key lies in first half of array, move 'end' to mid-1
			else if(a[mid]>key){
				end=mid-1;
			}
			
			//if key lies in second half of array, move 'start' to mid+1
			else{
				start=mid+1;
			}
		}
		return -1;
	}
	
	//check if an element is present in the array
	public boolean contains(int key, int[] a){
		
		int start=0,end=a.length-1;
		//loop over the array
		while(start<=end){
			int mid = (start+end)/2;
			if(a[mid]==key){
				return true;
			}
			//check if element is in the first half
			else if(a[mid]>key){
				end=mid-1;
			}
			
			//move the start to mid+1, since element is in second half
			else{
				start=mid+1;
			}
		}
		
		//return false if element isn't found
		return false;
	}
	
	
	

}
