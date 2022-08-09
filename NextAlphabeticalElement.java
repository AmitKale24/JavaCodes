
public class NextAlphabeticalElement {
	
	public static char solve(String str,char ip,int start,int end) {
		char res='%';
		int mid = 0;
		
		while(start<=end) {
			mid = start+((end-start)/2);
			if(str.charAt(mid)==ip) {
				start = mid+1;
			}
			else if(str.charAt(mid)<ip) {
				start = mid+1;
			}
			else if(str.charAt(mid)>ip) {
				res = str.charAt(mid);
				end = mid-1;
			}
		}
		
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "acfh";
		char ip='f';
        int start = 0;
        int end = str.length()-1;
        System.out.println(solve(str, ip, start, end));
	}

}
