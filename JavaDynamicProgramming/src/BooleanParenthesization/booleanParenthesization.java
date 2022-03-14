package BooleanParenthesization;

public class booleanParenthesization {
	
	public static int solve(String s, int i, int j, boolean isTrue) {
		int ans = 0;
		if(i>j)return 0;
		if(i==j) {
			if(isTrue == true) {
				 return (s.charAt(i) == 'T') ? 1 : 0;
			}
			else {
				 return (s.charAt(i) == 'F') ? 1: 0;
			}
		}
		
		
		for(int k = i+1; k<j; k=k+2) {
			int lt = solve(s, i, k-1, true);
			int lf = solve(s, i, k-1, false);
			int rt = solve(s, k+1, j, true);
			int rf = solve(s, k+1, j, false);
			
			if(s.charAt(k) == '&') {
				if(isTrue == true) {
					ans = ans + lt*rt;
				}
				else {
					ans = ans + lt*rf + rt*lf + lf*rf;
				}
			}
			
			else if(s.charAt(k) == '|') {
				if(isTrue == true) {
					ans = ans + lt*rt + lf*rt + lt*rf;
				}
				else {
					ans = ans + lf*rf;
				}
			}
			
			else if(s.charAt(k)=='^') {
				if(isTrue == true) {
					ans = ans + lf*rt + lt*rf;
				}
				else {
					ans = ans + lt*rt + lf*rf;
				}
			}
		
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "T|F&T";
		int i=0;
		int j = s.length()-1;
		
		System.out.println(solve(s, i, j, true));
				

	}

}
