
public class CeilOfElementInSortedArray {
	
	public static int solve(int arr[],int ele,int start,int end) {
		int mid = 0;
		int res=0;
		
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] == ele) {
				res = arr[mid];
				break;
			}
			else if(arr[mid]<ele) {
				start = mid+1;
			}
			else if(arr[mid]>ele) {
				res = arr[mid];
				end = mid-1;
			}
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,7,8,9};
		int ele = 6;
		int start = 0;
		int end = arr.length-1;
		System.out.println(solve(arr, ele, start, end));

	}

}
