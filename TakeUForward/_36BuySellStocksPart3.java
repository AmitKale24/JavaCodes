package TakeUForward;

public class _36BuySellStocksPart3 {
	
	public static int recursion(int arr[],int n,int ind,int buy,int cap) {
		if(cap == 0) return 0;
		if(ind == n) return 0;
		
		int profit = 0;
		if(buy == 1) {
			profit = Math.max(profit-arr[ind]+recursion(arr, n, ind+1, 0, cap), 0+recursion(arr, n, ind+1, 1, cap));
		}
		else {
			profit = Math.max(arr[ind]+recursion(arr, n, ind+1, 1, cap-1), 0+recursion(arr, n, ind+1, 0, cap));
		}
		
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,1,2,5,6};
		int n = arr.length;
		int ind = 0;
		int buy = 1;
		int cap = 4;
		System.out.println(recursion(arr, n, ind, buy, cap));

	}

}
