package InterviewBIt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextGreaterPermutation {

	public static void main(String[] args) {
	//	ArrayList<Integer>list = new ArrayList<Integer>() {{add(1);add(2);add(5);add(8);add(7);add(3);add(2);add(1);}};
		ArrayList<Integer>list = new ArrayList<Integer>() {{add(3);add(2);add(1);}};
		ArrayList<Integer>ans = nextPermutation(list);
		System.out.println(ans);
	}

	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> a) {
		int n = a.size();
		int i = n - 1;
		while (i > 0 && a.get(i) < a.get(i - 1))
			--i;
		if(i==0)
		{
			Collections.sort(a);
			return a;
		}
		int idx = i - 1;
		int val = a.get(idx);
		int[] ar = new int[n - i];
		for (int j = i; j < n; j++)
			ar[j - i] = a.get(j);
		Arrays.sort(ar);
//		for (int j = 0; j < ar.length; j++) {
//			System.out.print(ar[j] + " ");
//		}
		for (int j = 0; j < ar.length; j++) {
			if (ar[j] > val) {

				a.set(idx, ar[j]);
				ar[j] = val;
				break;
			}
		}
		int j = 0;
		while (i < n)
			a.set(i++, ar[j++]);
	//	System.out.println("i " + i + " j " + j);
		return a;
	}
}
