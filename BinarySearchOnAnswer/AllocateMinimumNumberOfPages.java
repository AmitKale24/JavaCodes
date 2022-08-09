package BinarySearchOnAnswer;

public class AllocateMinimumNumberOfPages {
	
	public static int solve(int arr[],int key) {
		int start=0,end=0;
		for(int i=0;i<arr.length;i++) {
			start = Math.max(start, arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			end = end+arr[i];
		}
		
		int res = -1;
		
		if(arr.length<key) {
			return -1;
		}
		else {
			while(start<=end) {
				int mid = start+((end-start)/2);
				if(isValid(arr,key,mid) == true) {
					res = mid;
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}
			return res;
		}
	}

	public static boolean isValid(int[] arr,int key,int max) {
		int student=1;
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum = sum+arr[i];
			if(sum>max) {
				student++;
				sum = arr[i];
			}
		}
		
		if(student>key) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,20,30,40};
		int key = 2;
		System.out.println(solve(arr, key));

	}

}
