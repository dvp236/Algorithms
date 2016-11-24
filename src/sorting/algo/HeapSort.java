package sorting.algo;

import java.util.Arrays;

/**
 * 
 * @author dharmik
 * Implementing HeapSort Algorithm
 */

public class HeapSort {
	private int[] heap;
	private int size;
	
	private void buildHeap(){
		for(int k=size/2; k>0; k--){
			percolateDown(k);
		}
	}
	
	private void percolateDown(int pos){
		int tmp = heap[pos];
		int child;
		
		while(pos*2 < size){
			child = pos*2;
			if(heap[child] > heap[child+1]) child++;
			
			if(heap[child] < tmp)
				heap[pos] = heap[child];
			else 
				break;
			
			pos = child;
		}
		
		heap[pos] = tmp;
		
	}
	
	public void heapSort(int[] a){
		size=a.length;
		heap = new int[size+1];
		System.arraycopy(a,0,heap,1,size);
		buildHeap();
		
		for(int k=size; k>0;k--){
			int temp = heap[k];
			heap[k] = heap[1];
			heap[1] = temp;
			size--;
			percolateDown(1);
		}
		for(int k = 0; k < heap.length-1; k++) {
			System.out.println(heap[k]);
	         a[k] = heap[heap.length - 1 - k];
		}

	}
	
	public static void main(String[] args) {

		int[] a = new int[]{3,5,2,1,7,9,4};
		HeapSort hs = new HeapSort();
		hs.heapSort(a);
		System.out.println(Arrays.toString(a));
		
		
	}

}
