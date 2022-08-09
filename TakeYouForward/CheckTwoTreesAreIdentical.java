package TakeYouForward;

public class CheckTwoTreesAreIdentical {
	
	public static boolean solve(Node root1,Node root2) {
		if(root1 == null || root2 == null) return root1==root2;
		
		return (root1.data == root2.data) && solve(root1.left, root2.left) && solve(root1.right, root2.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
