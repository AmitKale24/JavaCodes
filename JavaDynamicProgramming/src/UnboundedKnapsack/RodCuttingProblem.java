package UnboundedKnapsack;

public class RodCuttingProblem {
	
	public static int rodCutting(int arr[],int n,int N,int val[] ) {
		int[][] t = new int[n+1][N+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<N+1;j++) {
				if(n==0 || N==0) {
					t[i][j] = 0;
				}
			}
		}
		
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<N+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] = Math.max(val[i-1]+t[i][j-arr[i-1]], t[i-1][j]);
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][N];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {1,6,8,10};
		int val[]= {10,20,30,40};
		int n = arr.length;
		
		System.out.println(rodCutting(arr, n, 20, val));

	}

}
