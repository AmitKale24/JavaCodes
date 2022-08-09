package FullGraphDataStructure;
import java.util.*;
public class CycleDetectionUsingBfs {
	
	public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj) {
		boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(vis[i]==false) 
                if(checkCycle(adj, i,vis) == true) 
                    return true;
    
        return false;
		
	}
	
	public static boolean checkCycle(ArrayList<ArrayList<Integer>> adj,int s,boolean vis[]) {
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(s, -1));
		vis[s] = true;
		
		while(!q.isEmpty()) {
			int ele = q.peek().a;
			int par = q.peek().b;
			q.remove();
			
			for(Integer it:adj.get(ele)) {
				if(vis[it] == false) {
					q.add(new Pair(it,ele));
					vis[it] = true;
				}
				else if(par!=it) return true;
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
        System.out.println(isCycle(V, adj));
        

	}

}

class Pair{
	int a;
	int b;
	
	public Pair(int a,int b) {
		this.a = a;
		this.b = b;
	}
}
