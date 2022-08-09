package TakeYouForward;

import java.util.*;

public class CheckBalancedTree {
	
	public static int findHeight(Node root) {
		if(root == null) return 0;
		
		int lh = findHeight(root.left);
		int rh = findHeight(root.right);
		
		return 1+Math.max(lh, rh);
	}
	
	public static boolean solve(Node root) {
		if(root == null) return true;
		int lh = findHeight(root.left);
		int rh = findHeight(root.right);
		if(Math.abs(rh-lh)>1) return false;
		boolean left = solve(root.left);
		boolean right = solve(root.right);
		
		if(!left || !right) return false;
		return true;
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
