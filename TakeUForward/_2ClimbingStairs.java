package TakeUForward;

import java.util.Arrays;

public class _2ClimbingStairs {
	
	public static int tabulationDP(int n, int dp[]) {
		
		dp[0] = 1;
		dp[1]  =1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		
		System.out.println(tabulationDP(n, dp));

	}

}
