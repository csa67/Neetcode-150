package DP.oned;

class Solution {
    /*Houses are arranged circularly, so do a linear search twice for 0 to n-1 and 1 to n and get the max of both.
     * 
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
    
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }
    
    private int robLinear(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n + 2]; // pad to avoid bounds
    
        for (int i = end; i >= start; i--) {
            dp[i - start] = Math.max(nums[i] + dp[i - start + 2], dp[i - start + 1]);
        }
    
        return dp[0];
    }
    
    //Space optimized version
    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
    
        return Math.max(robLinear2(nums, 0, n - 2), robLinear2(nums, 1, n - 1));
    }
    
    private int robLinear2(int[] nums, int start, int end) {
        int robNext = 0, robNextPlusOne = 0;
    
        for (int i = end; i >= start; i--) {
            int current = Math.max(nums[i] + robNextPlusOne, robNext);
            robNextPlusOne = robNext;
            robNext = current;
        }
    
        return robNext;
    }
    
}
