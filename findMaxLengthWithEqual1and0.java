class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0)
                sum--;
            else
                sum++;
            if(map.containsKey(sum)){
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen,i-prevIndex);
            }
            else
                map.put(sum,i);
            // if till i  ind sum ==0 then len will be i+1;
           if(sum==0)
               maxLen = Math.max(maxLen,i+1);
        }
        return maxLen;
    }
}
