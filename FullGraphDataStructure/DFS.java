package FullGraphDataStructure;
import java.util.*;
import java.sql.Array;
import java.util.*;

public class DFS {
	
	public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> adj,int N){
		ArrayList<Integer> ans = new ArrayList<>();
		boolean vis[] = new boolean[N];
		
		for(int i=0;i<N;i++) {
			if(!vis[i]) {
				dfs(i, adj, vis, ans);
			}
		}
		
		
		return ans;
	}
	
	
    private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
		vis[v] = true;
		ans.add(v);
		
		for(Integer it : adj.get(v)) {
			if(!vis[it]) {
				dfs(it,adj,vis,ans);
			}
		}
	}
    
    public static ArrayList<Integer> dfsStack(ArrayList<ArrayList<Integer>> adj,int N){
		ArrayList<Integer> dfs = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		boolean vis[] = new boolean[N];
		s.add(0);
		vis[0] = true;
		
		while(!s.isEmpty()) {
			int ele = s.pop();
			dfs.add(ele);
			for(Integer it : adj.get(ele)) {
				if(vis[it] == false) {
					vis[it] = true;
					s.add(it);
				}
			}
		}
		
		return dfs;
		
	} 


	public static void main(String args[]) {
    	int N = 6; 
    	boolean vis[] = new boolean[N];
    	

    	ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(1);
        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(3);
        adj.get(5).add(4);

        System.out.println(adj);
        System.out.println(solve(adj,N));
        System.out.println(dfsStack(adj, N));
    }

	

}
