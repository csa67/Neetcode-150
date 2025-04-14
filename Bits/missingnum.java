package Bits;

class Solution{
    public int findMissingNumber(int[] nums){
        int n=nums.length;
        for(int i=0; i<n;i++){
            n^=(i^nums[i]);
        }

        return n;
    }
}
