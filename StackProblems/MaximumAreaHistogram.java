package StackProblems;

import java.util.Stack;
import java.util.Vector;

public class MaximumAreaHistogram {
	
	public static Vector<Integer> nsl(int arr[]){
		Vector<Integer> ans = new Vector<>();
		Stack<Pair1> s = new Stack<>();
		int pseudoIndex = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(s.isEmpty()) {
				ans.add(pseudoIndex);
			}
			else if(!s.isEmpty() && s.peek().element<=arr[i]) {
				ans.add(s.peek().index);
			}
			else if(!s.isEmpty() && s.peek().element>arr[i]) {
				while(!s.isEmpty() && s.peek().element>arr[i]) {
					s.pop();
				}
				if(s.isEmpty()){
					ans.add(-1);
				}
				else {
					ans.add(s.peek().index);
				}
			}
			
			s.add(new Pair1(arr[i], i));
		}
		
		
		return ans;
		
	}
	
	public static Vector<Integer> nsr(int arr[]){
		Vector<Integer> ans = new Vector<>();
		Vector<Integer> res = new Vector<>();
		Stack<Pair1> s = new Stack<>();
		int pseudoIndex = arr.length;
		
		for(int i=arr.length-1;i>=0;i--) {
			if(s.isEmpty()) {
				ans.add(pseudoIndex);
			}
			else if(!s.isEmpty() && s.peek().element<=arr[i]) {
				ans.add(s.peek().index);
			}
			else if(!s.isEmpty() && s.peek().element>arr[i]) {
				while(!s.isEmpty() && s.peek().element>arr[i]) {
					s.pop();
				}
				if(s.isEmpty()){
					ans.add(-1);
				}
				else {
					ans.add(s.peek().index);
				}
			}
			
			s.add(new Pair1(arr[i], i));
		}
		
		for(int i=ans.size()-1;i>=0;i--) {
			res.add(ans.get(i));
		}
		
		
		return res;
		
	}
	
	
	public static int solve(int arr[]) {
		int max = 0;
		Vector<Integer> a = new Vector<>();
		Vector<Integer> b = new Vector<>();
		
		a = nsl(arr);
		b = nsr(arr);
		
		int width[] = new int[a.size()];
		
		for(int i=0;i<a.size();i++) {
			width[i] = b.get(i)-a.get(i)-1;
		}
		
		for(int i=0;i<width.length;i++) {
			max = Math.max(max, width[i]*arr[i]);
		}
	    
		
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {2,4};
		System.out.println(solve(arr));

	}

}

class Pair1{
	int element;
	int index;
	
	public Pair1(int element,int index) {
		this.element = element;
		this.index = index;
	}
}
