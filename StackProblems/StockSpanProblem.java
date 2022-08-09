package StackProblems;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class StockSpanProblem {

	public static ArrayList<Integer> ngl(int arr[]){
		    Stack<Pair> s = new Stack<>();
		    ArrayList<Integer> ans = new ArrayList<>();
		    ArrayList<Integer> res = new ArrayList<>();
		    
		    
		    for(int i=0;i<arr.length;i++) {
		    	
			if(s.isEmpty()) {
				ans.add(-1);
			}
			else if(!s.isEmpty() && s.peek().element>arr[i]) {
				ans.add(s.peek().index);
			}
			else if(!s.isEmpty() && s.peek().element<=arr[i]) {
				while(!s.isEmpty() && s.peek().element<=arr[i]) {
					s.pop();
				}
				if(s.isEmpty()){
					ans.add(-1);
				}
				else {
					ans.add(s.peek().index);
				}
			}
			
			s.add(new Pair(arr[i], i));
		}
		
		for(int i=0;i<arr.length;i++) {
			res.add(i-ans.get(i));
		}
		
		return res;
		
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {100,80,60,70,60,75,85};
		
		System.out.println(ngl(arr));

	}

}

class Pair{
	int element;
	int index;
	
	public Pair(int element, int index) {
		this.element = element;
		this.index = index;
	}
}
