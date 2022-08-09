package TakeUForward;
import java.util.*;
public class _9MinimumPathSum {
	
	public static int memoization(int[][] points,int dp[][],int i,int j) {
		
		if(i==0 && j==0) return points[0][0];
		if(i<0 || j<0) return (int)Math.pow(10,9);
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int up = points[i][j] + memoization(points, dp, i-1, j);
		int left = points[i][j] + memoization(points, dp, i, j-1);
		
		return dp[i][j] = Math.min(up, left);
	}
	
	public static int tabulation(int[][] points,int dp[][],int i,int j) {
		for(int x=0;x<i;x++) {
			for(int y=0;y<j;y++) {
				if(points[x][y]<0) {
					dp[x][y]=0;
				}
				else if(x==0 && y==0) {
					dp[0][0]=points[0][0];
				}
				else if(x<0 || y<0) dp[x][y]=(int)Math.pow(10,9);
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
		int[][] points = {{1}};
		int i = points.length,j = points[0].length;
		int dp[][] = new int[i][j];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(memoization(points, dp, i-1, j-1));
		System.out.println(tabulation(points, dp, i-1, j-1));

	}

}
