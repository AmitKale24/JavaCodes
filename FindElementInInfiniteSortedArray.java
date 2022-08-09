
public class FindElementInInfiniteSortedArray {
	
	public static int solve(int arr[],int search) {
		int start=0;
		int end=1;
		int mid=0;
		
		
		while(arr[end]<search) {
			start = end;
			end = end*2;
		}
		
		
		while(start<=end) {
			mid = start+((end-start)/2);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
		int search=10;
		System.out.println(solve(arr, search));

	}

}
