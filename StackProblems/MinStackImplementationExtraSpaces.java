package StackProblems;

import java.io.ObjectInputStream.GetField;
import java.util.Stack;

public class MinStackImplementationExtraSpaces {
	
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	
	public static void push(int a) {
		s1.push(a);
		if(s2.isEmpty()) {
			s2.push(a);
		}
		else {
			if(s2.peek()>a) {
				s2.push(a);
			}
		}
	}
	
	public static void pop() {
		if(s1.peek() == s2.peek()) {
			s1.pop();
			s2.pop();
		}
		else {
			s1.pop();
		}
	}
	
	public static int getMin() {
		if(s2.isEmpty()) {
			return -1;
		}
		return s2.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		push(18);
		push(15);
		push(29);
		pop();
		
		System.out.println(getMin());

	}

}
