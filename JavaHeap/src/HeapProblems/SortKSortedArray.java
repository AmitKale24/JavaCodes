package HeapProblems;

import java.util.PriorityQueue;
import java.util.Vector;

public class SortKSortedArray {
	
	public static Vector<Integer> solve(int arr[],int K) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		Vector<Integer> ans = new Vector<>();
		
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
			if(heap.size()>K) {
				ans.add(heap.peek());
				heap.poll();
			}
		}
		
		while(heap.size()>0) {
			int pop = heap.poll();
			ans.add(pop);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {6,5,3,2,8,10,9};
		int K=3;
		System.out.println(solve(arr, K));

	}

}
