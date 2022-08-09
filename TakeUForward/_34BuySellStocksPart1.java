package TakeUForward;
import java.util.*;
public class _34BuySellStocksPart1 {
	
	
	
	public static int solve(int arr[],int n) {
		int mini = arr[0];
		int profit = 0;
		
		for(int i = 1;i<n;i++) {
			int cost = arr[i]-mini;
			profit = Math.max(profit, cost);
			mini = Math.min(mini, arr[i]);
		}
		
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,1,5,3,6,4};
		System.out.println(solve(arr, arr.length));

	}

}
