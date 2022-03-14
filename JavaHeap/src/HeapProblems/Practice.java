package HeapProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

public class Practice {
	
	public static Vector<Integer> solve(int arr[],int K){ 
		Vector<Integer> res = new Vector<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b)
                -> a.getValue().equals(b.getValue())
                ? Integer.compare(b.getKey(),
                                  a.getKey())
                : Integer.compare(b.getValue(),
                                  a.getValue()));
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			minHeap.offer(entry);
			
		}
		
		for(int i=0;i<K;i++) {
			res.add(minHeap.poll().getKey());
		}
		
		
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,1,2,2,3,4};
		int K=2;
		System.out.println(solve(arr, K));

	}

}
