import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 	int t;
		Scanner input= new Scanner(System.in);
		t=input.nextInt();
		while(t-->0){
		    int n = input.nextInt();
		    int []ar = new int [n];
		    for(int i=0;i<n;i++)
		        ar[i] = input.nextInt();
		   System.out.println(usingHeap(ar,n));     
		}
	 }
	private static long usingHeap(int[] ar,int n ){
	       PriorityQueue<Integer> q  = new PriorityQueue<>();
		    for(int i= 0;i<n;i++)
		        q.offer(ar[i]);
		  long cost = 0;
		    while(!q.isEmpty()){
		        int min1 = q.remove();
		        if(q.isEmpty())break;
		        int min2 = q.remove();
		        cost += min1+min2;
		        q.offer(min1+min2);
		    }
		 return cost;
	} 
}
