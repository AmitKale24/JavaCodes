package TakeUForward;

import java.util.*;

public class _3FrogJump {
	
	public static int recursion(int dp[],int n,int arr[]) {
		if(n <= 0) return 0;
		int first = Math.abs(arr[n]-arr[n-1])+recursion(dp, n-1, arr);
		
		int second = Integer.MAX_VALUE;
		if(n>1) {
			second = Math.abs(arr[n]-arr[n-2])+recursion(dp, n-2, arr);
		}
		return Math.min(first, second);
	}
	
	public static int solve(int n , int dp[] ,int arr[]) {
		dp[0] = 0;
		
		
		for(int i=1;i<n;i++) {
			int first = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
			int second = Integer.MAX_VALUE;
			if(i>2) {
				second = dp[i-2] + Math.abs(arr[i]-arr[i-2]);
			}
			dp[i] = Math.min(first, second);
		}
		
		
		return dp[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {10,20,30,10};
		int n = arr.length;
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		
		System.out.println(solve(n, dp, arr));
		System.out.println(recursion(dp, n-1, arr));
		
		

	}

}

