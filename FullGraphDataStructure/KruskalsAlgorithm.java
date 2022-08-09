package FullGraphDataStructure;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class KruskalsAlgorithm {
	
	public static void kruskalAlgo(ArrayList<KruskalNode> adj,int N) {
		Collections.sort(adj, new SortComparator());
		int parent[] = new int[N];
		int rank[] = new int[N];
		
		for(int i=0;i<N;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int costMst = 0;
		ArrayList<KruskalNode> mst = new ArrayList<KruskalNode>();
		for(KruskalNode it : adj) {
			if(findPar(it.getU(),parent)!= findPar(it.getV(),parent)) {
				costMst = it.getWeight();
				mst.add(it);
				union(it.getU(),it.getV(),parent,rank);
			}
		}
		System.out.println(costMst);
		for(KruskalNode it:mst) {
			System.out.println(it.getU()+" "+it.getV());
		}
	}

	public static int findPar(int node,int parent[]) {
		if(node == parent[node]) {
			return node;
		}
		
		return parent[node]=findPar(parent[node], parent);
	}
	
	public static void union(int i,int j,int parent[],int rank[]) {
		i = findPar(i,parent);
		j = findPar(j,parent);
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
		int N = 5;
		ArrayList<KruskalNode> adj = new ArrayList<KruskalNode>();
		
		adj.add(new KruskalNode(0,1,2));
		adj.add(new KruskalNode(0,3,6));
		adj.add(new KruskalNode(1,3,8));
		adj.add(new KruskalNode(1,2,3));
		adj.add(new KruskalNode(1,4,5));
		adj.add(new KruskalNode(2,4,7));
		
		kruskalAlgo(adj, N);

	}

}

class KruskalNode{
	int a,b,c;
	public KruskalNode(int a,int b,int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public KruskalNode() {}
	public int getV() {return b;}
	public int getU() {return a;}
	public int getWeight() {return c;};
}

class SortComparator implements Comparator<KruskalNode>{

	@Override
	public int compare(KruskalNode o1, KruskalNode o2) {
		if(o1.getWeight()<o2.getWeight()) return -1;
		if(o1.getWeight()>o2.getWeight()) return 1;
		return 0;
	}
}
