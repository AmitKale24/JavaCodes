package BinarySearchOnAnswer;

import java.util.*;

public class SearchInSorted2DMatrix {
	
	public static ArrayList<Integer> solve(int arr[][],int search) {
		int i=0;
		int j=arr.length-1;
		
		ArrayList<Integer> ans = new ArrayList<>();
		
		while(i>=0 && i< arr.length && j>=0 && j<arr.length) {
			if(arr[i][j] == search) {
				ans.add(i);
				ans.add(j);
				return ans;
			}
			else if(arr[i][j]>search) {
				j--;
			}
			else if(arr[i][j]<search) {
				i++;
			}
		}
		if(ans.isEmpty()) {
			ans.add(-1);
			return ans;
		}
		else {
			return solve(arr, search);
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,45},{32,33,39,50}};
        int search = 29;
        //System.out.println(arr[0][arr.length-1]);
        
        System.out.println(solve(arr, search));
	}

}
