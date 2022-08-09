package TakeUForward;

public class _42BalanceParenthesis {
	static int mod = 1000000007;
	public static int recursion(String str,int i,int j,int isTrue) {
		if(i>j) return 0;
		if(i == j) {
			if(isTrue == 1) return str.charAt(i) == 'T'?1:0;
			else return str.charAt(i) == 'F'?1:0;
		}
		
		int ways = 0;
		
		for(int k = i+1;k<j;k+=2) {
			int lT = recursion(str, i, k-1, 1);
			int lF = recursion(str, i, k-1, 0);
			int rT = recursion(str, k+1, j, 1);
			int rF = recursion(str, k+1, j, 0);
			
			if(str.charAt(k) == '&') {
				if(isTrue == 1) ways = (ways + (lT*rT)%mod)%mod;
				else ways = (ways + (lT*rF)%mod + (lF*rT)%mod + (lF*rF)%mod)%mod;
			}
			else if(str.charAt(k) == '|') {
				if(isTrue == 1) ways = (ways + (lT*rF)%mod + (lF*rT)%mod + (lT*rT)%mod)%mod ;
				else ways = (ways + (lF*rF)%mod)%mod;
			}
			else {
				if(isTrue == 1) ways = (ways + (lT*rF)%mod + (lF*rT)%mod )%mod ;
				else ways = (ways + (lF*rF)%mod + (lT*rT)%mod)%mod;
			}
		}
		
		return ways;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "F|T^F";
		System.out.println(recursion(str, 0, str.length()-1, 1));

	}

}
