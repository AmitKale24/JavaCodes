package TakeUForward;

import java.util.Arrays;

public class _37BuySellStocksPart4 {
	
	public static int memoization(int arr[],int buy,int ind,int[][] dp,int fees) {
		if(ind == arr.length) return 0;
		if(dp[ind][buy] != -1) return dp[ind][buy];
		int profit = 0;
		
		//If buy
		if(buy==1) {
			//max(Buy , Not Buy)
			//-arr[ind] because if we buy stock then profit = profit-arr[ind]
			profit = Math.max(-arr[ind]+memoization(arr, 0, ind+1,dp,fees),0+memoization(arr, 1, ind+1,dp,fees));
		}
		
		//If sell
		else {
			//max(Sell , Not Sell)
			profit = Math.max(arr[ind]-fees+memoization(arr, 1, ind+1,dp,fees),0+memoization(arr, 0, ind+1,dp,fees));
		}
		
		return dp[ind][buy] = profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,1,5,3,6,4};
		int ind = 0;
		int buy = 1;
		int fees = 2;
		int dp[][] = new int[arr.length][arr.length];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(memoization(arr, buy, ind,dp,fees));


	}

}
