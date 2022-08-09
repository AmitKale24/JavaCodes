package TakeYouForward;
import java.util.*;
public class ZigZagTraversal {
	
	public static ArrayList<Integer> solve(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		
		Queue<Integer> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		q.add(root.data);
		boolean leftToright = true;
		while(!q.isEmpty()) {
			int size = q.size();
			
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
