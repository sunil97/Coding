package dp;

import java.lang.Math;

public class PartionSetIntotwoSetwithMinimumDifference {

	public static void main(String[] args) {
		//int[] arr = { 5,10,15,20,25 };
		int[] arr = {3,1,4,2,2,1 };
		//partionIntwoSets(arr, arr.length, 0);
		int result =partionIntwoSetsDP(arr, arr.length, 0);
		System.out.println("result "+result);
	}

	private static int partionIntwoSetsDP(int[] arr, int length, int start) {
		int sum =0;
		for(int i=0;i<length;i++)
			sum+=arr[i];
		boolean[][] dp = new boolean[length+1][sum+1];
		for(int i=0;i<=length;i++)
			dp[i][0]=true;
		for(int i=1;i<=sum;i++)
			dp[0][i]=false;
		for(int i=1;i<=length;i++)
		{
			for(int j=1;j<=sum;j++){
				dp[i][j]=dp[i-1][j];
				if(arr[i-1]<=j){
					//System.out.println("inside if statement");
					dp[i][j]|=dp[i-1][j-arr[i-1]];
				}
				
			}
//				if(i==length)
//				[	System.out.println("i "+i);
		}
//		for(int i=0;i<=length;i++){
//		for(int k=0;k<=sum;k++)
//		{
//			System.out.print(dp[i][k]+" ");
//		}
//		System.out.println();
//		}
			
		int diff = Integer.MAX_VALUE;
		int val = 0;
		for(int i=sum/2;i>=0;i--)
			if(dp[length][i]==true){
				val = i;
				//System.out.println("i "+i);
				diff=sum-2*i;
				break;
			}
		//System.out.println("val "+val);
		return diff;
	}

	private static void partionIntwoSets(int[] arr, int length, int start) {
		int totalSum = 0;
		for (int i = 0; i < length; i++)
			totalSum += arr[i];
		int[] ans = new int[length];
		int min;
		ans[0] = totalSum - 2 * arr[0];
		min = ans[0];
		System.out.println("before algo ::" + ans[0]);
		for (int i = 1; i < length; i++) {
			int x =  min - (2 * arr[i]);
			int y = totalSum - 2 * arr[i];

			if (Math.abs(x) > Math.abs(y) & (min > y)) {

				min = y;
				ans[i] = y;
			} else if (Math.abs(x) < Math.abs(y) & (min > x)) {
				ans[i] = x;
				min = x;
			} else
				ans[i] = min;
			System.out.println("x :" + x + " y:" + y + " min :" + min);
		}
		System.out.println("min ::" + min);

		for (int i = 0; i < length; i++)
		        System.out.println(ans[i]);
	}

}
