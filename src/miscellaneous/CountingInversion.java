package miscellaneous;

/**
 * 
 * @author dharmik
 * 
 * To Count Inversions we will use Divide and conquer paradigm 
 * Right modification in the mergesort code can give us number of inversions
 * 
 * One of the main Applications of counting inversion is getting similar profile in 
 * recommendations system. The profile which has minimum number of inversion with yours can 
 * help determine your taste in shopping and browsing
 * 
 * 
 * Time complexity = O(nlogn)
 */

public class CountingInversion {
	
	public static int countingInversion(int[] a, int[] aux, int start, int end){
		if(start == end) return 0;
		
		int mid = (end + start)/2;
		//divide and conquer
		int count1 = countingInversion(a, aux, start, mid);
		int count2 = countingInversion(a, aux, mid+1, end);
		
		int splitcount = mergeSplitCount(a,aux,start, mid, end);
		
		//add all and return
		return count1+count2+splitcount;
	}
	
	//merge function
	public static int mergeSplitCount(int[] a, int[] aux, int start, int mid, int end){
		int i = start, j= mid+1;
		
		int count=0;
		for(int k=start; k<=end; k++){
			aux[k] = a[k];
		}
		
		for(int k = start ; k<=end ;k++){
			if(i>mid){
				a[k] = aux[j++];
			}
			else if(j>end){
				a[k] = aux[i++];
			}
			//the only case when inversion happens 
			else if(aux[j] < aux[i]){
				a[k] = aux[j++];
				//increment counter
				count++;
				//add all remaining values in inversion. (because all remaining will be bigger than aux[j])
				count+= (mid - i);
			}else {
				a[k] = aux[i++];
			}
		}
		return count;
	}
	
	public static int count(int[] a){
		int inv = countingInversion(a, new int[a.length], 0, a.length-1);
		return inv;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{1,2,4,5,3,6};
		int[] b = new int[]{6,5,4,3,2,1};
 
		System.out.println(count(b));
	}
}
