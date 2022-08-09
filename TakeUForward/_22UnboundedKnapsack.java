package TakeUForward;
import java.util.*;
public class _22UnboundedKnapsack {
	
	public static int recursion(int wt[],int val[],int W,int ind) {
		if(ind == 0) {
			return ((int)W/wt[ind])*val[ind];
		}
		
		int notTake = val[ind]+recursion(wt, val, W, ind-1);
		int take = 0;
		if(W>=wt[ind]) {
			take = val[ind] + recursion(wt, val, W-wt[ind], ind);
		}
		
		return Math.max(notTake, take);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wt[] = {7, 2 ,4};
		int val[] = {5 ,10 ,20};
		int W = 15;
		
		int ind = wt.length;
		
		System.out.println(recursion(wt, val, W, ind-1));

	}

}
