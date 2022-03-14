package EggDroppingProblem;

public class EggDroppingProblem {
	
	static int solve(int e,int f) {
		if(f==0 || f==1) {
			return 1;
		}
		if(e==0) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int k=1;k<=f;k++) {
			int temp = 1+ Math.max(solve(e-1,k-1),solve(e,f-k));
			min = Math.min(min, temp);
		}
		
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solve(3,5));

	}

}
