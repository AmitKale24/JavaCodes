package LongestCommonSubSequence;

public class printLCS {
	
	public static StringBuilder printLCS(char[]a,char[]b,int m,int n) {
		
		int[][] t = new int[m+1][n+1];
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(m==0||n==0) {
					t[i][j] = 0;
				}
			}
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(a[i-1]==b[j-1]) {
					t[i][j] = 1+t[i-1][j-1];
				}
				else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		int i=m , j=n;
		StringBuilder str = new StringBuilder();
		
		while(i>0 || j>0) {
			if(a[i-1] == b[j-1]) {
				str.append(a[i-1]);
				i--;
				j--;
			}
			else {
				if(t[i][j-1]>t[i-1][j]) {
					j--;
				}
				else {
					i--;
				}
			}
		}
		
		str.reverse();
		return str;
	}

	public static void main(String[] args) {
		
		String s1 = "ACBCF";
	    String s2 = "ABCDAF";
	 
	    char[] a=s1.toCharArray();
	    char[] b=s2.toCharArray();
	    int m = a.length;
	    int n = b.length;
	    
	    System.out.println(printLCS(a, b, m, n));

	}

}
