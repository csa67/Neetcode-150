//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

/*
 *Can an array have zeroes? if yes, every element is 0, expect that one.
 */
class Solution{
    /*
     * Straight forward solution is to get the product and divide by each number if it's not zero. but without division?
     * 
     * approach 1: get left product and right product arrays
     */
    public int[] calcproduct1(int[] nums){
        int n = nums.length;

        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        leftProd[0] = 1;
        rightProd[n-1] =1; 

        for(int i=1; i<n;i++){
            leftProd[i] = leftProd[i-1] *nums[i-1];
            rightProd[n-i-1] = rightProd[n-i]*nums[n-i];
        }

        int[] res = new int[n];
        for(int i=0; i<n;i++){
            res[i] = leftProd[i] * rightProd[i];
        }
        
        return res;
    }

    /*
     * But this has O(n) extra space complexity with O(n) time complexity with 2 passes.
     * Turns out, we can do better than this by reducing the space complexity to O(1) by getting left and right products directly on the array
     * without extra array space.
     */
    public int[] calcproduct2(int[] nums){
        int n = nums.length;

        int[] res = new int[n];
        
        res[0] = 1;
        for(int i=1; i<n;i++){
            res[i] = res[i-1] *nums[i-1];
        }
        
        int R =1; 
        for(int i=n-1; i>=0;i--){
            res[i] *= R;
            R*=nums[i];
        }
        
        return res;
    }

}