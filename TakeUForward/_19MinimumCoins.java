package TakeUForward;

import java.util.Arrays;

public class _19MinimumCoins {
	
	 public static int recursion(int[] arr,int ind,int target){
	        if(ind == 0 ){
	            if(target%arr[ind] == 0) return target/arr[ind]; //If target=8 , arr[ind] = 2 then total 4 coins are needed i.e. target/arr[ind] = 4
	            else return (int)Math.pow(10,9);
	        }
	        int notTake = 0 + recursion(arr,ind-1,target);
	        int take = Integer.MAX_VALUE;
	        if(target>=arr[ind]){
	            take = 1 + recursion(arr,ind,target-arr[ind]);
	        }
	        
	        return Math.min(notTake, take);
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
        
	}

}
