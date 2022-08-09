
public class FindNoInRotatedSortedArray {
	
	
	
	public static int minValueIndex(int arr[],int search) {
		int start=0;
		int end = arr.length-1;
		int mid = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			min = Math.min(min, arr[i]);
		}
		
		while(start<=end) {
			mid = start+((end-start)/2);
			
			if(arr[mid] == min) {
				break;
			}
			
			else if(arr[mid]<arr[mid+1]) {
				start = mid+1;
			}
			else if(arr[mid]>arr[mid+1]) {
				mid = mid+1;
				break;
			}
		    
		}
		
		return mid;
	}
	
	public static int binarySearch1(int arr[],int search) {
		int index = minValueIndex(arr, search);
		int mid = 0;
		int start=index;
		int end = arr.length-1;
		
		if(arr[end]>search) {
			while(start<=end) {
				mid = start+((end-start)/2);
				if(arr[mid]==search) {
					break;
				}
				else if(arr[mid]<search) {
					start = mid+1;
				}
				else if(arr[mid]>search) {
					end = mid-1;
				}
			}
			return mid;
		}
		else {
			return -1;
		}
		
	}
	
	public static int binarySearch2(int arr[],int search) {
		int index = minValueIndex(arr, search);
		int mid = 0;
		int start=0;
		int end = index-1;
		
		if(arr[arr.length-1]<search) {
			while(start<=end) {
				mid = start+((end-start)/2);
				if(arr[mid]==search) {
					break;
				}
				else if(arr[mid]<search) {
					start = mid+1;
				}
				else if(arr[mid]>search) {
					end = mid-1;
				}
			}
			return mid;
		}
		else {
			return -1;
		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {14,2,3,4,5,6,7,8};
		int search = 3;
		
		if(binarySearch1(arr, search) == -1 && binarySearch2(arr, search) == -1) {
			System.out.println("Invalid Choice!!!!!");
		}
		else if(binarySearch1(arr, search) == -1 || binarySearch2(arr, search) == -1) {
			if(binarySearch1(arr, search)>-1) {
				System.out.println("Number is Found in Index: "+binarySearch1(arr, search));
			}
			else if(binarySearch2(arr, search)>-1) {
				System.out.println("Number is Found in Index: "+binarySearch2(arr, search));
			}
			
		}

	}

}
