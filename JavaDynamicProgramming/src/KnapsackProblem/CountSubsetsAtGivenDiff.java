package KnapsackProblem;

public class CountSubsetsAtGivenDiff {
	
	public static int countOfSubset(int arr[],int n,int sum) {
		if(arr.length==0) {
			return 0;
		}
		
		int[][] t = new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0) {
					t[i][j] = 0;
				}
				if(j==0) {
					t[i][j] = 1;
				}
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j){
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][sum];
	}
	
	public static int countAtDiff(int arr[],int diff) {
		int sumOfArray=0;
		for(int i=0;i<arr.length;i++) {
			sumOfArray+=arr[i];
		}
		int sumOfFirstSubset = (diff+sumOfArray)/2;
		
		int count = countOfSubset(arr, arr.length,sumOfFirstSubset);
		
		return count;
	}

	public static void main(String[] args) {
		
		int arr[] = {1,1,2,3};
		System.out.println(countAtDiff(arr, 1));

	}

}
