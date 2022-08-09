
public class NoOfTimesSortedArrayRotated {
	
	
	
	public static int solve(int arr[],int start,int end) {
		
		
		
		if(arr[start]<arr[end]) {
			return 0;
		}
		else {
			while(start<=end) {
				int N = arr.length;
				int mid = start+((end-start)/2);
				int prev = (mid+N-1)%N;
				int next = (mid+1)%N;
				
				if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]) {
					return arr.length-mid;
				}
				
				if(arr[mid]>=arr[start]) {
					start = mid+1;
				}
				else if(arr[mid]<=arr[start]) {
					end = mid-1;
				}
			}
			
			return solve(arr, start, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,1,2,3,4,5,6,7};
		System.out.println(solve(arr, 0, arr.length-1));
		
		


	}

}
