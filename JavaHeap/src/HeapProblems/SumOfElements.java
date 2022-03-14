package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElements {
	
	public static int solve(int arr[],int K) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i=0;i<arr.length;i++) {
			maxHeap.add(arr[i]);
			if(maxHeap.size()>K) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {20, 8, 22, 4, 12, 10, 14};
		
		int first = solve(arr, 3);
		int second = solve(arr, 6);
		
		int total = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>first && arr[i]<second) {
				total = total+arr[i];
			}
		}
		
		System.out.println(total);

	}

}
