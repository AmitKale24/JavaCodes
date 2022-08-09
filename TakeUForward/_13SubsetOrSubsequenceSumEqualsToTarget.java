package TakeUForward;

import java.util.Arrays;

public class _13SubsetOrSubsequenceSumEqualsToTarget {
	
	public static boolean memoization(int arr[],int dp[][],int index,int target) {
		if(target == 0) return true;
		if(index == 0) return arr[0] == target; //Check whether arr[0] is target or not and true ,false accordingly	
		if(dp[index][target]!=-1) {
			return dp[index][target]==0?false:true;
		}
		
		boolean notTake = memoization(arr, dp, index-1, target);
		boolean take = false;
		if(target>=arr[index]) {
			take = memoization(arr, dp, index-1, target-arr[index]);
			
		}
		
		dp[index][target]=notTake||take?1:0;
		
		return notTake || take;
	}
	
//	public static boolean tabulation(int arr[],int n,int target) {
//		boolean dp[][] = new boolean[n][target+1];
//		for(int i=0;i<n;i++) {
//			dp[i][0] = true;
//		}
//		//dp[0][arr[0]] = true;
//		
//		for(int index = 1;index<n;index++) {
//			for(int j = 1;j<=target;j++) {
//				boolean notTake = dp[index-1][j];
//				boolean take = false;
//				if(j>=arr[index]) {
//					take = dp[index-1][j-arr[index]];	
//				}
//				dp[index][j] = take||notTake;
//			}
//		}
//		
//		return dp[n-1][target];
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,6,7,4};
		int target = 4;
		int index = arr.length;
		int dp[][] = new int[index][target+1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
        }
		
		System.out.println(memoization(arr, dp, index-1, target));
		//System.out.println(tabulation(arr, index, target));

	}

}
