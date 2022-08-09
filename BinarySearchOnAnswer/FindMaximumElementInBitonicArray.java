package BinarySearchOnAnswer;

public class FindMaximumElementInBitonicArray {
	
	//Code: 100% Same As Peak Element
	//Bitonic Array=>Value increasing to some value and then decreasing=>[1,2,3,4,8,14,6,5] => Only one maximum value in Bitonic Array
	
	public static int peakElement(int arr[],int start,int end) {
		
		while(start<=end) {
			int mid = start+((end-start)/2);
			if(mid>0 && mid<arr.length-1) {
				if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
					return arr[mid];
				}
				else if(arr[mid-1]>arr[mid]) {
					end = mid-1;
				}
				else if(arr[mid+1]>arr[mid]) {
					start = mid+1;
				}
			}
			
			else if(mid == 0) {
				if(arr[mid]>arr[mid+1]) {
					return arr[mid];
				}
				else {
					return arr[mid+1];
				}
			}
			else if(mid == arr.length-1) {
				if(arr[mid]>arr[mid-1]) {
					return arr[mid];
				}
				else {
					return arr[mid-1];
				}
			}
		}
		
		return peakElement(arr, start, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,8,14,6,5};
		int start = 0;
		int end = arr.length-1;
		
		System.out.println(peakElement(arr, start, end));

	}

}
