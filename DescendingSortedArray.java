
public class DescendingSortedArray {
	
	public static void solve(int arr[],int search,int start,int end) {
		int mid = start+((end-start)/2);//To Avoid Integer Overflow
		
		if(search == arr[mid]) {
			System.out.println(mid);
		}
		
		else if(search<arr[mid]) {
			solve(arr,search,mid+1,end);
		}
		
		else if(search>arr[mid]) {
			solve(arr,search,start,mid-1);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {90,80,70,60,50,40,30,20,10};
		int search = 60;
		//System.out.println(solve(arr, search, 0, arr.length-1));
		solve(arr, search, 0, arr.length-1);

	}

}
