package TakeUForward;

import java.util.*;

public class _8GridUniquePaths2 {
	
	public static int mazeObstaclesMemoization(int[][] points,int[][] dp,int i,int j) {
		if(i>=0 && j>=0 && points[i][j]<0) {
			return 0;
		}
		
		if(i==0 && j==0) {
			return 1;
		}
		
		if(i<0 || j<0) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int up = mazeObstaclesMemoization(points, dp, i-1, j);
		int left = mazeObstaclesMemoization(points, dp, i, j-1);
		
		return dp[i][j] = up+left;
	}
	
	public static int mazeObstaclesTabulation(int[][] points,int[][] dp,int i,int j) {
		for(int x=0;x<i;x++) {
			for(int y=0;y<j;y++) {
				if(points[x][y]<0) {
					dp[x][y]=0;
				}
				else if(x==0 && y==0) {
					dp[x][y]=1;
				}
				else if(x<0 || y<0) dp[x][y]=0;
				else {
					int up=0,left=0;
					if(x>0) {
						up = dp[x-1][y];
					}
					if(y>0) {
						left = dp[x][y-1];
					}
					dp[x][y] = up+left;
				}
			}
		}
		
		return dp[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{0,0,0},{0,-1,0},{0,0,0}};
		int i = points.length;
		int j = points.length;
		
		int[][] dp = new int[i][j];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(mazeObstaclesMemoization(points, dp, i-1, j-1));
		System.out.println(mazeObstaclesTabulation(points, dp, i-1, j-1));

	}

}
