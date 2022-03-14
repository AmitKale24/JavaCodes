package HeapProblems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Vector;

public class KClosestPointsToOrigin {
	
	public static void solve(int arr[][],int K){ 
		Vector<MapPair> res = new Vector<>();
		Map<Integer, MapPair> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i][0]*arr[i][0]+arr[i][1]*arr[i][1],new MapPair(arr[i][0], arr[i][1]));
		}
		
		PriorityQueue<Map.Entry<Integer, MapPair>> maxHeap = new PriorityQueue<>((a, b)
                -> a.getValue().equals(b.getValue())
                ? Integer.compare(b.getKey(),
                                  a.getKey())
                : Integer.compare(b.getValue().b,
                                  a.getValue().a));
		
		for(Entry<Integer, MapPair> entry: map.entrySet()) {
			maxHeap.offer(entry);
			if(maxHeap.size()>K) {
				maxHeap.poll();
			}
		}
		
		for(int i=0;i<K;i++) {
			int a = maxHeap.peek().getValue().a;
			int b = maxHeap.peek().getValue().b;
			
			System.out.print("["+a+" , "+b+"] ");
			maxHeap.poll();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = { { 3, 3 },
                { 5, -1 },
                { -2, 4 } };
		int K=2;
		solve(points, K);

	}

}

class MapPair{
	int a;
	int b;
	public MapPair(int a,int b) {
		this.a = a;
		this.b = b;
	}
}
