package FullGraphDataStructure;

import java.util.*;

public class TopologicalSortDFS {
	
	public static int[] solve(ArrayList<ArrayList<Integer>> adj,int V) {
		Stack<Integer> s = new Stack<>();
		int[] vis = new int[V+1];
		
		for(int i=0;i<V;i++) {
			if(vis[i] == 0) {
				checkDfs(adj, s, i,vis);
			}
		}
		
		int ans[] = new int[s.size()];
		int index=0;
		for(int i=s.size()-1;i>=0;i--) {
			ans[index++] = s.get(i);
		}
		
		
		
		return ans;
		
	}
	
	public static void checkDfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> s,int node,int vis[]) {
		vis[node] = 1;
		for(Integer it : adj.get(node)) {
			if(vis[it] == 0)
				checkDfs(adj, s, it, vis);
		}
		s.push(node);
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int V=6;
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        int res[] = solve(adj, V);
        
        for(int i=0;i<res.length;i++) {
        	System.out.print(res[i]+" ");
        }
	}

}
