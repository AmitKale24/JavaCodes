package TakeUForward;
import java.util.*;
public class _10Triangle {
	
	public static int memoization(int[][] points,int[][] dp, int i,int j) {
		if(dp[i][j]!=-1) return dp[i][j];
		if(i == points.length-1) return points[i][j];
		
		int down = points[i][j]+memoization(points, dp, i+1, j);
		int diagonal = points[i][j] + memoization(points, dp, i+1, j+1);
		
		return dp[i][j] = Math.min(diagonal, down);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points [][] = {{1},
                {2,3},
                {3,6,7},
                {8,9,6,10}};
		
	    int i=0,j=0;
	    
	    int dp[][]=new int[points.length][points.length];
	    
	    for(int row[]: dp) {
	    	 Arrays.fill(row,-1);
	    }
	   
	    
	    System.out.println(memoization(points, dp, i, j));
		

	}

}
