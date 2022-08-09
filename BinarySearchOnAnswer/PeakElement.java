package BinarySearchOnAnswer;

public class PeakElement {
	
	public static int solve(int arr[],int start,int end) {
		
		
		while(start<=end) {
			int mid = start+((end-start)/2);
			
			if(mid>0 && mid<arr.length-1) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
					return mid;
				}
				else if(arr[mid-1]>arr[mid]) {
					end = mid-1;
				}
				else if(arr[mid+1]>arr[mid]) {
					start = mid+1;
				}
			}
			else if(mid == 0) {
				if(arr[0]>arr[1]) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else if(mid == arr.length-1) {
				if(arr[arr.length-1]>arr[arr.length-2]) {
					return arr.length-1;
				}
				else {
					return arr.length-2;
				}
			}
		}
		
		return solve(arr, start, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5,10,20,15};
		System.out.println(solve(arr, 0, arr.length-1));

	}

}
