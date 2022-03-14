package KnapsackProblem;


public class MinimumSubsetSumDifference {
	



	public static int subsetSum(int arr[],int n) {
		
		int range = 0;
		for(int i=0;i<arr.length;i++){
			range+=arr[i];
		}
		
		
		boolean [][] t = new boolean [n+1][range+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<range+1;j++) {
				if(i==0) {
					t[i][j] = false;
				}
				if(j==0) {
					t[i][j] = true;
				}
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<range+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j]  ;
			    }
				else {
					  t[i][j]=t[i-1][j];
					  
				}
			}
		}
		
		int mn = Integer.MAX_VALUE;
		
		for(int j=range/2; j>=0; j--) {
			if(t[n][j]==true) {
				mn = range-2*j;
				break;
			}
		}
		
		
		return mn;
	}
	
	

	public static void main(String[] args) {
		int arr[] = {1,2,7};
		
		int n = arr.length;
		
		System.out.println(subsetSum(arr,n));
		
		

	}

}
