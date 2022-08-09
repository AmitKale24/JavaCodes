package Stack;

import java.util.Stack;
import java.util.Vector;

public class NearestGreaterToLeft {
	
	public static Vector<Integer> ngl(int arr[]){
		Vector<Integer> ans = new Vector<>();
		Vector<Integer> res = new Vector<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			if(s.isEmpty()) {
				ans.add(-1);
			}
			else if(!s.isEmpty() && s.peek()>arr[i]) {
				ans.add(s.peek());
			}
			else if(!s.isEmpty() && s.peek()<=arr[i]) {
				while(!s.isEmpty() && s.peek()<=arr[i]) {
					s.pop();
				}
				if(s.isEmpty()){
					ans.add(-1);
				}
				else {
					ans.add(s.peek());
				}
			}
			
			s.add(arr[i]);
		}
		
		
		
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {1,3,2,4};
		
		System.out.println(ngl(arr));

	}

}
