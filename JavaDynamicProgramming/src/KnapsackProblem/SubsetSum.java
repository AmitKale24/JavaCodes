package KnapsackProblem;

import java.util.*;

//TOP BOTTOM APPROACH

public class SubsetSum {

	
	public static boolean subsetSum(int arr[] , int n, int sum) {
		
		boolean[][] t = new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0) {
					t[i][j] = false;
				}
				
				if(j==0) {
					t[i][j] = true;
				}
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j]  ;
			    }
				else {
					  t[i][j]=t[i-1][j];
					  
				}
			}
		}
		
		return t[n][sum];
		
        
		
	
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {2,3,7,9,10};
		

		
		System.out.println(subsetSum(arr,arr.length, 12));
		
	
	}

}
