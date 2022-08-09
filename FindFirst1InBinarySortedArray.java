import java.util.*;
public class FindFirst1InBinarySortedArray {
	
	public static int solve(int arr[]) {
		int start=0,end=1,mid=0;
		
		while(arr[end]<1) {
			start = end;
			end = end*2;
		}
		
		//Code: First Occurence Of Element
		int res=-1;
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] == 1) {
				res = mid;
				end = mid-1;
			}
			else if(arr[mid]<1) {
				start = mid+1;
			}
			else if(arr[mid]>1) {
				end = mid-1;
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(solve(arr));

	}

}
