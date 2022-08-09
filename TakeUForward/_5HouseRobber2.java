package TakeUForward;

import java.util.*;

public class _5HouseRobber2 {
	
	public static int tabulation(int n,int dp[],ArrayList<Integer> arr) {
        dp[0] = arr.get(0);
		
		for(int i=1;i<=n;i++) {
			int take = arr.get(i);
			if(i>1) {
				take += dp[i-2];
			}
			int notTake = 0+dp[i-1];
			dp[i] = Math.max(take, notTake);
		}
		
		return dp[n];
	}
	
	public static int solve(int n,int dp[],ArrayList<Integer> arr) {
		ArrayList<Integer> temp1 = new ArrayList<>();
		ArrayList<Integer> temp2 = new ArrayList<>();
		
		for(int i=0;i<arr.size();i++) {
			if(i!=0)temp1.add(arr.get(i));
			if(i!=arr.size()-1) temp2.add(arr.get(i));
		}
		
		int ans1 = tabulation(n, dp, temp1);
		int ans2 = tabulation(n, dp, temp2);
		
		return Math.max(ans1, ans2);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(8);
		arr.add(2);
		int n = arr.size();
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(solve(n-1, dp, arr));

	}

}
