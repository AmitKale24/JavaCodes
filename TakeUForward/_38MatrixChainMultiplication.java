package TakeUForward;

import java.util.Arrays;

public class _38MatrixChainMultiplication {
	
	public static int mcm(int arr[],int i,int j,int[][] dp) {
		if(i>=j) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		int mini = (int)Math.pow(10, 9);
		
		for(int k=i;k<j;k++) {
			int steps = arr[i-1]*arr[k]*arr[j] + mcm(arr, i, k,dp) + mcm(arr, k+1, j,dp);
			//mini = Math.min(mini, steps);
			if(steps<=mini) {
				mini = steps;
			}
		}
		return dp[i][j] = mini;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,30,40,50};
		int dp[][] = new int[arr.length][arr.length];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		System.out.println(mcm(arr, 1, arr.length-1,dp));

	}

}
