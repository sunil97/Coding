class Solution {
    public int maxSubArray(int[] nums) {
        
         int n = nums.length;
        
       // <------------------------------------------------------------------->
       //          //dp solution
       // // dp[i] = maxSubArraySum till index i.
       // 
       //  int []dp = new int[n+1];
       //  dp[0] = 0;
       //  int max =Integer.MIN_VALUE;
       //  for(int i=1;i<=n;i++){
       //      dp[i] = Math.max(dp[i-1]+nums[i-1],nums[i-1]);//0-> if we are not including it.
       //      max = Math.max(max,dp[i]);
       //  }
       //  return max;
       // <------------------------------------------------------------------->
        
                    //  divide and conquere solution. 

        // <------------------------------------------------------------------->
        
        return divideAndConq(nums,0,n-1);
        
        
        // <------------------------------------------------------------------->
        
    }
    
    int divideAndConq(int []nums,int left,int right){
       
        if(left==right)      return nums[left];
            //this line we not work fine if all are -ve number .
            //  return nums[left]>0?nums[left]:0;
            
        int mid = left+(right-left)/2;
       int  leftSum = divideAndConq(nums,left,mid);
       int  rightSum = divideAndConq(nums,mid+1,right);
        int leftMaxBorderSum=Integer.MIN_VALUE,rightMaxBorderSum=Integer.MIN_VALUE;
        int leftBorderSum=0,rightBorderSum=0;
        for(int i=mid;i>=left;i--)
        {
            leftBorderSum+=nums[i];
            leftMaxBorderSum = Math.max(leftBorderSum,leftMaxBorderSum);
        }
        for(int j= mid+1;j<=right;j++){
            rightBorderSum+=nums[j];
            rightMaxBorderSum = Math.max(rightMaxBorderSum,rightBorderSum);
        }
        
        return rightSum>leftSum?Math.max(rightSum,rightMaxBorderSum+leftMaxBorderSum) :                                              Math.max(leftSum,rightMaxBorderSum+leftMaxBorderSum);
    }
}
