package TakeUForward;

import java.util.*;

public class _1FibonacciSeries {
	
	public static int solve(int n , int dp[]) {
		if(n<=1) return n;
		
		//1)Recursion
		//return solve(n-1, dp)+solve(n-2, dp); => o/p = 8
		
		//2)DP
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		return dp[n] = solve(n-1, dp)+solve(n-2, dp); //=> o/p = 8
		
		
	}
	
	public static int tabulationDP(int n , int dp[]) {
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-2]+dp[i-1];
		}
		
		
		
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 6;
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		System.out.println(solve(n, dp));
		System.out.println(tabulationDP(n, dp));
		

	}

}
