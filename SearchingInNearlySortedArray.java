
public class SearchingInNearlySortedArray {
	
	public static int solve(int arr[],int search,int start,int end) {
		int mid = 0;
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] == search) {
				break;
			}
			else if(mid>=start && arr[mid-1] == search) {
				break;
			}
			else if(mid<=end && arr[mid+1]==search) {
				break;
			}
			else if(arr[mid]>search) {
				end = mid-2;
			}
			else if(arr[mid]<search) {
				start = mid+2;
			}
		}
		
		return mid;
	}

	public static void main(String[] args) {
		
		int arr[] = {5,10,30,20,40,60,50,70,80,130,120,140,130};
		int search = 50;
		int start = 0;
		int end = arr.length-1;
		System.out.println(solve(arr, search, start, end));
		

	}

}
