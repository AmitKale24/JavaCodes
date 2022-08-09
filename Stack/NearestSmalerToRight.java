package Stack;

import java.util.Stack;
import java.util.Vector;

public class NearestSmalerToRight {

	public static Vector<Integer> nsr(int arr[]){
		Vector<Integer> ans = new Vector<>();
		Vector<Integer> res = new Vector<>();
		Stack<Integer> s = new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
			if(s.isEmpty()) {
				ans.add(-1);
			}
			else if(!s.isEmpty() && s.peek()<=arr[i]) {
				ans.add(s.peek());
			}
			else if(!s.isEmpty() && s.peek()>arr[i]) {
				while(!s.isEmpty() && s.peek()>arr[i]) {
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
		// TODO Auto-generated method stub
        int arr[] = {1,3,2,4};
		
		System.out.println(nsr(arr));

	}

}
