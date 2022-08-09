package TakeUForward;

import java.util.*;

public class _6NinjaTraining {
	
	static int memoization(int day, int last, int[][] points, int[][] dp) {

        if (dp[day][last] != -1) return dp[day][last];
        
        if(day<0) return 0;

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    maxi = Math.max(maxi, points[0][i]);
            }
            return dp[day][last] = maxi;
        }
        

        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int activity = points[day][i] + memoization(day - 1, i, points, dp);
                maxi = Math.max(maxi, activity);
            }

        }

        return dp[day][last] = maxi;
    }

    static int ninjaTraining(int n, int[][] points) {

        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);

        return memoization(n - 1, 3, points, dp);
    }
    
    public static int tabulation(int day,int last,int[][] points,int[][] dp) {
    	dp[0][0] = Math.max(points[0][1], points[0][2]);
    	dp[0][1] = Math.max(points[0][0], points[0][2]);
    	dp[0][2] = Math.max(points[0][0], points[0][1]);
    	dp[0][3] = Math.max(points[0][1], Math.max(points[0][0], points[0][2]));
    	
    	for(int i=1;i<day;i++) {
    		for(int j=0;j<4;j++) {
    			dp[i][j] = 0;
    			for(int task = 0;task<3;task++) {
    				if(task!=j) {
    					int point = points[i][task]+dp[i-1][task];
    					dp[i][j] = Math.max(dp[i][j], point);
    				}
    			}
    		}
    	}
    	
    	return dp[day-1][3];
    	
    	
    }

    public static void main(String args[]) {

        int[][] points = {{10,40,70},
                          {20,50,80},
                          {30,60,90}};
        
        int n = points.length;
        
        int dp[][] = new int[n][4];
        for (int[] row: dp)
            Arrays.fill(row, -1);
           

        
        System.out.println(ninjaTraining(n, points));
        System.out.println(tabulation(n, 3, points, dp));
    }

}
