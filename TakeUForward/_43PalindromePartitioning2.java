package TakeUForward;
import java.util.*;
public class _43PalindromePartitioning2 {
	
	public static int recursion(String str,int i,int n) {
		if(i == n) return 0;
		int mini = Integer.MAX_VALUE;
		
		for(int j = i;j<n;j++) {
			if(isPalindrome(i,j,str)) {
				int cost = 1 + recursion(str,j+1,n);
			    mini = Math.min(mini, cost);
			}
		}
		
		return mini;
		
	}

	public static boolean isPalindrome(int i, int j, String str) {
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ABA";
		System.out.println(recursion(str, 0, str.length()));

	}

}
