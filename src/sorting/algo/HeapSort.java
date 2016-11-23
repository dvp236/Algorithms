package sorting.algo;
/**
 * 
 * @author dharmik
 * Implementing HeapSort Algorithm
 */

public class HeapSort {
	private int[] heap;
	private int size;
	private void buildHeap(){
		
	}
	private void percolateDown(int pos){
		
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
			//size--;
			percolateDown(1);
		}
		for(int k = 1; k < heap.length-1; k++) 
	         a[k] = heap[heap.length - 1 - k];
		//printHeap();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
