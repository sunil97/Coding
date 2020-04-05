import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 	int t;
		Scanner sc= new Scanner(System.in);
		t=sc.nextInt();
		while(t-->0){
		    int n = sc.nextInt();
		    int []ar = new int[n];
		    for(int i=0;i<n;i++)
		        ar[i] = sc.nextInt();
		      // long result = Recuresive(ar,1,n-1); 
		        long result = DPWithoutOptimized(ar,n); 
		    System.out.println(result);
		}
	 }
	 
	 private static long DPWithoutOptimized(int []ar ,int n){
	     
	     //dp[i][j] ->store the min cost to multi matrices from i to j; 
	     long dp[][] = new long[n+1][n+1];
	     for(int i=0;i<=n;i++)
	        dp[i][i] = 0;
	        //l is for length.
	    for(int l =2;l<n;l++) {
	        
	        for(int i=1;i<(n-l+1);i++){
	            int j = i+l-1;
	            dp[i][j] = Long.MAX_VALUE;
	           for(int k=i;k<j;k++){
	               long q = dp[i][k]+dp[k+1][j]+ar[i-1]*ar[k]*ar[j]*1L;
	               dp[i][j]  = dp[i][j]<q?dp[i][j]:q;
	           } 
	        }
	    }  
	    return dp[1][n-1];
	 }
	                    // Recursive Solution.
// <!------------------------------------------------------------>	 
	private static long  Recuresive(int []ar ,int i,int j){
	    if(i==j) return 0;
	    long min = Long.MAX_VALUE;
	    for(int k =i;k<j;k++){
	        long count = Recuresive(ar,i,k)+Recuresive(ar,k+1,j)+
	                    ar[i-1]*ar[k]*ar[j]*1L;
	       min = min<count?min:count;             
	    }
	    return min;
	}
}
