package dp;

import java.lang.Math;

public class PartionSetIntotwoSetwithMinimumDifference {

	public static void main(String[] args) {
		//int[] arr = { 5,10,15,20,25 };
		int[] arr = {3,1,4,2,2,1 };
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
					dp[i][j]|=dp[i-1][j-arr[i-1]];
				}	
			}
		}	
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
}
