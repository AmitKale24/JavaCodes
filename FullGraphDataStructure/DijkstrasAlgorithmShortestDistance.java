package FullGraphDataStructure;

import java.util.*;

public class DijkstrasAlgorithmShortestDistance {
	
	public static void solve(ArrayList<ArrayList<Node>> adj,int N , int source) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>();
		minHeap.add(new Node(source,0));
		
		int dist[] = new int[N];
		Arrays.fill(dist, 1000000000);
		
		while(minHeap.size()>0) {
			Node node = minHeap.poll();
			
			for(Node it : adj.get(node.getV())) {
				if(dist[node.getV()]+it.getWeight() < dist[it.getV()]) {
					dist[it.getV()] = dist[node.getV()]+it.getWeight();
					minHeap.add(new Node(it.getV(),dist[it.getV()]));
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

class Node implements Comparator < Node > {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {}

    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.weight < node2.weight)
            return -1;
        if (node1.weight > node2.weight)
            return 1;
        return 0;
    }
}
