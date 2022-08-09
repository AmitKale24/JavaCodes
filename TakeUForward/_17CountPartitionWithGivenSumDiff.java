package TakeUForward;

import java.util.Arrays;

public class _17CountPartitionWithGivenSumDiff {
	static int mod = (int) Math.pow(10, 9);
	
	public static int optimization(int arr[],int ind,int target,int dp[][]) {
		
		if(ind == 0) {
			if(target == 0 && arr[ind] ==0 ) return 2;
			if(target ==0) return 1;
			if(target == arr[ind]) return 1;
			return 0;
		}
		
		if(dp[ind][target]!=-1)return dp[ind][target];
		
		int notTake = optimization(arr, ind-1, target, dp);
		int take = 0;
		if(target>=arr[ind]) {
			take = optimization(arr, ind-1, target-arr[ind], dp);
		}
		
		return dp[ind][target] = (take+notTake)%mod;
		
	}
	
	public static int solve(int arr[],int diff,int dp[][]) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		
		if(sum-diff < 0 || (sum-diff)%2 ==0) return 0;
		
		int s2 = (sum-diff)/2;
		
		int ans = optimization(arr, arr.length-1, s2, dp);
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,2,2,3};
		 int diff = 3;
		
		int dp[][] = new int[arr.length][diff+1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(solve(arr, diff, dp));

	}

}
