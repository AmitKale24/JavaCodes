package TakeUForward;

public class _23RodCuttingProblem {

	public static int recursion(int val[],int N,int ind) {
		if(ind == 0) {
			return N*val[ind];
		}
		
		int notTake = 0 + recursion(val, N, ind-1);
		int rodLength = ind+1;
		int take = 0;
		if(N>=rodLength) {
			take = val[ind] + recursion(val, N-rodLength, ind);
		}
		
		return Math.max(notTake, take);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int val[] = {2, 5 ,7, 8, 10};
		int N = 5;
		
		int ind = val.length;
		
		System.out.println(recursion(val, N, ind-1));

	}

}
