package dp;

import java.util.HashMap;
import java.util.Map;

public class LargestIndependentSet {
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(50);
		root.right.right = new Node(60);
		root.left.right.left = new Node(70);
		root.left.right.right = new Node(80);
		Solution sol = new Solution();
		System.out.println(sol.LISS(root));
	
	}
}
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
	class Solution {
		Map<Node, Integer> map = new HashMap<>();

		public int LISS(Node root) {

			if (map.containsKey(root))
				return map.get(root);
			if (root == null) {
				map.put(root, 0);
				return 0;
			}
			//if root is not included in Independent Set.
			int exclude = 0;
			exclude += LISS(root.left) + LISS(root.right);
			// if root is included in independent set
			int include = 1;
			// + independent set received form all grandChildrens.
			if (root.left != null)
				include += LISS(root.left.left) + LISS(root.left.right);
			if (root.right != null)
				include += LISS(root.right.left) + LISS(root.right.right);
			int res = Math.max(exclude, include);
			map.put(root, res);
			return map.get(root);

		}
	}
/*	
 * private static int LISS(Node root) {
		if(root==null) return 0;
		int exclude=0;
		exclude+=LISS(root.left)+LISS(root.right);
		//if root is included in independent set 
		int include =1;
		//+ independent set received form all grandChildrens.
		if(root.left!=null)
			include += LISS(root.left.left) + LISS(root.left.right);
		if(root.right!=null)
			include+=LISS(root.right.left)+LISS(root.right.right);
		return Math.max(exclude, include);
	}
	*/

