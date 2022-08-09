package TakeUForward;

import java.util.Arrays;

public class _35BuySellStocksPart2 {
	
	public static int memoization(int arr[],int buy,int ind,int[][] dp) {
		if(ind == arr.length) return 0;
		if(dp[ind][buy] != -1) return dp[ind][buy];
		int profit = 0;
		
		//If buy==1 means we have permission to buy
		if(buy==1) {
			//max(Buy , Not Buy)
			//-arr[ind] because if we buy stock then profit = profit-arr[ind]
			profit = Math.max(profit-arr[ind]+memoization(arr, 0, ind+1,dp),0+memoization(arr, 1, ind+1,dp));
		}
		
		//If sell
		else {
			//max(Sell , Not Sell)
			profit = Math.max(arr[ind]+memoization(arr, 1, ind+1,dp),0+memoization(arr, 0, ind+1,dp));
		}
		
		return dp[ind][buy] = profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {7,1,5,3,6,4};
		int ind = 0;
		int buy = 1;
		
		int dp[][] = new int[arr.length][arr.length];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(memoization(arr, buy, ind,dp));

	}

}
