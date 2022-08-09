package TakeUForward;

import java.util.Arrays;

public class _11MinimumMaximumFallingPathSum {
	
	public static int memoization(int[][] points,int[][] dp,int i,int j) {
		if(j<0 || j>=points[0].length) return (int)Math.pow(-10,9);
		if(i==0) return points[0][j];
		if(dp[i][j]!=-1) return dp[i][j];
		
		int up = points[i][j] + memoization(points, dp, i-1, j);
		int ld = points[i][j] + memoization(points, dp, i-1, j-1);
		int rd = points[i][j] + memoization(points, dp, i-1, j+1);
		
		return dp[i][j] = Math.max(up, Math.max(ld, rd));
	}
	public static int solve(int[][] points) {
		int n = points.length;
		int m = points[0].length;
		int maxi = Integer.MIN_VALUE;
		
		int dp[][]=new int[points.length][points[0].length];
	    for(int row[]: dp) {
	    	 Arrays.fill(row,-1);
	    }
		
		for(int j=0;j<m;j++) {
			int ans = memoization(points, dp, n-1, j);
			maxi = Math.max(maxi, ans);
		}
		
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = {{1,2,10,4},
                {100,3,2,1},
                {1,1,20,2},
                {1,2,2,1}};
		
//		int i=points.length,j=points[0].length;
//	    int dp[][]=new int[points.length][points[0].length];
//	    for(int row[]: dp) {
//	    	 Arrays.fill(row,-1);
//	    }
//	    
//	    System.out.println(memoization(points, dp, i-1, j));
		
		System.out.println(solve(points));

	}

}
