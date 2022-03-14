package LongestCommonSubSequence;

public class printSCS {
	
public static StringBuilder printSCS(StringBuilder a, StringBuilder b,int m,int n) {
		
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
		
		int i = m;
		int j = n;
		StringBuilder s = new StringBuilder();
		
		while(i==0 || j==0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				s.append(a.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(t[i][j-1]>t[i-1][j]) {
					s.append(a.charAt(i-1));
					j--;
				}
				else {
					s.append(b.charAt(j-1));
					i--;
				}
			}
		}
		
		
		return s.reverse();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		
		a.append("ACBCF");
		b.append("ABCDAF");
		
		int m = a.length();
		int n = b.length();
		
		System.out.println(printSCS(a, b, m, n));

	}

}
