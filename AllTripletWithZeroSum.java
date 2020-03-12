package dp;

import java.util.HashSet;
import java.util.Set;


//Do it Again And Practice on  hashing 
public class AllTripletWithZeroSum {

	public static void main(String[] args) {
		int []arr= {0,-1,2,-3,1};
	
		for(int i=0;i<arr.length-1;i++) {
			Set<Integer>set = new HashSet<>();
			for(int j=i+1;j<arr.length;j++) {
				//the idea behind this algo is hashing.
				//we add a[i] and a[j] and find for -(a[i]+a[j]) in hashTable .
				//if we find it hr=en print it else insert it into table;
				int x = -(arr[i]+arr[j]);
				if(set.contains(x)) {
					System.out.println(arr[i]+" "+arr[j]+" "+(x));
				}else
					set.add(arr[j]);
			}
		}
	}

}
