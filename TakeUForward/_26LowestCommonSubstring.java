package TakeUForward;

public class _26LowestCommonSubstring {
	
	public static int tabulation(String s1, String s2) {
	    int n=s1.length();
	    int m=s2.length();

	    int dp[][]=new int[n+1][m+1];
	    for(int i=0;i<=n;i++){
	        dp[i][0] = 0;
	    }
	    for(int i=0;i<=m;i++){
	        dp[0][i] = 0;
	    }
	    int ans = 0;
	    for(int ind1=1;ind1<=n;ind1++){
	        for(int ind2=1;ind2<=m;ind2++){
	            if(s1.charAt(ind1-1)==s2.charAt(ind2-1)) {
	            	dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
	                ans = Math.max(ans, dp[ind1][ind2]);
	            }    
	            else {
	            	 dp[ind1][ind2] = 0;
	            }
	               
	        }
	    }
	    
	    return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aced";
		String s2 = "ced";
		int ind1 = s1.length();
		int ind2 = s2.length();
		System.out.println(tabulation(s1, s2));

	}

}
