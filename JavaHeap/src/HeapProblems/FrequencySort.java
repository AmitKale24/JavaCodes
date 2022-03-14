package HeapProblems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

public class FrequencySort {
	
	public static void solve(int arr[]){ 
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
			minHeap.add(entry);
		}
		
		while(minHeap.size()>0) {
			int freq = minHeap.peek().getValue();
			int ele = minHeap.peek().getKey();
			
			for(int i=1;i<=freq;i++) {
				System.out.print(ele+" ");
			}
			
			minHeap.poll();
		}
		
		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        solve(arr);
        //System.out.println(frequencySort(arr));

	}

}

class FrequencySortPair implements Comparable<FrequencySortPair>{
    int frequency;
    int element;
    public FrequencySortPair(int frequency, int element){
        this.frequency=frequency;
        this.element= element;
    }
	
	@Override
	public int compareTo(FrequencySortPair o) {
		// TODO Auto-generated method stub
		if(this.element==o.element){
            return 0;
        }
        else{
            return this.frequency;
        }
	}
}
