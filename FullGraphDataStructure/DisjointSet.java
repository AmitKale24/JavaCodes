package FullGraphDataStructure;
import java.util.*;
public class DisjointSet {
	
	static int parent[] = new int[100000];
	static int rank[] = new int[100000];
	
	
	public static void makeSet() {
		for(int i=0;i<parent.length;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}
	
	//7->6->5->4
	public static int findPar(int node) {
		if(node == parent[node]) {
			return node;
		}
		
		return parent[node] = findPar(parent[node]);
	}
	
	public static void union(int i,int j) {
		i = findPar(i);
		j = findPar(j);
		if(rank[i]<rank[j]) {
			parent[i] = j;
		}
		else if(rank[i]>rank[j]) {
			parent[j] = i;
		}
		else {
			parent[j] = i;
			rank[i]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		while(m>0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			union(u, v);
			m--;
		}
		

	}

}
