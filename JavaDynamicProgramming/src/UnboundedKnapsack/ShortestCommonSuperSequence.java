package UnboundedKnapsack;

public class ShortestCommonSuperSequence {
	
	public static int scss(char[]a,char[]b,int m,int n) {
		
		return m+n+lcs(a, b, m, n);
	}
	
	public static int lcs(char[]a,char[]b,int m,int n) {
		int[][] t = new int[m+1][n+1];
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(a[i-1]==b[j-1]) {
					t[i][j] = t[i-1][j-1];
				}
				else {
					t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
				}
			}
		}
		
		return t[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		char[]a = s1.toCharArray();
		char[]b = s2.toCharArray();
		
		int m = a.length;
		int n = b.length;
		
		System.out.println("Length of Shortest SuperSequence is "+scss(a, b, m, n));

	}

}
