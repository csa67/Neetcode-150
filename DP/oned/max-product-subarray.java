package DP.oned;


class Solution {
    /*
     * If all the nums in the array are +ve, then total product is maximum.
     * If there is a negative num, the product could be reduced or max if there's another negative number.
     * If there is a zero, the chain is broken and we get a zero. 
     * 
     * So, for the cases of -ve and 0, we need to store the max product seen so far. (to get the max of positives)
     * but to keep a check of prev neg num, we need to store min product seen so far.
     * 
     * so, at every step we check max_so_far and min_so_far and update the result.
     */
    public int maxProduct(int[] nums) {
        
        int n=nums.length;
        if(n==1) return nums[0];

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int res = max_so_far;

        for(int i=1; i<n;i++){
            int num = nums[i];
            int temp_max = Math.max(
                num,
                Math.max(max_so_far*num,min_so_far*num)
            );

            min_so_far = Math.min(
                num,
                Math.min(max_so_far*num,min_so_far*num)
            );

            max_so_far = temp_max;
            res=Math.max(res,max_so_far);
        }

        return res;
      
    }
}
