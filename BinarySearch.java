
public class BinarySearch {
	
	public static void solve(int arr[],int search,int start,int end) {
		int mid = start+((end-start)/2);//To Avoid Integer Overflow
		
		if(search == arr[mid]) {
			System.out.println(mid);
		}
		
		else if(search>arr[mid]) {
			solve(arr,search,mid+1,end);
		}
		
		else if(search<arr[mid]) {
			solve(arr,search,start,mid-1);
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {10,20,40,56,78,89,90};
		int search = 40;
		
		//System.out.println(solve(arr, search, 0, arr.length-1));
		solve(arr, search, 0, arr.length-1);

	}

}
