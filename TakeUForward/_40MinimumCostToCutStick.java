package TakeUForward;

import java.util.*;

public class _40MinimumCostToCutStick {
	
	public static int solve(ArrayList<Integer> arr,int i,int j){
        if(i>j) return 0;
        int mini = (int)Math.pow(10,9);
        for(int ind = i;ind<=j;ind++){
            int cost = (arr.get(j+1)-arr.get(i-1))+(solve(arr,i,ind-1)+solve(arr,ind+1,j));
            mini = Math.min(cost,mini);
        }
        
        return mini;
    }
    
    public static int cost(int n, int c, int cuts[]) {
       
    	ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i=1;i<=cuts.length;i++) {
        	arr.add(cuts[i-1]);
        }
    	arr.add(c);
        int ans = solve(arr,1,cuts.length);
        return ans;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1 ,3};
		int n = arr.length;
		int c = 10;
		System.out.println(cost(n, c, arr));
		

	}

}
