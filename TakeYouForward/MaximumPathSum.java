package TakeYouForward;

public class MaximumPathSum {
	
	public static int findHeight(Node root,int diameter[]) {
		if(root == null) return 0;
		
		int lh = Math.max(0,findHeight(root.left, diameter)); //Sometimes -ve values come so we return 0 bcz we know for -ve Node maximum path sum never come
		int rh = Math.max(0,findHeight(root.right, diameter)); ///Sometimes -ve values come so we return 0 bcz we know for -ve Node maximum path sum never come
		diameter[0] = Math.max(diameter[0], root.data+lh+rh);
		return root.data+Math.max(lh, rh);
	}
	public static int solve(Node root) {
		int[] diameter = new int[1];
		findHeight(root, diameter);
		return diameter[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(solve(root));
	}

}
