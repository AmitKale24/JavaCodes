package FullGraphDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInDirectedGraphUsingBfs {
	
	

	public static boolean solve(ArrayList<ArrayList<Integer>> adj,int V) {
		int topo[] = new int[V];
		int indegree[] = new int[V];
		for(int i=0;i<V;i++) {
			for(Integer it:adj.get(i)) {
				indegree[it]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<V;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		int index = 0;
		
		for(int i=0;i<V;i++) {
			int node = q.poll();
			index++;
			
			for(Integer it: adj.get(node)) {
				indegree[it]--;
				if(indegree[it]==0) {
					q.add(it);
				}
			}
		}
		
		if(index == V) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 6;
		ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }


        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);
        
//        int res[] = solve(adj, V);
//        
//        for(int i=0;i<res.length;i++) {
//        	System.out.print(res[i]+" ");
//        }
        
        System.out.println(solve(adj, V));

	}

}
