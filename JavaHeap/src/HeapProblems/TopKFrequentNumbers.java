package HeapProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

public class TopKFrequentNumbers {
	
	public static Vector<Integer> solve(int arr[],int K){ 
		Vector<Integer> res = new Vector<>();
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			map.put(map.getOrDefault(arr[i], 0) + 1,arr[i]);
		}
		
		PriorityQueue<FrequencySortPair> minHeap = new PriorityQueue<>();
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			minHeap.add(new FrequencySortPair(entry.getValue(), entry.getKey()));
		}
		
		for(int i=0;i<K;i++) {
			res.add(minHeap.poll().element);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
		int K=2;
		System.out.println(solve(arr, K));

	}

}


