package KnapsackProblem;

import java.util.Arrays;

public class MinimumCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 18;
		int a[] = {7,5,1};
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		int ans = minCoins(n, a, dp);
		System.out.println(ans);

	}
	
	static int minCoins(int n, int a[], int dp[]) {
		//n=18
		if(n==0) {
			return 0;
		}
		 
		int ans = Integer.MAX_VALUE; //maximum possible value for any integer variable in Java
		
		
		for(int i=0;i<a.length;i++) {
			
			if(n-a[i]>=0) {
				int subAns = 0;
				
				if(dp[n-a[i]] != -1) {
					subAns = dp[n-a[i]];
				}
				
				else{
					 subAns = minCoins(n-a[i], a, dp);
				}
				
				if(subAns != Integer.MAX_VALUE && subAns+1 < ans) {
					ans = subAns+1;
				}
			} 
			
		}
		
		return dp[n] = ans;
		
		
	}

}
