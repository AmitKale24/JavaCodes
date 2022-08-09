package TakeYouForward;

import java.util.ArrayList;

public class GetPath {
	
	public static boolean getPath(Node root,int x,ArrayList<Integer> arr) {
		if(root == null) return false;
		arr.add(root.data);
		if(root.data == x) {
			return true;
		}
		if(getPath(root.left, x, arr) || getPath(root.right, x, arr)) {
			return true;
		}
		arr.remove(arr.size()-1);
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
