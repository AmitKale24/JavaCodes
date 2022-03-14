package UnboundedKnapsack;
import java.util.*;

public class CoinChangeMin {
	
	public static int coinChangeMin(int coin[],int n,int sum) {
		
		int[][] t = new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				
				//Initializing First Row and First Column
				if(i==0) {
					t[i][j] = Integer.MAX_VALUE-1;  //Store infinity
				}
				if(j==0) {
					t[i][j] = 0;
				}
				
				//Initializing Second row
				if(i==1) {
					for(i=1;j<sum+1;j++) {
						if(j%coin[0] == 0) {   //if 3/3 came
							t[i][j] = 1;
						}
						else { //if 4/3 came
							t[i][j] = Integer.MAX_VALUE-1; //Store Infinity
						}
					}
				}
				
				
			}
		}
		
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coin[i-1]<=j) {
					t[i][j] = Math.min(1+t[i][j-coin[i-1]], t[i-1][j]); //we add +1 because of Integer.MAX_VALUE-1
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int coin[] = {1,2,3};
		int sum = 5;
		int n = coin.length;
		
		System.out.println(coinChangeMin(coin, n, sum));

	}

}
