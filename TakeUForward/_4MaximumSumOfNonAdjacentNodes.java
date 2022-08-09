package TakeUForward;
import java.util.*;
public class _4MaximumSumOfNonAdjacentNodes {
	
	public static int memoization(int N , int dp[] , int arr[]) {
		if(N == 0) return arr[0];
		if(N<0) return 0;
		if(dp[N]!=-1) return dp[N];
		
		//Subsequence
		int pick = arr[N] + memoization(N-2, dp, arr);
		int notPick = 0 + memoization(N-1, dp, arr);
		
		return dp[N] = Math.max(pick, notPick);
	}
	
	public static int tabulation(int N , int dp[] , int arr[]) {
		dp[0] = arr[0];
		
		for(int i=1;i<=N;i++) {
			int take = arr[i];
			if(i>1) {
				take += dp[i-2];
			}
			int notTake = 0+dp[i-1];
			dp[i] = Math.max(take, notTake);
		}
		
		return dp[N];
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,3,5,4};
		int N = arr.length;
		int dp[] = new int[N];
		Arrays.fill(dp, -1);
		
		System.out.println(memoization(N-1, dp, arr));
		System.out.println(tabulation(N-1, dp, arr));
	}

}
