package TakeUForward;

import java.util.Arrays;

public class _18KnapsackProblem {
	
	public static int memoization(int wt[],int val[],int dp[][],int W,int ind) {
		if(ind == 0) {
			if(wt[ind]<=W) return val[ind];
			else return 0;
		}
		
		if(dp[ind][W]!=-1) return dp[ind][W];
		
		int notTake = 0 + memoization(wt, val, dp, W, ind-1);
		int take = 0;
		if(W>=wt[ind]) {
			take = val[ind]+memoization(wt, val, dp, W-wt[ind], ind-1);
		}
		
		return dp[ind][W] = Math.max(notTake, take);
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {2,3,5};
		int val[] = {20,30,40};
		int W = 5;
		
        int dp[][] = new int[wt.length][W+1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(memoization(wt, val, dp, W, wt.length-1));
		

	}

}
