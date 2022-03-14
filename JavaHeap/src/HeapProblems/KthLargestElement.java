package HeapProblems;

import java.util.PriorityQueue;

public class KthLargestElement {
	
	public static void solve(int arr[],int K) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
			if(heap.size()>K) {
				heap.poll();
			}
		}
		
		while(heap.size()>0) {
			int pop = heap.poll();
			System.out.println(pop);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,10,4,3,20,15};
		int K=3;
		
		solve(arr, K);

	}

}
