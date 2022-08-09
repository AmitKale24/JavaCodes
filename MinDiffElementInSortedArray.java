
public class MinDiffElementInSortedArray {
	
	//Code: Floor Value Of Element In Sorted Array
	
	public static int solve(int arr[],int ele,int start,int end) {
		int mid=0;
		int res=-1;
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] == ele) {
				res=arr[mid];
				break;
			}
			else if(arr[mid]<ele) {
				res = arr[mid];
				start = mid+1;
			}
			else if(arr[mid]>ele) {
				end = mid-1;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,8,10,15};
		int ele = 12;
		int start = 0;
		int end = arr.length-1;
		
		System.out.println(solve(arr, ele, start, end));

	}

}
