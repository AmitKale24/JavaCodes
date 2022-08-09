package FullGraphDataStructure;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphUsingUnitWeights {
	
	public static void solve(ArrayList<ArrayList<Integer>> adj,int V,int source) {
		int dist[] = new int[V];
		Arrays.fill(dist, 1000000000);
		Queue<Integer> q = new LinkedList<Integer>();
		dist[source] = 0;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(Integer it : adj.get(node)) {
				if(dist[node]+1<dist[it]) {
					dist[it] = dist[node]+1;
					q.add(it);
				}
			}
		}
		
		for(int i=0;i<dist.length;i++) {
			System.out.print(dist[i]+" ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
