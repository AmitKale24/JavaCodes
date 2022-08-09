package BinarySearchOnAnswer;

public class SearchInBitonicArray {
	
	public static int peakElementIndex(int arr[],int start,int end) {
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
		
		return peakElementIndex(arr, start, end);
	}
	
	public static int binarySearchSortedArray(int arr[],int search) {
		int mid=-1;
		int start=0;
		int end = peakElementIndex(arr,0,arr.length-1)-1;
		while(start<=mid) {
			mid = start + ((end-start)/2);
			if(arr[mid] == search) {
				break;
			}
			else if(arr[mid]>search) {
				end = mid-1;
			}
			else if(arr[mid]<search) {
				start = mid+1;
			}
		}
		
		return mid;
	}
	
	public static int binarySearchReverseSortedArray(int arr[],int search) {
		int mid=-1;
		int start = peakElementIndex(arr, 0, arr.length-1);
		int end = arr.length-1;
		while(start<=end) {
			mid = start + ((end-start)/2);
			if(arr[mid] == search) {
				break;
			}
			else if(arr[mid]<search) {
				end = mid-1;
			}
			else if(arr[mid]>search) {
				start = mid+1;
			}
		}
		
		return mid;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,8,14,6,5};
		int search = 6;
		int start = 0;
		int end = arr.length-1;
		//System.out.println(peakElementIndex(arr, start, end));
		
		if(binarySearchReverseSortedArray(arr, search) == -1 && binarySearchSortedArray(arr, search)==-1) {
			System.out.println("Invalid Choice!!!");
		}
		else if(binarySearchReverseSortedArray(arr, search)==-1) {
			System.out.println(binarySearchSortedArray(arr, search));
		}
		else if(binarySearchSortedArray(arr, search)==-1) {
			System.out.println(binarySearchReverseSortedArray(arr, search));
		}
	

	}

}
