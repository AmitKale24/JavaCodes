package FullGraphDataStructure;
import java.sql.Array;
import java.util.*;

public class CycleDetectionUdingDfs {
	
	public static boolean solve(ArrayList<ArrayList<Integer>> adj,int V) {
		boolean vis[] = new boolean[V+1];
		for(int i=0;i<V;i++) {
			if(vis[i] == false) {
				if(checkCycleDfs(adj, -1, i, vis) == true) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean checkCycleDfs(ArrayList<ArrayList<Integer>> adj,int parent,int node,boolean vis[] ) {
		vis[node] = true;
		for(Integer st: adj.get(node)) {
			if(vis[st] == false) {
				if(checkCycleDfs(adj, node, st, vis)==true) {
					return true;
				}	
			}
			else if(st!=parent) {
				return true;
			}
		}
		
		return false;
 	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
        	adj.add(i, new ArrayList<Integer>());
        }
            
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);
        
        System.out.println(adj);
        System.out.println(solve(adj,V));

	}

}
