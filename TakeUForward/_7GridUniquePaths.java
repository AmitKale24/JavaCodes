package TakeUForward;

import java.util.Arrays;

public class _7GridUniquePaths {
	
	public static int memoization(int i,int j,int[][]dp) {
		if(i==0 && j==0) {
			return 1;
		}
		if(i<0 || j<0) {
			return 0;
		}
		
		if(dp[i][j]!=-1) return dp[i][j];
		int up = memoization(i-1, j, dp);
		int left = memoization(i, j-1, dp);
		
		return dp[i][j] = up+left;
	}
	
	public static int tabulation(int i,int j,int dp[][]) {
		if(i==0 && j==0) dp[0][0] = 1;
		else {
			int up=0,left=0;
			if(i>0){ 
				up = dp[i-1][j];
			}
			if(j>0){ 
				left = dp[i][j-1]; 
			}
			dp[i][j] = up+left;
		}
		
		return dp[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=3,j=3;
		int dp[][] = new int[i][j];
		
		for (int[] row: dp)
            Arrays.fill(row, -1);
	    
		System.out.println(memoization(i-1, j-1, dp));
		System.out.println(tabulation(i-1, j-1, dp));
		

	}

}
