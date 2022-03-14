package PalindromePartitioning;

public class PartitionCode {
	
	static boolean isPalindrome(String str, int i, int j)
	  {
	    while(i < j)
	    {
	      if(str.charAt(i) != str.charAt(j))
	        return false; 
	      i++;
	      j--;
	    }
	    return true;
	  }
	
	public static int solve(String str,int i,int j) {
		if(i>=j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		
		if(isPalindrome(str, i, j)) {
			return 0;
		}
		
		for(int k=i;k<j;k++) {
			int temp = solve(str, i, k)+solve(str,k+1,j)+1;
			
			if(temp<min) {
				min  = temp;
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "NITIN";
		
		System.out.println(solve(str, 0, str.length()-1));

	}

}
