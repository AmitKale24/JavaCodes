package KnapsackProblem;
import java.util.*;

//TOP BOTTOM APPROACH

public class MaxProfit {
	static int n,w;
	static int[][] t = new int[n+1][w+1];
	public static int maxProfit(int wt[], int val[],int[][] t, int n, int w) {
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;  //First row and first column is 0
				}
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(wt[i-1]<=j) { //wt = arr
					t[i][j]= Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
			    }
				else {
					  t[i][j]=t[i-1][j];  
				}
			}
		}
		
		return t[n][w];
		
        
		
	
		
	}
	
	public static void main(String[] args) {
		
		int wt[] = {1,3,4,6};
		int val[] = {20,30,10,50};
		int n = wt.length;
		int w=10;
		int[][] t = new int[n+1][w+1];
		
		System.out.println(maxProfit(wt, val,t, n, w));
		
	
	}

}