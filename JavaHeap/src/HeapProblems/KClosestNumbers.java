package HeapProblems;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.*;

public class KClosestNumbers {
	public static Vector<Integer> solve(int arr[],int K,int X) {
		PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.reverseOrder());
		Vector<Integer> ans = new Vector<>();
		
		for(int i=0;i<arr.length;i++) {
			heap.add(new Pair(Math.abs(X-arr[i]),arr[i]));
			if(heap.size()>K) {
				heap.poll();
			}
		}
		
		while(heap.size()>0) {
			ans.add(heap.peek().element);
			heap.poll();
		}
		
		return ans;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,6,7,8,9};
		int K=3;
		int X=7;
		System.out.println(solve(arr, K,X));

	}

}

class Pair implements Comparable<Pair>{
    int diff;
    int element;
    public Pair(int diff, int element){
        this.diff=diff;
        this.element= element;
    }
	@Override
	public int compareTo(Pair o) {
		if(this.element==o.element){
            return 0;
        }
        else{
            return this.diff-o.diff;
        }
	}
}
