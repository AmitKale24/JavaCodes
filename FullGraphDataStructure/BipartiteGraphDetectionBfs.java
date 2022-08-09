package FullGraphDataStructure;
import java.util.*;
public class BipartiteGraphDetectionBfs {
	
	public static boolean solve(ArrayList<ArrayList<Integer>> adj,int V ) {
		int color[] = new int[V+1];
		Arrays.fill(color, -1);
		
		for(int i=0;i<V;i++) {
			if(color[i] == -1) {
				if(checkBfs(adj,i, color) == false) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean checkBfs(ArrayList<ArrayList<Integer>>adj,int node,int color[]) {
		
		
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 1;
		
		while(!q.isEmpty()) {
			int ele = q.poll();
			for(Integer it : adj.get(ele)) {
				if(color[it] == -1) {
					color[it] = 1-color[ele];
					q.add(it);
				}
				else if(color[it] == color[ele]) {
					return false;
				}
			}
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
