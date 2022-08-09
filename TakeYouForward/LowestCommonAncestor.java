package TakeYouForward;

public class LowestCommonAncestor {

	public static Node lca(Node root,Node a,Node b) {
		if(root == null || root == a || root == b) return root;
		Node left = lca(root.left, a, b);
		Node right = lca(root.right, a, b);
		
		if(left == null) return right;
		else if(right == null) return left;
		else return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
