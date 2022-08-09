package TakeUForward;

import java.util.Arrays;

public class _21CoinChange2 {
	
	public static int recursion(int[] arr,int ind,int target){
        if(ind ==0 ){
            return target%arr[ind]==0?1:0;
        }
        
        int notTake =recursion(arr,ind-1,target);
        int take = 0;
        if(target>=arr[ind]){
            take =recursion(arr,ind,target-arr[ind]);
        }
        
        return take+notTake;
    }
	
	public static int memoization(int[] arr,int ind,int target,int[][] dp){
        if(ind ==0 ){
            return target%arr[ind]==0?1:0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        
        int notTake =recursion(arr,ind-1,target);
        int take = 0;
        if(target>=arr[ind]){
            take =recursion(arr,ind,target-arr[ind]);
        }
        
        return dp[ind][target] = take+notTake;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3,5,6,7};
        int target = 9;
        
        int dp[][] = new int[arr.length][target+1];
		
  		for(int[] row : dp) {
  			Arrays.fill(row, -1);
  		}
  		
  		System.out.println(recursion(arr, arr.length-1, target));
  		System.out.println(memoization(arr, arr.length-1, target, dp));

	}

}
