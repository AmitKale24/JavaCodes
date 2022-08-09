import java.util.*;
import java.util.ArrayList;
public class FloorOfElementInSortedArray {
	
	//Method 1
	public static int solve(int arr[],int ele) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<ele) {
				max = Math.max(max, arr[i]);
			}
		}
		return max;
	}
	
	//Method 2
	public static int binarySearching(int arr[],int ele,int start,int end) {
		int mid=0,res=0;
		
		while(start<=end) {
			mid = start+((end-start)/2);
			if(arr[mid] == ele) {
				res = arr[mid];
				break;
			}
			else if(arr[mid]>ele) {
				end = mid-1;
			}
			else if(arr[mid]<ele) {
				res = arr[mid];
				start = mid+1;
			}
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,8,10};
		int ele=5;
		System.out.println(solve(arr, ele));
		System.out.println(binarySearching(arr, ele, 0, arr.length-1));

	}

}
