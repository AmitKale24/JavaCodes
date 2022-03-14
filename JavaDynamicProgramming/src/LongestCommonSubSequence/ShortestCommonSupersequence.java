package LongestCommonSubSequence;

public class ShortestCommonSupersequence {
	
public static int SCS(StringBuilder a, StringBuilder b,int m,int n) {
		
		int[][] t = new int[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(m==0 || n==0) {
					t[i][j] = 0;
				}
				
			}
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}
				else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		return m+n-t[m][n];
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		
		a.append("GEEK");
		b.append("EKE");
		
		int m = a.length();
		int n = b.length();
		
		System.out.println(SCS(a, b, m, n));

	}

}
