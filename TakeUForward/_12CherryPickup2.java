package TakeUForward;
import java.util.*;
public class _12CherryPickup2 {
	
	public static int memoization(int[][] points,int[][][] dp,int i,int j1,int j2) {
		
		if(j1<0 || j1>=points[0].length || j2<0 || j2>=points[0].length) {
			return (int) Math.pow(-10, 9);
		}
		if(i == points.length-1) {
			if(j1 == j2) return points[i][j1];
			else {
				return points[i][j1]+points[i][j2];
			}
		}
		
		if(dp[i][j1][j2]!=-1) {
			return dp[i][j1][j2];
		}
		
		int maxi = (int) Math.pow(-10, 9);
		//This is How We Explore All The Paths if Two Persons Are in Grid And Move Simultaneously
		for(int dj1=-1;dj1<=1;dj1++) {
			for(int dj2 = -1;dj2<=1;dj2++) {
				int value = 0;
				if(j1 == j2) value = points[i][j1];
				else {
					value = points[i][j1]+points[i][j2];
				}
				value += memoization(points, dp, i+1, j1 + dj1, j2 + dj2);
				maxi = Math.max(maxi, value);
			}
		}
		
		return dp[i][j1][j2] = maxi;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int points[][] = {{2,3,1,2},
                {3,4,2,2},
                {5,6,3,5}};
		
		int i = 0,j1=0,j2 = points[0].length;
		
		int dp[][][] = new int[points.length][j2][j2];
		
		for (int row1[][]: dp) {
		      for (int row2[]: row1) {
		        Arrays.fill(row2, -1);
		      }
		}
		
		System.out.println(memoization(points, dp, i, j1, j2-1));

	}

}
