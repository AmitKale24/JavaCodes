package HeapProblems;

import java.util.PriorityQueue;

public class ConnectRopesMinimumCost {
	
	public static int solve(int arr[]) {
		int cost = 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		for(int i=0;i<arr.length;i++) {
			minHeap.add(arr[i]);
		}
		
		while(minHeap.size()>=2) {
			int first = minHeap.peek();
			minHeap.poll();
			int second = minHeap.peek();
			minHeap.poll();
			cost = cost+first+second;
			minHeap.add(first+second);
		}
		
		return cost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4, 3, 2, 6};
		System.out.println(solve(arr));

	}

}
