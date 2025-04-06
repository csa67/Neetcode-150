package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
 */
class Solution {
    /*
     * Sorting and finding 2 numbers with 2 sum looping over arary for one other. O(n^2)
     * 
     * with the same complexity, you can also use hash set to find elements.
     */
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n-2 && nums[i]<=0;i++){
            if(i==0 || nums[i-1] != nums[i]){
                twoSum(nums,i,res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res ){
        int l = i+1;
        int h=nums.length-1;

        while(l<h){
            int sum = nums[i] +nums[l] + nums[h];
            if(sum == 0){
                res.add(Arrays.asList(nums[i],nums[l++],nums[h--]));
                while(l<h && nums[l] == nums[l-1]) l++; 
            }else if(sum > 0){
                h--;
                while(l<h && nums[h] == nums[h+1]) h--;
            }else{
                l++;
            }

        }
    }
}
