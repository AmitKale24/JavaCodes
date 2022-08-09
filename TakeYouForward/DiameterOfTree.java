package TakeYouForward;

public class DiameterOfTree {
	
	public static int findHeight(Node root,int diameter[]) {
		if(root == null) return 0;
		
		int lh = findHeight(root.left,diameter);
		int rh = findHeight(root.right,diameter);
		diameter[0] = Math.max(diameter[0], lh+rh);
		return 1+Math.max(lh, rh);
	}
	
	public static int diameter(Node root) {
		
		int diameter[] = new int[1];
		findHeight(root,diameter);
		return diameter[0];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(6);
		root.right.left.left = new Node(5);
		root.right.left.left.left = new Node(9);
		root.right.right.right = new Node(7);
		root.right.right.right.right = new Node(8);
//		root.left.left = new Node(10);
////		root.left.left.left = new Node(11);
		
		System.out.println(diameter(root));

	}

}
