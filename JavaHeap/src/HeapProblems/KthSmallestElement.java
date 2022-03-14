package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {
	
	public static int heap(int arr[],int K) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			maxHeap.add(arr[i]);
			if(maxHeap.size()>K) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int K = sc.nextInt();
		
		System.out.println(heap(arr, K));

	}

}
