package TakeUForward;

import java.util.Arrays;

public class _16NumberOfSubsets {
	
	//For the array having elements greater than 0 i.e. 1 to n
	 public static int memoization(int arr[],int ind,int target,int dp[][]) {
			if(target == 0) return 1;
			if(ind == 0) return arr[ind] == target?1:0;
			
			if(dp[ind][target]!=-1)return dp[ind][target];
			
			int notTake = memoization(arr, ind-1, target, dp);
			int take = 0;
			if(target>=arr[ind]) {
				take = memoization(arr, ind-1, target-arr[ind], dp);
			}
			
			return dp[ind][target] = take+notTake;
			
		}
     
	 //For the array having elements from 0 to n
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
			
			return dp[ind][target] = take+notTake;
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,3};
		int ind = arr.length;
		int target = 3;
		
		int dp[][] = new int[ind][target+1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(memoization(arr, ind-1, target, dp));
		System.out.println(optimization(arr, ind-1, target, dp));
		

	}

}
