
public class FirstAndLastOccurence {
	
	public static int firstOccurence(int arr[],int search,int start,int end) {
		
		int res=-1;
		
		while(start<=end) {
			int mid = start+((end-start)/2);
			if(arr[mid]==search) {
				res=mid;
				end = mid-1;
			}
			else if(arr[mid]<search) {
				start=mid+1;
			}
			else if(arr[mid]>search) {
				end = mid-1;
			}
		}
		
		return res;
	}
	
	public static int lastOccurence(int arr[],int search,int start,int end) {
			
			int res=-1;
			
			while(start<=end) {
				int mid = start+((end-start)/2);
				if(arr[mid]==search) {
					res=mid;
					start = mid+1;
				}
				else if(arr[mid]<search) {
					start=mid+1;
				}
				else if(arr[mid]>search) {
					end = mid-1;
				}
			}
			
			return res;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,10,10,10,14,15,16};
		int search=10;
		System.out.println(firstOccurence(arr, search, 0, arr.length-1));
		System.out.println(lastOccurence(arr, search, 0, arr.length-1));

	}

}
