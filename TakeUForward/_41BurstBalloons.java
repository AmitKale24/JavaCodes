package TakeUForward;
import java.util.*;
public class _41BurstBalloons {
	
	public static int recursion(int arr[],int i,int j) {
		if(i>j) return 0;
		int max = Integer.MIN_VALUE;
		
		for(int k = i;k<=j;k++) {
			int cost = arr[i-1]*arr[k]*arr[j+1] + recursion(arr, i, k-1) + recursion(arr, k+1, j);
			max = Math.max(max, cost);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[] = {1, 2 ,3 ,4, 5};
        int arr2[] = new int[arr.length+2];
        arr2[0] = 1;
        for(int i=1;i<=arr.length;i++) {
        	arr2[i] = arr[i-1];
        }
        arr2[arr2.length-1] = 1;
        
        System.out.println(recursion(arr2, 1, arr.length));
	}

}
