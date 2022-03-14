package KnapsackProblem;

public class EqualSumPartition {
	
	public static boolean equalSumPartition(int arr[], int n) {
		int sumofarray = 0;
		
		for(int i=0 ; i<n; i++) {
			sumofarray += arr[i];
		}
		boolean t[][] = new boolean[n+1][sumofarray/2 + 1];
		
		if(sumofarray%2 != 0) {
			return false;
		}
		
		
		
		else if(sumofarray%2 == 0){
			
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<sumofarray/2+1;j++) {
					if(i==0) {
						t[i][j] = false;
					}
					
					if(j==0) {
						t[i][j] = true;
					}
					
				}
			}
			
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<sumofarray/2+1;j++) {
					if(arr[i-1]<=j) {
						t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j]  ;
				    }
					else {
						  t[i][j]=t[i-1][j];
						  
					}
				}
			}
			
			
		}
		return t[n][sumofarray/2];
		
	}
	
	
	
	public static void main(String[] args) {
		
		int arr[] = {1,5,5,11};
	
		int n = arr.length;
		
		if (equalSumPartition(arr, n) == true) {
			System.out.println("Yes,Given Array can be divided into two subsets of equal sum.");
		}   
        else {
        	System.out.println("No,Given Array can not be divided into two subsets of equal sum!");
        }
            
    }
		
	
	}


