package TakeUForward;

import java.util.Arrays;

public class _14EqualPartitionSubsetSum {
	public static boolean subsetSumOfTarget(int arr[],int index,int target,int dp[][]) {
		if(target == 0) return true;
		if(index == 0) return arr[0] == target;
		
		if(dp[index][target]!=-1) {
			return dp[index][target] == 0?false:true;
		}
		
		boolean notTake = subsetSumOfTarget(arr, index-1, target, dp) ;
		boolean take = false;
		if(target>=arr[index]) {
			take = subsetSumOfTarget(arr, index-1, target-arr[index], dp);
		}
		dp[index][target] = take || notTake ? 1 : 0;
		return take||notTake;
	}
	
	public static boolean equalPartition(int arr[],int index,int dp[][]) {
		int sum = 0;
		for(int i=0;i<index;i++) {
			sum = sum+arr[i];
		}
		
		if(sum%2 != 0) return false;
		
		int target = sum/2;
		
		boolean ans = subsetSumOfTarget(arr, index, target, dp);
		
		if(ans == true) return true;
		else return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		int target = 4;
		int index = arr.length;
		int dp[][] = new int[index][target+1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
        }
		
		System.out.println(equalPartition(arr, index-1, dp));
		

	}

}
