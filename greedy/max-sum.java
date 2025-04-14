package greedy;

class Solution {
    /*
     * TC - O(n), SC-O(1)
     * kadane's algorithm
     * 
     * if the sum is negative and you find a number that makes the sum +ve,
     * discarding the array uptil the element makes more sense.
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum= nums[0];
        for(int i=1; i<nums.length;i++){
            int num = nums[i];

            currSum = Math.max(num,currSum+num);
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
    }
}