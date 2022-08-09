package TakeYouForward;

public class CountTotalNodesInBinaryTree {
	
	public static int countNodes(Node root) {
		int lc = leftCount(root);
		int rc = rightCount(root);
		if(lc == rc) return (int)(Math.pow(2, rc)-1);
		else {
			return lc+rc+1;
		}
	}
	public static int leftCount(Node root) {
		if(root == null) return 0;
		int count = 0;
		while(root.left != null) {
			count++;
			root = root.left;
		}
		return count;
	}
    public static int rightCount(Node root) {
    	if(root == null) return 0;
		int count = 0;
		while(root.right != null) {
			count++;
			root = root.right;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
