package TakeYouForward;

import org.w3c.dom.Node;

public class MaximumDepthOfTree {
	
	public static int solve(Node root) {
		if(root == null) return 0;
		
		int lh = solve(root.left);
		int rh = solve(root.right);
		
		return 1+Math.max(lh, rh);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
	public Node(int data,Node left,Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}