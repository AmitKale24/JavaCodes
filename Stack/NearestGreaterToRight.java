package Stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class NearestGreaterToRight {
	
	public static Vector<Integer> ngr(int arr[]){
		Vector<Integer> ans = new Vector<>();
		Vector<Integer> res = new Vector<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
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
		
		for(int i=ans.size()-1;i>=0;i--) {
			res.add(ans.get(i));
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		int arr[] = {1,3,2,4};
		
		System.out.println(ngr(arr));

	}

}
