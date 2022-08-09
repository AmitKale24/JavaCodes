package TakeUForward;

public class _27LongestPalindomicSubsequence {
	
	public static int tabulation(String s1,String s2) {
		int n = s1.length();
		int m = s2.length();
		
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++) {
			for(int j = 0;j<=m;j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
				}
			}
		}
		
		for(int i = 1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "mbadm";
		String s2 = "";
		for(int i=s1.length()-1;i>=0;i--) {
			s2+=s1.charAt(i);
		}
		System.out.println(tabulation(s1, s2));
		

	}

}
