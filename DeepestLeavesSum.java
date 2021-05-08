/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tal.LeetCode;

/**
 *
 */
public class DeepestLeavesSum {
    static class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
    int h = new DeepestLeavesSum().getHeight(root);
      //  System.out.println("height :"+h);
        System.out.println("sum:"+new DeepestLeavesSum().deepestLeavesSum(root));
    }
    class Int_var {
         public int sum=0;
    }
    int sum =0;
    int maxLevel =1;
    public int deepestLeavesSum(TreeNode root) {

        Int_var int_var = new Int_var();

        bestSolution(root,1,int_var);
//        int height = getHeight(root);
//        dfs(root,int_var,height,1);
        return  int_var.sum;
    }

    /**
     * Algo- in this algo we will be traversing only once to get seepest node sum.
     *        we will have 2 variable sum and max_level which will be storing sum
     *        of node value at max_level till now and max level of tree till now respectively.
     *        we will do dfs on tree and at each node will chech if this node level is greater then
     *        max_level ,if it we will update the value of max_level to this node level and sum to 0.
     *        if this node level is equal to max_level we will add this node's value to sum .
     * @param root
     * @param level
     * @param int_var
     */
    private void bestSolution(TreeNode root, int level, Int_var int_var) {
        if(root==null)
            return;
        if(level> maxLevel) {
            maxLevel = level;
            int_var.sum = 0;
        }
        if(maxLevel == level){
          //  System.out.print("maxlevel :"+maxLevel+" node: "+root.val);
                System.out.print("int_var:"+int_var.sum);
            int_var.sum += root.val;
        }
        bestSolution(root.left,level+1,int_var);
        bestSolution(root.right,level+1,int_var);

    }

    private void dfs(TreeNode root, Int_var int_var, int height, int curr_height) {
        if(root==null) return;
        if(height==curr_height){
            System.out.print(" equal height");
           int_var. sum += root.val;
        }

        dfs(root.left,int_var,height,curr_height+1);
        dfs(root.right,int_var,height,curr_height+1);
    }



    private int getHeight(TreeNode root) {
        if(root==null)return 0;
        int l = 1+getHeight(root.left);
        int r = 1+ getHeight(root.right);
        return Math.max(l,r);
    }
}
