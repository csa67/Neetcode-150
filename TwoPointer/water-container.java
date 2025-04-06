package TwoPointer;

/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container. ==> min height*width
 */
class Solution {
    /*
     * Bruteforce check every pair and return max area - O(n^2)
     * 
     * Better - 2 pointer.
     */
    public int maxArea(int[] nums){
        int maxarea = 0;
        int l = 0;
        int r = nums.length-1;

        while(l<r){
            int width = r-l;
            maxarea = Math.max(maxarea, Math.min(nums[l],nums[r])*width);
            if(nums[l] < nums[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxarea;

    }
    
}
