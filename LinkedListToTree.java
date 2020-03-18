package TreeOnly;
import java.util.*;

/**
 * @author yadav97sunil
 *
 */
public class LinkedListToTree {
	    static llNode lhead;
	    static Queue<Tree> queue = new LinkedList<Tree>();
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        while (t-- > 0) {
	            Tree node = null;
	            lhead = null;
	            llNode head = null;
	            while (!queue.isEmpty()) {
	                queue.poll();
	            }
	            int n = sc.nextInt();
	            if (n != 0) {
	                LinkedListToTree llist = new LinkedListToTree();
	                int a1 = sc.nextInt();
	                head = new llNode(a1);
	                llist.addToTheLast(head);
	                lhead = head;
	                for (int i = 1; i < n; i++) {
	                    int a = sc.nextInt();
	                    llist.addToTheLast(new llNode(a));
	                }
	            }
	            GfG g = new GfG();
	            Tree root = g.convert(lhead, node);
	            try {
	                levelOrder(root, n);
	            } catch (NullPointerException ex) {
	                System.out.println(-1);
	            }
	            System.out.println();
	        }
	    }
	    public static void levelOrder(Tree root, int n) {
	        queue.add(root);
	        while (!queue.isEmpty() && n-- > 0) {
	            Tree proot = queue.remove();
	            try {
	                queue.add(proot.left);
	                queue.add(proot.right);
	                System.out.print(proot.data + " ");
	            } catch (NullPointerException ex) {
	            }
	        }
	    }
	    public void addToTheLast(llNode head) {
	        if (lhead == null)
	            lhead = head;
	        else {
	        	llNode temp = lhead;
	            while (temp.next != null) temp = temp.next;
	            temp.next = head;
	        }
	    }
	}// } Driver Code Ends
	class Tree{
	int data;
	    Tree left;
	    Tree right;
	    Tree(int d){
	        data=d;
	        left=null;
	        right=null;
	    }
	}

	class llNode {
	    int data;
	    llNode next;
	    llNode(int d) {
	        data = d;
	        next = null;
	    }
	}
	class GfG {
	    public static Tree convert(llNode head, Tree node) {
	        // add code here.}
	        if(head==null ) return node;
	                node = new Tree(head.data);
	                head = head.next;
	            //    return node;
	            Queue<Tree>q = new LinkedList<>();
	            q.offer(node);
	            while(head!=null){
	                Tree parent = q.poll();
	                Tree left=null,right=null;
	                left = new Tree(head.data);
	                q.offer(left);
	                head = head.next;
	                if(head!=null){
	                    right = new Tree(head.data);
	                    q.offer(right);
	                    head = head.next;
	                }
	                parent.left = left;
	                parent.right = right;
	            }
	            
	            return node;
	    }
	    
	}    
	    
