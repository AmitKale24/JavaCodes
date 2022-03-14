
public class ScrambledStringMCN {
	
	static boolean solve(String a, String b) {
		
		int n = a.length();
		
		if(a.compareTo(b)==0) {
			return true;
		}
		if(a.isEmpty()&&b.isEmpty()) {
			return true;
		}
		
		if(a.length()!=b.length()) {
			return false;
		}
		if(a.length()<=1) {
			return false;
		}
		
		boolean flag =false;
		
		for(int i=1;i<n;i++) {
			if((solve(a.substring(0, i),b.substring(n-i,n)) && solve(a.substring(i,n),b.substring(0,n-i))) || (solve(a.substring(0,i),b.substring(0,i))&& solve(a.substring(i,n),b.substring(i,n)))){
				flag = true;
				break;
			}
			
//			if(solve(a.substring(0,i),b.substring(n-i,n)) && solve(a.substring(i,n-i),b.substring(0,n-i))) {
//				return true;
//			}
//			
//			
//			if(solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i,n),b.substring(i,n))) {
//				return true;
//			}
			
		}
		
		return flag;
		
	}

	public static void main(String[] args) {
		
		
		String a = "great";
		String b = "rgeat";
		
		System.out.println(solve(a, b));

	}

}
