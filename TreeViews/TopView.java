package TreeViews;

import java.util.*;

public class TopView {
	
	//Vertical Order Traversal
	public static ArrayList<Integer> printTopView(Node root) {
		
		Queue<Pair> q = new ArrayDeque<>();
		Map<Integer, Integer> topViewMap = new TreeMap<>();
		q.add(new Pair(0,root));
		
		while(!q.isEmpty()) {
			Pair curr = q.poll();
		
			if(!topViewMap.containsKey(curr.hd)) {
				topViewMap.put(curr.hd, curr.node.data);
			}
			
			if(curr.node.left != null) {
				q.add(new Pair(curr.hd-1,curr.node.left));
			}
			if(curr.node.right != null) {
				q.add(new Pair(curr.hd+1,curr.node.right));
			}
		}
		
		
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entry:topViewMap.entrySet()) {
			ans.add(entry.getValue());
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		Node root = new Node(10);
		root.left = new Node(4);
		root.left.right = new Node(23);
		root.right = new Node(12);
		
		System.out.println(printTopView(root));

	}

}


//
//class Node{
//	int data;
//	Node left,right;
//	
//	public Node(int data) {
//		this.data = data;
//		left = null;
//		right = null;
//	}
//}

class Pair{
	int hd; //Horizontal Distance
	Node node;
	
	public Pair(int hd,Node node) {
		this.hd = hd;
		this.node = node;
	}
}